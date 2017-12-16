package com.abhi.mvp.ui.base;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/16/17.
 *
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the BaseView type that wants to be attached with.
 */

public interface Presenter<V extends BaseView> {

    /**
     * Called when view attached to presenter
     *
     * @param view
     */
    void attachView(V view);

    /**
     * Called when view is detached from presenter
     */
    void detachView();

    /**
     * @return true if view is attached to presenter
     */
    boolean isViewAttached();

    /**
     * @return view
     */
    V getView();
}
