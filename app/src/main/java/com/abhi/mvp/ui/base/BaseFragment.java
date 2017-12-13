package com.abhi.mvp.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.mvp.App;
import com.abhi.mvp.injection.components.ConfigPersistentComponent;
import com.abhi.mvp.injection.components.DaggerConfigPersistentComponent;
import com.abhi.mvp.injection.components.FragmentComponent;
import com.abhi.mvp.injection.modules.FragmentModule;

import java.util.concurrent.atomic.AtomicLong;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 *
 * Abstract Fragment that every other Fragment in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent are kept
 * across configuration changes.
 */
public abstract class BaseFragment extends Fragment {

    private static final String KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID";
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);

    private long fragmentId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the FragmentComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        fragmentId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_FRAGMENT_ID)
                        : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(fragmentId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", fragmentId);
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                            .appComponent(App.get(getActivity()).getAppComponent())
                            .build();
            componentsArray.put(fragmentId, configPersistentComponent);
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", fragmentId);
            configPersistentComponent = componentsArray.get(fragmentId);
        }
        // FragmentComponent fragmentComponent =
            //    configPersistentComponent.fragmentComponent(new FragmentModule(this));
        // inject(fragmentComponent);
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Layout resource to be inflated
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentView();

    protected abstract void inject(FragmentComponent fragmentComponent);

    /**
     * attach view for presenter (i.e. presenter.attachView(this))
     */
    protected abstract void attachView();

    /**
     * detach view for presenter (i.e. presenter.detachView();
     */
    protected abstract void detachPresenter();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_FRAGMENT_ID, fragmentId);
    }

    @Override
    public void onDestroy() {
        if (!getActivity().isChangingConfigurations()) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", fragmentId);
            componentsArray.remove(fragmentId);
        }
        detachPresenter();
        super.onDestroy();
    }
}