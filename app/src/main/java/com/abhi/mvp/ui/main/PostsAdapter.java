package com.abhi.mvp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.mvp.R;
import com.abhi.mvp.data.response.Post;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/16/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> postsList;
    private Subject<Post> postClickSubject;

    @Inject
    PostsAdapter() {
        postsList = Collections.emptyList();
        postClickSubject = PublishSubject.create();
    }

    public void setPosts(List<Post> posts) {
        this.postsList = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = this.postsList.get(position);
        holder.onBind(post);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    Observable<Post> getPostClick() {
        return postClickSubject;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private Post post;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(v -> postClickSubject.onNext(post));
        }

        void onBind(Post post) {
            this.post = post;

        }
    }
}
