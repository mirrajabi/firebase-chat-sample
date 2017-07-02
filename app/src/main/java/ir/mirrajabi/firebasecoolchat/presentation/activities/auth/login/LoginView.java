package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login;

import ir.mirrajabi.firebasecoolchat.presentation.base.BaseView;

public interface LoginView extends BaseView {
    void showLoading();
    void hideLoading();
    void goToMainActivity();
}
