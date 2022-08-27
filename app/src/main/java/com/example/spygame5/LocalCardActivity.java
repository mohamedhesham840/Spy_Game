package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LocalCardActivity extends AppCompatActivity {

    // declaration
    private Button   next_btn     ;
    private TextView playerNote_tv;
    private TextView playerRule_tv;
    private ImageView localBackHome_imgView;

    // store getIntExtra content(player index)
    private int index ;

    // used if there's different cases of backing to previous activity
    // case 1: next
    // case 2: back to home
    public static final int RESULT_CODE_CASE1 = 1;
    public static final int RESULT_CODE_CASE2 = 2;




    //-------------------*------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_card);
        getSupportActionBar().hide();   // make the app full screen


        // inflate
        next_btn     = findViewById(R.id.localNext_button_id);
        playerNote_tv= findViewById(R.id.localNote_textView_id);
        playerRule_tv= findViewById(R.id.localRule_textView_id);
        localBackHome_imgView = findViewById(R.id.localBackHome_imgView_id);
        // used to get data ( we need index from the previous activity)
        Intent data = getIntent();
        index = data.getIntExtra(tapActivtiy.PLAYER_INDEX, -1);


        // check if getIntExtra return correct data or not
        if(index != -1) {

            //display messages for the player
//            playerRule_tv.setText(Game.getCatLocations()[Game.getCategoryIndex()][Game.getLocationsIndex()]);
//            playerNote_tv.setText(Game.getLocalPlayerNote());


            //----------------------------events----------------------------
            localBackHome_imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // back to tapActivity
                    setResult(RESULT_CODE_CASE2);
                    // close the activity
                    finish();
                }
            });
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