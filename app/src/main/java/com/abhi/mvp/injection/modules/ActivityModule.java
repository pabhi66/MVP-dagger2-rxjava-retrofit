package com.abhi.mvp.injection.modules;

import android.app.Activity;
import android.content.Context;
import com.abhi.mvp.injection.scopes.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * The type Activity module.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Module
public class ActivityModule {

    private Activity activity;

    /**
     * Instantiates a new Activity module.
     *
     * @param activity the activity
     */
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Provide activity activity.
     *
     * @return the activity
     */
    @Provides
    Activity provideActivity() {
        return activity;
    }

    /**
     * Provides context context.
     *
     * @return the context
     */
    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }
}