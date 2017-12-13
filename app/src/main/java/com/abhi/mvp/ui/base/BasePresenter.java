package com.abhi.mvp.ui.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 *
 * Each presenter should have attachView()/detachView() methods to bind the view
 * to the presenter. If an asynchronous job is done we have to check if view is attached or not.
 * So we also need a isViewAttached() method.
 *
 * Also view is defined as generic class extends BaseView.
 * By doing this we tell the presenter that it should attach a view that extends the BaseView.
 */

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public V getView() {
        if(isViewAttached()) {
            return view;
        } else {
            throw new ViewNotAttachedException();
        }
    }

    private static class ViewNotAttachedException extends RuntimeException {
        ViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before"
                    + " requesting data to the Presenter");
        }
    }


}
