package ir.mirrajabi.firebasecoolchat.presentation.activities.main;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import javax.inject.Inject;

import ir.mirrajabi.firebasecoolchat.infrastructure.models.ChatMessage;
import ir.mirrajabi.firebasecoolchat.presentation.base.BasePresenter;

import static ir.mirrajabi.firebasecoolchat.infrastructure.helpers.Constants.FIREBASE_DB_CHATS;

public class MainPresenter implements BasePresenter {
    private MainView mView;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mFirebaseAuth;

    @Inject
    public MainPresenter(MainView view, Context context, FirebaseDatabase firebaseDatabase,
                         FirebaseAuth firebaseAuth) {
        mView = view;
        mContext = context;
        mFirebaseDatabase = firebaseDatabase;
        mFirebaseAuth = firebaseAuth;
    }

    void sendMessage(String message){
        ChatMessage chatMessage = new ChatMessage()
                .setMessage(message)
                .setUserName(mFirebaseAuth.getCurrentUser().getEmail())
                .setTime(Calendar.getInstance().getTime().getTime());
        mFirebaseDatabase.getReference()
                .child(FIREBASE_DB_CHATS)
                .push()
                .setValue(chatMessage)
        .addOnSuccessListener(o -> mView.addChatMessage(chatMessage))
        .addOnFailureListener(e ->
                Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    void updateChat(){
        mFirebaseDatabase.getReference().addChildEventListener(mView);
    }

    void logout(){
        mFirebaseAuth.signOut();
        mView.goToLoginPage();
    }
}
