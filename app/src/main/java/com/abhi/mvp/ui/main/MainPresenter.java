package com.abhi.mvp.ui.main;

import com.abhi.mvp.data.DataManager;
import com.abhi.mvp.data.model.Post;
import com.abhi.mvp.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private final DataManager dataManager;

    @Inject
    MainPresenter(DataManager dataManager){
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void loadPosts() {

        checkViewAttached();
        dataManager
                .getPosts()
                .subscribe(posts -> {
                    for(Post post : posts) {
                        System.out.println(post);
                    }
                }, throwable -> {

                });

    }
}
