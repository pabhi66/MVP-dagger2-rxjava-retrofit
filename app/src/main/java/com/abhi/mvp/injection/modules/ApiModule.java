package com.abhi.mvp.injection.modules;

import com.abhi.mvp.data.api.PostServicesInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    PostServicesInterface postServicesInterface(Retrofit retrofit) {
        return retrofit.create(PostServicesInterface.class);
    }
}
