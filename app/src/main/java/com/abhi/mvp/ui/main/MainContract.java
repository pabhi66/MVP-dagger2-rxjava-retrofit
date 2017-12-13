package com.abhi.mvp.ui.main;

import com.abhi.mvp.data.model.Post;
import com.abhi.mvp.ui.base.BaseMvpPresenter;
import com.abhi.mvp.ui.base.BaseView;

import java.util.List;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 *
 * This is the signature of our feature. We group methods under two domains.
 * 1) Presenter interface includes all user actions. (click, swipe, delete etc.)
 * 2) View interface includes all callbacks and UI changes (show loading, populate a list,
 *      show connection error etc.)
 */

public class MainContract {

    // Action callbacks. Activity/Fragment will implement
    interface Presenter extends BaseMvpPresenter<View> {
        void loadPosts();
    }

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }
}
