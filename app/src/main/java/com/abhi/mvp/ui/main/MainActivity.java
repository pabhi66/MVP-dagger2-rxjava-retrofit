package com.abhi.mvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abhi.mvp.R;
import com.abhi.mvp.data.model.Post;
import com.abhi.mvp.ui.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity implements MainContract.View {

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void attachView() {
        mainPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        mainPresenter.detachView();
    }

    @Override
    public void showPosts(List<Post> posts) {
        
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
