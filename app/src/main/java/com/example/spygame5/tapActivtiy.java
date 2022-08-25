package com.example.spygame5;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tapActivtiy extends AppCompatActivity {

    // declaration
    int  index;
    final int LOCAL_CARD_REQUEST_CODE = 1;
    final int SPY_CARD_REQUEST_CODE = 2;
    Button displayDetail_btn;
    TextView playerName_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_activtiy);


        index = 0;

        // inflate
        displayDetail_btn = findViewById(R.id.displayDetail_button_id);
        playerName_tv     = findViewById(R.id.playerName_textView_id);


        playerName_tv.setText(Game.getPlayers()[index].getName());
        // navigation
        displayDetail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Game.getPlayers()[index].getRole() == Player.PLAYER_ROLE_LOCAL){
                    Intent toLocalCard = new Intent(getBaseContext(), LocalCardActivity.class);
                    toLocalCard.putExtra("player index", index++);
                    startActivityForResult(toLocalCard,LOCAL_CARD_REQUEST_CODE );
                }
                else if(Game.getPlayers()[index].getRole() == Player.PLAYER_ROLE_SPY){
                    Intent toSpyCard = new Intent(getBaseContext(), spyCardActivity.class);
                    toSpyCard.putExtra("player index", index++);
                    startActivityForResult(toSpyCard,SPY_CARD_REQUEST_CODE);
                }
            }
        });


    }


    // this method called on activity life cycle when you back from the target activity
    /* ex:
           activityA --> activityB
           when you back
           activityB --> activityA
           onActivityResult() called
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(index < Game.getNumOfPlayers()){
            playerName_tv.setText(Game.getPlayers()[index].getName());
        }
        else{
            Intent toTimerActivity = new Intent(getBaseContext(), timerActivity.class);
            startActivity(toTimerActivity);
            finish();// close the activity

        }


    }
}