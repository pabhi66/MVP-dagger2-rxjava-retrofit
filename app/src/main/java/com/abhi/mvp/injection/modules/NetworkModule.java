package com.abhi.mvp.injection.modules;

import android.content.Context;

import com.abhi.mvp.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.readystatesoftware.chuck.ChuckInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * The type Network module.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Module
public class NetworkModule {

    private final Context context;
    private final String baseUrl;

    /**
     * Instantiates a new Network module.
     *
     * @param context the context
     * @param baseUrl the base url
     */
    public NetworkModule(final Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    /**
     * Provide retrofit retrofit.
     *
     * @param okHttpClient the ok http client
     * @param gson         the gson
     * @return the retrofit
     */
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * Provide ok http client ok http client.
     *
     * @param httpLoggingInterceptor the http logging interceptor
     * @param stethoInterceptor      the stetho interceptor
     * @param chuckInterceptor       the chuck interceptor
     * @return the ok http client
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     StethoInterceptor stethoInterceptor,
                                     ChuckInterceptor chuckInterceptor) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(chuckInterceptor);
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
            httpClientBuilder.addNetworkInterceptor(stethoInterceptor);
        }
        return httpClientBuilder.build();
    }

    /**
     * Provide http logging interceptor http logging interceptor.
     *
     * @return the http logging interceptor
     */
    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor(message -> Timber.d(message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    /**
     * Provide stetho interceptor stetho interceptor.
     *
     * @return the stetho interceptor
     */
    @Provides
    @Singleton
    StethoInterceptor provideStethoInterceptor() {
        return new StethoInterceptor();
    }

    /**
     * Provide chuck interceptor chuck interceptor.
     *
     * @return the chuck interceptor
     */
    @Provides
    @Singleton
    ChuckInterceptor provideChuckInterceptor() {
        return new ChuckInterceptor(context);
    }

    /**
     * Provide gson gson.
     *
     * @return the gson
     */
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
}
