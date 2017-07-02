package ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

import javax.inject.Inject;

import ir.mirrajabi.firebasecoolchat.presentation.base.BasePresenter;

public class EditProfilePresenter implements BasePresenter {
    private EditProfileView mView;
    private FirebaseAuth mFirebaseAuth;

    @Inject
    public EditProfilePresenter(EditProfileView view, FirebaseAuth firebaseAuth) {
        mView = view;
        mFirebaseAuth = firebaseAuth;
    }

    void submitNewMail(String email) {
        mView.showLoading();
        mFirebaseAuth.getCurrentUser()
                .updateEmail(email)
                .addOnSuccessListener(o -> {
                    mView.hideLoading();
                    mView.finish();
                })
                .addOnFailureListener(e -> e.printStackTrace());
    }
    void fetchCurrentEmail(){
        mView.bindEmail(mFirebaseAuth.getCurrentUser().getEmail());
    }
}
