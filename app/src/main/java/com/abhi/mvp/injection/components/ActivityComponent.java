package com.abhi.mvp.injection.components;

import com.abhi.mvp.ui.main.MainActivity;
import com.abhi.mvp.injection.modules.ActivityModule;
import com.abhi.mvp.injection.scopes.PerActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activity across the application
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 *
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * Inject.
     *
     * @param mainActivity the main activity
     */
    void inject(MainActivity mainActivity);
}
