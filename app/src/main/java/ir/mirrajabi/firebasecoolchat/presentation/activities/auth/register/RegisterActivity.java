package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.mirrajabi.firebasecoolchat.GlobalApplication;
import ir.mirrajabi.firebasecoolchat.R;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.DaggerRegisterComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.RegisterModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.helpers.FormsHelper;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login.LoginActivity;
import ir.mirrajabi.firebasecoolchat.presentation.activities.main.MainActivity;
import ir.mirrajabi.firebasecoolchat.presentation.base.BaseActivity;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {
    @BindView(R.id.txt_email)
    EditText mTxtEmail;
    @BindView(R.id.txt_password)
    EditText mTxtPassword;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        DaggerRegisterComponent.builder()
                .applicationComponent(((GlobalApplication)getApplication()).getApplicationComponent())
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(R.string.loading);
        mProgressDialog.setMessage(getString(R.string.please_wait));

    }

    @OnClick(R.id.btn_register)
    void performRegister(){
        if(FormsHelper.isFormFilled(mTxtEmail, mTxtPassword))
            getPresenter().registerWithEmailAndPassword(getEmail(), getPassword());
    }

    @OnClick(R.id.txt_login)
    void goToLoginActivity(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.hide();
    }

    @Override
    public void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private String getEmail(){
        return mTxtEmail.getText().toString();
    }

    private String getPassword(){
        return mTxtPassword.getText().toString();
    }
}