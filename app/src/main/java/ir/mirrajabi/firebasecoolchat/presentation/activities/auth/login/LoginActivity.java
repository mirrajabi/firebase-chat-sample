package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login;

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
import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.DaggerLoginComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.LoginModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.helpers.FormsHelper;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register.RegisterActivity;
import ir.mirrajabi.firebasecoolchat.presentation.activities.main.MainActivity;
import ir.mirrajabi.firebasecoolchat.presentation.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {
    @BindView(R.id.txt_email)
    EditText mTxtEmail;
    @BindView(R.id.txt_password)
    EditText mTxtPassword;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        DaggerLoginComponent.builder()
                .applicationComponent(((GlobalApplication)getApplication()).getApplicationComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(R.string.loading);
        mProgressDialog.setMessage(getString(R.string.please_wait));
        getPresenter().checkIfLoggedIn();
    }

    @OnClick(R.id.txt_register)
    void goToRegisterActivity(){
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @OnClick(R.id.btn_login)
    void performRegister(){
        if(FormsHelper.isFormFilled(mTxtEmail, mTxtPassword))
            getPresenter().loginWithEmailAndPassword(getEmail(), getPassword());
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
