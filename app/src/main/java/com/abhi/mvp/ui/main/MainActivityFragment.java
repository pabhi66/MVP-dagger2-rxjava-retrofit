package com.abhi.mvp.ui.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.mvp.R;
import com.abhi.mvp.data.response.Post;
import com.abhi.mvp.injection.components.FragmentComponent;
import com.abhi.mvp.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements MainContract.View {

    @Inject
    MainPresenter mainPresenter;

    public MainActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        mainPresenter.getPosts();
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
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
        for(Post p : posts) {
            System.out.println(p.getTitle());
        }
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(Throwable error) {

    }
}
