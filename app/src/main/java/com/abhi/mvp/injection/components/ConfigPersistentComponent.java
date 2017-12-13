package com.abhi.mvp.injection.components;

import com.abhi.mvp.injection.modules.ActivityModule;
import com.abhi.mvp.injection.modules.FragmentModule;
import com.abhi.mvp.injection.scopes.ConfigPersistent;

import dagger.Component;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 *
 *
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't be
 * destroy during configuration changes. Check {@link com.abhi.mvp.ui.base.BaseActivity} and {@link com.abhi.mvp.ui.base.BaseFragment} to see
 * how this components survives configuration changes. Use the {@link ConfigPersistent} scope to
 * annotate dependencies that need to survive configuration changes (for example Presenters).
 */

@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}
