package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpyCardActivity extends AppCompatActivity {
    // declaration
    Button next_btn;
    TextView playerNote_tv;
    TextView playerRule_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spy_card2);

        next_btn      = findViewById(R.id.spyNext_button_id);
        playerNote_tv = findViewById(R.id.spyNote_textView_id);
        playerRule_tv = findViewById(R.id.spyRule_textView_id);

        // on onCreate method
        Intent data = getIntent();
        int index = data.getIntExtra("player index", -1);
        if(index != -1) {

            playerRule_tv.setText("u are a spy"); // temp
            playerNote_tv.setText(Game.getSpyPlayerNote());

            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    setResult(2);
                    finish();// close the activity


                }
            });


        }


    }
}