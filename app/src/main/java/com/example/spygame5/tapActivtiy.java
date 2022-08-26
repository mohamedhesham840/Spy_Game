package com.example.spygame5;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tapActivtiy extends AppCompatActivity {

    // used to get indexing players list
    private int index;
    // request code (for intents)
    // used to determine which activity you back from ( get automatically on request code parameter in " onActivityResult() " method
    private final int LOCAL_CARD_REQUEST_CODE = 1;
    private final int SPY_CARD_REQUEST_CODE   = 2;

    // view elements
    private   Button displayDetail_btn;
    private   TextView playerName_tv;

    // put extra
    public static final String PLAYER_INDEX = "player index";

    // -------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_activtiy);
        getSupportActionBar().hide();   // make the app full screen


        // inflate
        displayDetail_btn = findViewById(R.id.displayDetail_button_id);
        playerName_tv   = findViewById(R.id.playerName_textView_id);

        // refer to first player
        index = 0;

        // players take turns , so each on should see his/her name
        playerName_tv.setText(Game.getPlayers()[index].getName());

        // navigation to spy card, or local card(depend on player rule)
        displayDetail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Game.getPlayers()[index].getRole() == Player.PLAYER_ROLE_LOCAL){// this will navigate to local activity
                    Intent toLocalCard = new Intent(getBaseContext(), LocalCardActivity.class);
                    toLocalCard.putExtra(PLAYER_INDEX, index++);
                    startActivityForResult(toLocalCard,LOCAL_CARD_REQUEST_CODE );
                }
                else if(Game.getPlayers()[index].getRole() == Player.PLAYER_ROLE_SPY){// this will navigate to spy activity
                    Intent toSpyCard = new Intent(getBaseContext(), spyCardActivity.class);
                    toSpyCard.putExtra(PLAYER_INDEX, index++);
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

        // check if all players took cards,
        // if so should navigate to timer activity
        if(index < Game.getNumOfPlayers()){
            // display the player name who should pick a card
            playerName_tv.setText(Game.getPlayers()[index].getName());
        }
        else{
            Intent toTimerActivity = new Intent(getBaseContext(), timerActivity.class);
            startActivity(toTimerActivity);
            finish();// close the activity

        }


    }
}