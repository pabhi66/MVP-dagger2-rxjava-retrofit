package com.abhi.mvp.ui.main;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.abhi.mvp.R;
import com.abhi.mvp.data.response.Post;
import com.abhi.mvp.injection.components.FragmentComponent;
import com.abhi.mvp.ui.base.BaseFragment;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements MainContract.View {

    @Inject
    PostsAdapter postsAdapter;

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public MainActivityFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(postsAdapter);
        postClicked();
        mainPresenter.getPosts();
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
        postsAdapter.setPosts(posts);
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(Throwable error) {

    }

    @Override
    public void postClicked() {
        Disposable disposable =
                postsAdapter.getPostClick()
                    .subscribe(post -> {
                        Toast.makeText(getContext(), post.getTitle(), Toast.LENGTH_SHORT).show();
                        // to start new activity
                        // startActivity(DetailActivity.getStartIntent(this, post)),
                    }, throwable -> {
                        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
                    });
        mainPresenter.addDisposable(disposable);
    }
}
