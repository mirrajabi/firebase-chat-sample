package ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import ir.mirrajabi.firebasecoolchat.presentation.base.BasePresenter;

public class LoginPresenter implements BasePresenter {
    private LoginView mView;
    private FirebaseAuth mAuth;
    private Context mContext;

    @Inject
    public LoginPresenter(LoginView view, FirebaseAuth auth, Context context) {
        mView = view;
        mAuth = auth;
        mContext = context;
    }

    void loginWithEmailAndPassword(String email, String password){
        mView.showLoading();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    mView.hideLoading();
                    if(task.isSuccessful())
                        mView.goToMainActivity();
                    else {
                        Toast.makeText(mContext, "Login was not successful.\n" +
                                task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        task.getException().printStackTrace();
                    }
                });
    }

    void checkIfLoggedIn(){
        if(mAuth.getCurrentUser() != null){
            mView.goToMainActivity();
        }
    }
}
