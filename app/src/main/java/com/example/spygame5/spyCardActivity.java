package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class spyCardActivity extends AppCompatActivity {


    //
    private Button   next_btn     ;
    private TextView playerNote_tv;
    private TextView playerRule_tv;
    private ImageView spyBackHome_imgView;
    private ImageView audioPlay_tv;
    private ImageView audioPause_tv;


    // store getIntExtra content(player index)
    private int index;

    // used if there's different cases of backing to previous activity
    // case 1: next
    // case 2: back to home
    public static final int RESULT_CODE_CASE1 = 1;
    public static final int RESULT_CODE_CASE2 = 2;



    //-------------------*------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spy_card);
        getSupportActionBar().hide();   // make the app full screen

        // inflate
        audioPlay_tv  = findViewById(R.id.spyAudioPlay_id);
        audioPause_tv = findViewById(R.id.spyAudioPause_id);
        next_btn     = findViewById(R.id.spyNext_button_id);
        spyBackHome_imgView = findViewById(R.id.spyBackHome_imgView_id);

        // used to get data ( we need index from the previous activity)
        Intent data = getIntent();
        index = data.getIntExtra(tapActivtiy.PLAYER_INDEX, -1);


        if(index != -1) {


            // sound buttons
            if(MainActivity.audioPlaying){

                audioPlay_tv.setVisibility(View.VISIBLE);
                audioPause_tv.setVisibility(View.INVISIBLE);
            }else{
                audioPlay_tv.setVisibility(View.INVISIBLE);
                audioPause_tv.setVisibility(View.VISIBLE);
            }

            //messages for the player
//            playerRule_tv.setText("u are a spy"); // temp
//            playerNote_tv.setText(Game.getSpyPlayerNote());


            //----------------------------events----------------------------

            audioPlay_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioPlay_tv.setVisibility(View.INVISIBLE);
                    audioPause_tv.setVisibility(View.VISIBLE);
                    MainActivity.audioPause();

                }
            });
            audioPause_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioPlay_tv.setVisibility(View.VISIBLE);
                    audioPause_tv.setVisibility(View.INVISIBLE);
                    MainActivity.audioPlay();
                }
            });

            // back to home activity
            spyBackHome_imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // back to tapActivity
                    setResult(RESULT_CODE_CASE2);
                    // close the activity
                    finish();
                }
            });

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