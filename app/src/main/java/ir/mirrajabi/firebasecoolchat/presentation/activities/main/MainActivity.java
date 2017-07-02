package ir.mirrajabi.firebasecoolchat.presentation.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.mirrajabi.firebasecoolchat.GlobalApplication;
import ir.mirrajabi.firebasecoolchat.R;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.DaggerMainComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.MainModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.models.ChatMessage;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login.LoginActivity;
import ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile.EditProfileActivity;
import ir.mirrajabi.firebasecoolchat.presentation.adapters.ChatMessageAdapter;
import ir.mirrajabi.firebasecoolchat.presentation.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.rv_messages)
    RecyclerView mRecyclerView;
    @BindView(R.id.txt_message)
    EditText mTxtMessage;

    private ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .applicationComponent(((GlobalApplication)getApplication()).getApplicationComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);
        mAdapter = new ChatMessageAdapter(R.layout.item_chat_message);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        getPresenter().updateChat();
    }

    @Override
    public void goToLoginPage() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void addChatMessage(ChatMessage message) {
        mAdapter.addData(message);
        mTxtMessage.setText("");
    }

    @OnClick(R.id.btn_send)
    void sendMessage(){
        getPresenter().sendMessage(mTxtMessage.getText().toString());
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        for (DataSnapshot msgSnapshot: dataSnapshot.getChildren()) {
            addChatMessage(msgSnapshot.getValue(ChatMessage.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                getPresenter().logout();
                break;
            case R.id.edit_profile:
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
