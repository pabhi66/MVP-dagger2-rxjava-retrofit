package com.abhi.mvp.injection.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.abhi.mvp.injection.scopes.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * The type Fragment module.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    /**
     * Instantiates a new Fragment module.
     *
     * @param fragment the fragment
     */
    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * Provides fragment fragment.
     *
     * @return the fragment
     */
    @Provides
    Fragment providesFragment() {
        return fragment;
    }

    /**
     * Provide activity activity.
     *
     * @return the activity
     */
    @Provides
    Activity provideActivity() {
        return fragment.getActivity();
    }

    /**
     * Provides context context.
     *
     * @return the context
     */
    @Provides
    @ActivityContext
    Context providesContext() {
        return fragment.getActivity();
    }
}
