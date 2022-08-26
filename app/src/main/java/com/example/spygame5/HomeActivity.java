//package com.example.spygame5;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.TextView;
//
//public class HomeActivity extends AppCompatActivity {
//
//
//
//
//    // buttons
//    final Button start_btn       = findViewById(R.id.start_btn_id);
//    final Button playersPlus_btn = findViewById(R.id.playersPlus_id);
//    final Button playersMinus_btn= findViewById(R.id.playersMinus_id);
//    final Button spiesPlus_btn   = findViewById(R.id.spiesPlus_id);
//    final Button spiesMinus_btn  = findViewById(R.id.spiesMinus_id);
//    final Button timerPlus_btn   = findViewById(R.id.timerPlus_id);
//    final Button timerMinus_btn  = findViewById(R.id.timerMinus_id);
//
//    // text views
//    TextView numOfPlayers_tv= findViewById(R.id.numOfPlayers_id);
//    TextView numOfSpies_tv  = findViewById(R.id.numOfSpies_id);
//    TextView timer_tv       = findViewById(R.id.timer_id);
//    // checkBox
//    CheckBox checkBox1_check= findViewById(R.id.checkBox1_id);
//    CheckBox checkBox2_check= findViewById(R.id.checkBox2_id);
//    CheckBox checkBox3_check= findViewById(R.id.checkBox3_id);
//    CheckBox checkBox4_check= findViewById(R.id.checkBox4_id);
//
//
//
//
//    //--------------------
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        // inflate
//
//
//
//        // events
////        TextView players_txt, TextView spies , TextView Time, Button plus_player, Button mines_player, Button plus_spy, Button mines_spy, Button plus_time, Button mines_time, CheckBox countries, CheckBox places, CheckBox objects, CheckBox geography, Button start
//        Game.homeEvents(numOfPlayers_tv, numOfSpies_tv,timer_tv,playersPlus_btn, playersMinus_btn,spiesPlus_btn,spiesMinus_btn , timerPlus_btn, timerMinus_btn,checkBox1_check, checkBox2_check, checkBox3_check, checkBox4_check,start_btn );
//
//        start_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent temp = Game.generateGameIntent(getBaseContext(), tapActivtiy.class);
//
//                startActivity(temp);
//            }
//        });
//
//
//    }
//}


package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    static TextView players_txt;
    static TextView spies;
    static TextView Time;
    static Button plus_player;
    static Button mines_player;
    static Button plus_spy;
    static Button mines_spy;
    static Button plus_time;
    static Button mines_time;
    static CheckBox countries;
    static CheckBox places;
    static CheckBox objects;
    static CheckBox geography;
    static Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        players_txt=findViewById(R.id.numOfPlayers_id);
        spies=findViewById(R.id.numOfSpies_id);
        Time=findViewById(R.id.timer_id);
        plus_player=findViewById(R.id.playersPlus_id);
        mines_player=findViewById(R.id.playersMinus_id);
        plus_spy=findViewById(R.id.spiesPlus_id);
        mines_spy=findViewById(R.id.spiesMinus_id);
        plus_time=findViewById(R.id.timerPlus_id);
        mines_time=findViewById(R.id.timerMinus_id);
        countries=findViewById(R.id.checkBox1_id);
        places=findViewById(R.id.checkBox2_id);
        objects=findViewById(R.id.checkBox3_id);
        geography=findViewById(R.id.checkBox4_id);
        start=findViewById(R.id.start_btn_id);



        Game.homeEvents(players_txt,spies,Time,plus_player,mines_player,plus_spy,mines_spy,plus_time,mines_time,countries,places,objects,geography,start);
        Game.prepareElements(players_txt,spies,Time);

    }


}