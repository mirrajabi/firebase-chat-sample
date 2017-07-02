package ir.mirrajabi.firebasecoolchat.presentation.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import ir.mirrajabi.firebasecoolchat.R;
import ir.mirrajabi.firebasecoolchat.infrastructure.models.ChatMessage;

public class ChatMessageAdapter extends BaseQuickAdapter<ChatMessage, BaseViewHolder> {

    public ChatMessageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatMessage item) {
        helper.setText(R.id.txt_username, item.toString());
    }
}
