package com.abhi.mvp.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.abhi.mvp.injection.scopes.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }

}
