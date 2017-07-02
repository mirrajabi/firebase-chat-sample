package ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.mirrajabi.firebasecoolchat.GlobalApplication;
import ir.mirrajabi.firebasecoolchat.R;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.DaggerEditProfileComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.EditProfileModule;
import ir.mirrajabi.firebasecoolchat.presentation.base.BaseActivity;

public class EditProfileActivity extends BaseActivity<EditProfilePresenter>
        implements EditProfileView {
    @BindView(R.id.txt_email)
    EditText mTxtEmail;

    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        DaggerEditProfileComponent.builder()
                .applicationComponent(((GlobalApplication) getApplication()).getApplicationComponent())
                .editProfileModule(new EditProfileModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(R.string.loading);
        mProgressDialog.setMessage(getString(R.string.please_wait));
        getPresenter().fetchCurrentEmail();
    }

    @OnClick(R.id.btn_submit)
    void submit() {
        getPresenter().submitNewMail(mTxtEmail.getText().toString());
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
    public void bindEmail(String email) {
        mTxtEmail.setText(email);
    }
}
