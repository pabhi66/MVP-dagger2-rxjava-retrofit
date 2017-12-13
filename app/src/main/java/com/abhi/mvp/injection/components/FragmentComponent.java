package com.abhi.mvp.injection.components;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

import com.abhi.mvp.injection.modules.FragmentModule;
import com.abhi.mvp.injection.scopes.PerFragment;
import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
