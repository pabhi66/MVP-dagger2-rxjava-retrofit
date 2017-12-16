package com.abhi.mvp.injection.components;

import android.app.Application;
import android.content.Context;

import com.abhi.mvp.data.DataManager;
import com.abhi.mvp.injection.modules.AppModule;
import com.abhi.mvp.injection.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface App component.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    /**
     * Context context.
     *
     * @return the context
     */
    @ApplicationContext
    Context context();

    /**
     * Application application.
     *
     * @return the application
     */
    Application application();

    /**
     * Api manager data manager.
     *
     * @return the data manager
     */
    DataManager apiManager();
}
