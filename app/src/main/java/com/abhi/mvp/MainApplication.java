package com.abhi.mvp;

import android.app.Application;
import android.content.Context;
import com.abhi.mvp.injection.components.AppComponent;
import com.abhi.mvp.injection.components.DaggerAppComponent;
import com.abhi.mvp.injection.modules.AppModule;
import com.abhi.mvp.injection.modules.NetworkModule;
import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;
import timber.log.Timber;

/**
 * The type Main application.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
public class MainApplication extends Application {

    private AppComponent appComponent;

    /**
     * Get main application.
     *
     * @param context the context
     * @return the main application
     */
    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();
        }
    }

    /**
     * Gets component.
     *
     * @return the component
     */
    public AppComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule(this, BuildConfig.API_URL))
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    /**
     * Sets component.
     * Needed to replace the component with a test specific one
     * @param appComponent the app component
     */
    public void setComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
