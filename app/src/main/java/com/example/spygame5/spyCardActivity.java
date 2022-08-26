package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class spyCardActivity extends AppCompatActivity {


    //
    private Button   next_btn     ;
    private TextView playerNote_tv;
    private TextView playerRule_tv;

    // store getIntExtra content(player index)
    private int index;

    // used if there's different cases of backing to previous activity
    public static final int RESULT_CODE_CASE1 = 1;

    //-------------------*------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spy_card);
        getSupportActionBar().hide();   // make the app full screen

        // inflate
        next_btn     = findViewById(R.id.spyNext_button_id);
        playerNote_tv= findViewById(R.id.spyNote_textView_id);
        playerRule_tv= findViewById(R.id.spyRule_textView_id);

        // used to get data ( we need index from the previous activity)
        Intent data = getIntent();
        index = data.getIntExtra(tapActivtiy.PLAYER_INDEX, -1);


        if(index != -1) {


            //messages for the player
            playerRule_tv.setText("u are a spy"); // temp
            playerNote_tv.setText(Game.getSpyPlayerNote());

            //navigate to tap activity
            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // back to tapActivity
                    setResult(RESULT_CODE_CASE1);
                    // close the activity
                    finish();

                }
            });


        }


    }
}