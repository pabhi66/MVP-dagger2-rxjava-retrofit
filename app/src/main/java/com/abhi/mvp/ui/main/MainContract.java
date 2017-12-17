package com.abhi.mvp.ui.main;

import com.abhi.mvp.data.response.Post;
import com.abhi.mvp.ui.base.BaseView;
import com.abhi.mvp.ui.base.Presenter;

import java.util.List;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/16/17.
 */

class MainContract {

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {

        void showPosts(List<Post> posts);

        void showProgress(boolean show);

        void showError(Throwable error);

        void postClicked();
    }

    interface Presenter extends com.abhi.mvp.ui.base.Presenter<View> {
        void getPosts();
    }

}
