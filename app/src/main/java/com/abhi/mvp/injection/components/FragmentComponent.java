package com.abhi.mvp.injection.components;

import com.abhi.mvp.ui.main.MainActivityFragment;
import com.abhi.mvp.injection.modules.FragmentModule;
import com.abhi.mvp.injection.scopes.PerFragment;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * Inject.
     *
     * @param mainActivityFragment the main activity fragment
     */
    void inject(MainActivityFragment mainActivityFragment);
}
