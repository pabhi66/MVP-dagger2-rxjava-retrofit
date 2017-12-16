package com.abhi.mvp.injection.modules;

import com.abhi.mvp.data.remote.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The type Api module.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Module(includes = {NetworkModule.class})
public class ApiModule {

    /**
     * Provide api service api service.
     *
     * @param retrofit the retrofit
     * @return the api service
     */
    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
