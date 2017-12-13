package com.abhi.mvp.injection.components;

import android.app.Application;
import android.content.Context;

import com.abhi.mvp.injection.modules.AppModule;
import com.abhi.mvp.injection.scopes.ApplicationContext;

import javax.inject.Singleton;
import dagger.Component;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

}
