package com.abhi.mvp;

import android.app.Application;
import android.content.Context;

import com.abhi.mvp.injection.components.AppComponent;
import com.abhi.mvp.injection.components.DaggerAppComponent;
import com.abhi.mvp.injection.modules.AppModule;
import com.abhi.mvp.injection.modules.NetworkModule;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            LeakCanary.install(this);
        }

        appComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule(this))
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    // needed to replace the component with a test specific one
    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
