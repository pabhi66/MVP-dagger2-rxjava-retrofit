package com.abhi.mvp.data;

import com.abhi.mvp.data.api.PostServicesInterface;
import com.abhi.mvp.data.model.Post;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/13/17.
 */

@Singleton
public class DataManager {

    private PostServicesInterface postServicesInterface;

    @Inject
    public DataManager(PostServicesInterface postServicesInterface) {
        this.postServicesInterface = postServicesInterface;
    }

    public Single<List<Post>> getPosts() {
        return postServicesInterface
                .getPosts()
                .toObservable()
                .toList();
    }

    public Single<Post> getPost(int id) {
        return postServicesInterface.getPost(id);
    }
}
