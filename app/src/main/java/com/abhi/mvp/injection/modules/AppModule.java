package com.abhi.mvp.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.abhi.mvp.injection.scopes.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * The type App module.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Module(includes = {ApiModule.class})
public class AppModule {

    private final Application application;

    /**
     * Instantiates a new App module.
     *
     * @param application the application
     */
    public AppModule(Application application) {
        this.application = application;
    }

    /**
     * Provide application application.
     *
     * @return the application
     */
    @Provides
    Application provideApplication() {
        return application;
    }

    /**
     * Provide context context.
     *
     * @return the context
     */
    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    /**
     * Provide shared preference shared preferences.
     *
     * @param context the context
     * @return the shared preferences
     */
    @Provides
    @ApplicationContext
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences("PREF_FILE_NAME", Context.MODE_PRIVATE);
    }
}
