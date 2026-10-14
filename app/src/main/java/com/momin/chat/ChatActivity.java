package com.momin.chat;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends Activity {

    private LinearLayout messagesLayout;
    private EditText messageInput;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(7, 94, 84));
        getWindow().setNavigationBarColor(Color.rgb(7, 94, 84));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(245, 247, 248));

        TextView header = new TextView(this);
        header.setText("Momin Chat");
        header.setTextSize(23);
        header.setTextColor(Color.WHITE);
        header.setPadding(20, 20, 20, 20);
        header.setBackgroundColor(Color.rgb(7, 94, 84));

        scrollView = new ScrollView(this);
        messagesLayout = new LinearLayout(this);
        messagesLayout.setOrientation(LinearLayout.VERTICAL);
        messagesLayout.setPadding(16, 16, 16, 16);

        TextView welcome = new TextView(this);
        welcome.setText(
            "Momin Chat mein khush aamdeed!\n\n" +
            "Yahan aapki chat nazar aayegi.\n" +
            "Messages bhejne ke liye Firebase connection " +
            "aglay marhalay mein jora jayega."
        );
        welcome.setTextSize(16);
        welcome.setTextColor(Color.DKGRAY);
        messagesLayout.addView(welcome);

        scrollView.addView(messagesLayout);

        LinearLayout composer = new LinearLayout(this);
        composer.setPadding(8, 8, 8, 8);
        composer.setGravity(Gravity.CENTER_VERTICAL);

        messageInput = new EditText(this);
        messageInput.setHint("Message likhein...");
        messageInput.setSingleLine(true);

        composer.addView(messageInput,
            new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        Button sendButton = new Button(this);
        sendButton.setText("Send");
        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();

            if (message.isEmpty()) {
                Toast.makeText(this,
                    "Pehle message likhein",
                    Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this,
                "Abhi Firebase connection baqi hai",
                Toast.LENGTH_LONG).show();
        });

        composer.addView(sendButton);

        root.addView(header);
        root.addView(scrollView,
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
        root.addView(composer);

        setContentView(root);
    }
          }
