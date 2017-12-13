package com.abhi.mvp.injection.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.abhi.mvp.injection.scopes.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment providesFragment() {
        return fragment;
    }

    @Provides
    Activity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return fragment.getActivity();
    }
}
