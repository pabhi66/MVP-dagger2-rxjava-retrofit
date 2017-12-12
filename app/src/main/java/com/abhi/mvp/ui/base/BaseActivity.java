package com.abhi.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView()); // set layout file
        ButterKnife.bind(this); // bind view
        attachView();
    }

    /**
     * Layout resource to be inflated
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentView();

    /**
     * attach view for presenter (i.e. presenter.attachView(this))
     */
    protected abstract void attachView();

    /**
     * detach view for presenter (i.e. presenter.detachView();
     */
    protected abstract void detachPresenter();

    @Override
    protected void onDestroy() {
        detachPresenter();
        super.onDestroy();
    }
}
