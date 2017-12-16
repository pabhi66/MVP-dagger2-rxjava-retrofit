package com.abhi.mvp.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.abhi.mvp.R;
import com.abhi.mvp.data.response.Post;
import com.abhi.mvp.injection.components.ActivityComponent;
import com.abhi.mvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;
import butterknife.BindView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {
    }

    @Override
    protected void detachPresenter() {
    }
}
