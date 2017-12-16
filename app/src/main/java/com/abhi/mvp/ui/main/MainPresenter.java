package com.abhi.mvp.ui.main;

import com.abhi.mvp.data.DataManager;
import com.abhi.mvp.ui.base.BasePresenter;
import com.abhi.mvp.utils.rx.scheduler.SchedulerUtils;

import javax.inject.Inject;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/16/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private final DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getPosts() {
        checkViewAttached();
        getView().showProgress(true);

        dataManager.getPosts()
                .compose(SchedulerUtils.ioToMain())
                .subscribe(posts -> {
                    getView().showProgress(false);
                    getView().showPosts(posts);
                }, throwable -> {
                    getView().showProgress(false);
                    getView().showError(throwable);
                });
    }
}
