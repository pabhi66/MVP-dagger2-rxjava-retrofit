package com.abhi.mvp.ui.base;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.abhi.mvp.MainApplication;
import com.abhi.mvp.R;
import com.abhi.mvp.injection.components.ActivityComponent;
import com.abhi.mvp.injection.components.ConfigPersistentComponent;
import com.abhi.mvp.injection.components.DaggerConfigPersistentComponent;
import com.abhi.mvp.injection.modules.ActivityModule;
import java.util.concurrent.atomic.AtomicLong;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Abstract activity that every other Activity in this application must implement.
 * It provides the following functionality: - Handles creation of Dagger components and makes
 * sure that instances of ConfigPersistentComponent are kept across configuration changes.
 * - Set up and handles a GoogleApiClient instance that can be used to access the
 * Google sign in api. - Handles signing out when an authentication error event is received.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();

    private long activityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        activityId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_ACTIVITY_ID)
                        : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(activityId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", activityId);
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                            .appComponent(MainApplication.get(this).getComponent())
                            .build();
            componentsArray.put(activityId, configPersistentComponent);
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", activityId);
            configPersistentComponent = componentsArray.get(activityId);
        }
        ActivityComponent activityComponent =
                configPersistentComponent.activityComponent(new ActivityModule(this));
        inject(activityComponent);
        attachView();
    }

    /**
     * Gets layout.
     *
     * @return the layout
     */
    protected abstract int getLayout();

    /**
     * Inject.
     *
     * @param activityComponent the activity component
     */
    protected abstract void inject(ActivityComponent activityComponent);

    /**
     * Attach view.
     */
    protected abstract void attachView();

    /**
     * Detach presenter.
     */
    protected abstract void detachPresenter();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, activityId);
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", activityId);
            componentsArray.remove(activityId);
        }
        detachPresenter();
        super.onDestroy();
    }
}
