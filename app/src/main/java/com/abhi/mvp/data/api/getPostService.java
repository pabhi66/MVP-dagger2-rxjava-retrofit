package com.abhi.mvp.data.api;

import com.abhi.mvp.data.model.Post;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 */

public interface getPostService {

    @GET("/posts")
    Single<Post> getPosts();

    @GET("/posts/{id}")
    Single<Post> getPost(@Path("id") int id);

}