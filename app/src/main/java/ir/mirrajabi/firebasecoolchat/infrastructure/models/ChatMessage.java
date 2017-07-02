package ir.mirrajabi.firebasecoolchat.infrastructure.models;

import android.text.format.DateUtils;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Calendar;

@IgnoreExtraProperties
public class ChatMessage {
    private String message;
    private String userName;
    private long time;

    public ChatMessage() {
    }

    public String getMessage() {
        return message;
    }

    public ChatMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ChatMessage setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public long getTime() {
        return time;
    }

    public ChatMessage setTime(long time) {
        this.time = time;
        return this;
    }

    @Exclude
    @Override
    public String toString() {
        return "[ " + getUserName() + " at " +
                DateUtils.getRelativeTimeSpanString(getTime(),
                        Calendar.getInstance().getTime().getTime(), DateUtils.SECOND_IN_MILLIS) +
                "] : " + getMessage();
    }
}
