package com.abhi.mvp.data.remote;

import com.abhi.mvp.data.response.Post;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The interface Api service.
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
public interface ApiService {

    /**
     * Gets posts.
     *
     * @return the posts
     */
    @GET("/posts")
    Single<List<Post>> getPosts();

    /**
     * Gets post.
     *
     * @param id the id
     * @return the post
     */
    @GET("/posts/{id}")
    Single<Post> getPost(@Path("id") int id);
}
