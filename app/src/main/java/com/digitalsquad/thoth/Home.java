package com.digitalsquad.thoth;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Home extends Activity {

    private EditText messageET;
    private ListView messagesContainer;
    private ImageButton sendBtn;
    private ChatAdapter adapter;
    private ArrayList<MessageData> chatHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initControls();
    }

    private void initControls() {
        messagesContainer = (ListView) findViewById(R.id.mainlist);
        messageET = (EditText) findViewById(R.id.chat);
        sendBtn = (ImageButton) findViewById(R.id.send);
        messagesContainer.setDivider(null);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.contain);
        loadDummyHistory();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageET.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                MessageData chatMessage = new MessageData();
                chatMessage.setId(122);//dummy
                chatMessage.setMessage(messageText);
                chatMessage.setMe(true);
                messageET.setText("");
                displayMessage(chatMessage);
            }
        });
    }

    public void displayMessage(MessageData message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }

    private void loadDummyHistory(){

        chatHistory = new ArrayList<MessageData>();

        MessageData msg = new MessageData();
        msg.setId(2);
        msg.setMe(false);
        msg.setMessage("Hi");

        chatHistory.add(msg);
        MessageData msg1 = new MessageData();
        msg1.setId(2);
        msg1.setMe(false);
        msg1.setMessage("How r u doing???");
        chatHistory.add(msg1);

        adapter = new ChatAdapter(Home.this, new ArrayList<MessageData>());
        messagesContainer.setAdapter(adapter);

        for(int i=0; i<chatHistory.size(); i++) {
            MessageData message = chatHistory.get(i);
            displayMessage(message);
        }

    }
}
