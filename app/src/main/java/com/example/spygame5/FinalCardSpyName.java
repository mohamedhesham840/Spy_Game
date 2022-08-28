package com.example.spygame5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FinalCardSpyName extends AppCompatActivity {

    // declaration elements
    private  TextView  resultMessage_tv  ;
    private  ImageView backHome_imgButton;
    private  ListView  listView          ;

    // spies list
    private ArrayList<String> spies=new ArrayList<>();
    // all players list
    private Player player[] =Game.getPlayers();
    MediaPlayer resultMedia;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_card_spy_name);
        getSupportActionBar().hide();   // make the app full screen


        if(timerActivity.audioState){
            resultMedia = MediaPlayer.create(getBaseContext(), R.raw.result);
            resultMedia.start();
        }

        // inflate
        resultMessage_tv  = findViewById(R.id.resultHeader_id);;
        backHome_imgButton= findViewById(R.id.backHome_imgButton_id);
        listView          = findViewById(R.id.result_listView_id);

        // choose between two messages
//        if(Game.getNumOfSpies()>1)
//            resultMessage_tv.setText("Spies are");
//        else
//            resultMessage_tv.setText("Spy is");

            resultMessage_tv.setText("Spy List");


        // put spy players on spies list
        for(int i=0;i<Game.getNumOfPlayers();i++){
            if(player[i].getRole().equals(Player.PLAYER_ROLE_SPY)){
                String name=player[i].getName();
                spies.add(name);

            }

        }

        // prepare adapter & display in listView
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.row,spies);
        listView.setAdapter(arrayAdapter);



        // navigate to home activity
        backHome_imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),HomeActivity.class);
                if(timerActivity.audioState) {
                    resultMedia.release();
                    resultMedia = null;
                    MainActivity.audioPlay();

                }
                startActivity(i);
            }
        });


    }
}


