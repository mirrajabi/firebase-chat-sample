package ir.mirrajabi.firebasecoolchat.presentation.activities.main;

import com.google.firebase.database.ChildEventListener;

import ir.mirrajabi.firebasecoolchat.infrastructure.models.ChatMessage;
import ir.mirrajabi.firebasecoolchat.presentation.base.BaseView;

public interface MainView extends BaseView, ChildEventListener {
    void goToLoginPage();
    void addChatMessage(ChatMessage message);
}
