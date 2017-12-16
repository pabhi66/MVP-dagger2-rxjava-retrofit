package com.abhi.mvp.data;

import com.abhi.mvp.data.remote.ApiService;
import com.abhi.mvp.data.response.Post;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * The type Data manager.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
@Singleton
public class DataManager {

    private ApiService apiService;

    /**
     * Instantiates a new Data manager.
     *
     * @param apiService the api service
     */
    @Inject
    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Gets posts.
     *
     * @return the posts
     */
    public Single<List<Post>> getPosts() {
        return apiService.getPosts();
    }

    /**
     * Gets post.
     *
     * @param id the id
     * @return the post
     */
    public Single<Post> getPost(int id) {
        return apiService.getPost(id);
    }
}
