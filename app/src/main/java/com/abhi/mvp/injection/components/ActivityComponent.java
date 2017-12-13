package com.abhi.mvp.injection.components;

import com.abhi.mvp.injection.modules.ActivityModule;
import com.abhi.mvp.injection.scopes.PerActivity;
import com.abhi.mvp.ui.main.MainActivity;
import dagger.Subcomponent;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
