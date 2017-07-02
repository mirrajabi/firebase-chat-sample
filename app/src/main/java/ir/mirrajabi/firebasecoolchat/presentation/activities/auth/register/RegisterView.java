package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register;

import ir.mirrajabi.firebasecoolchat.presentation.base.BaseView;

public interface RegisterView extends BaseView {
    void showLoading();
    void hideLoading();
    void goToMainActivity();
}
