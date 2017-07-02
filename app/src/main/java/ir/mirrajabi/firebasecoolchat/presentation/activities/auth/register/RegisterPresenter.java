package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

import javax.inject.Inject;

import ir.mirrajabi.firebasecoolchat.presentation.base.BasePresenter;

public class RegisterPresenter implements BasePresenter {
    private RegisterView mView;
    private FirebaseAuth mAuth;
    private Context mContext;

    @Inject
    public RegisterPresenter(RegisterView view, FirebaseAuth auth, Context context) {
        mView = view;
        mAuth = auth;
        mContext = context;
    }

    void registerWithEmailAndPassword(String email, String password) {
        mView.showLoading();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    mView.hideLoading();
                    if(task.isSuccessful()) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(email.substring(0,email.indexOf("@"))).build();
                        mAuth.getCurrentUser()
                                .updateProfile(request)
                                .addOnCompleteListener(task1 -> mView.goToMainActivity());
                    }
                    else {
                        Toast.makeText(mContext, "Register was not successful.\n" +
                                task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        task.getException().printStackTrace();
                    }
                });
    }
}
