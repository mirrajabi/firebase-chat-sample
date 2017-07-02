package ir.mirrajabi.firebasecoolchat.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public abstract class BaseActivity<P extends BasePresenter>
        extends AppCompatActivity implements BaseView {
    @Inject P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public P getPresenter() {
        return mPresenter;
    }
}
