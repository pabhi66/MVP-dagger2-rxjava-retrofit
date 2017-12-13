package com.abhi.mvp.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.abhi.mvp.injection.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Module(includes = {ApiModule.class})
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    @ApplicationContext
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences("PREF_FILE_NAME", Context.MODE_PRIVATE);
    }
}
