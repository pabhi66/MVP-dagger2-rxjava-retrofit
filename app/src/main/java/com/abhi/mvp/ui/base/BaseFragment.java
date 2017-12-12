package com.abhi.mvp.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
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

    /**
     * attach view for presenter (i.e. presenter.attachView(this))
     */
    protected abstract void attachView();

    /**
     * detach view for presenter (i.e. presenter.detachView();
     */
    protected abstract void detachPresenter();

    @Override
    public void onDestroy() {
        detachPresenter();
        super.onDestroy();
    }
}
