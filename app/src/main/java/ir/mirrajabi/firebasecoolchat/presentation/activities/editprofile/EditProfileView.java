package ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile;

import ir.mirrajabi.firebasecoolchat.presentation.base.BaseView;

public interface EditProfileView extends BaseView {
    void finish();
    void showLoading();
    void hideLoading();
    void bindEmail(String email);
}
