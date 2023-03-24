package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit_text);
        TextView textView = findViewById(R.id.text_view);
        Button button = findViewById(R.id.send_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();
                String botResponse = getBotResponse(userInput);
                textView.setText(botResponse);
            }
        });
    }

    private String getBotResponse(String userInput) {
        String[] prePreparedSentences = getResources().getStringArray(R.array.bot_responses);
        String[] botResponses = getResources().getStringArray(R.array.bot_responses);

        for (int i = 0; i < prePreparedSentences.length; i++) {
            if (userInput.equals("hello")) {
                return botResponses[0];
            }else if (userInput.equals("ok")) {
                return botResponses[1];
            }else if (userInput.equals("nice to meet you")) {
                return botResponses[2];
            } else if (userInput.equals("sorry")) {
                return botResponses[3];
            } else if (userInput.equals("that sounds good")) {
                return botResponses[4];
            } else if (userInput.equals("you ok?")) {
                return botResponses[5];
            }
        }

        return "I'm sorry, I didn't understand what you said.";
    }

}