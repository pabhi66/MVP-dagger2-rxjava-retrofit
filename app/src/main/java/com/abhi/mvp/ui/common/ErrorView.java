package com.abhi.mvp.ui.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.abhi.mvp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/12/17.
 */

public class ErrorView extends LinearLayout {

    public interface ErrorListener {
        void onReloadData();
    }

    private ErrorListener errorListener;

    public ErrorView(Context context) {
        super(context);
        init();
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(getContext()).inflate(R.layout.view_error, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_reload)
    public void onReloadButtonClick() {
        if (errorListener != null) {
            errorListener.onReloadData();
        }
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }

}
