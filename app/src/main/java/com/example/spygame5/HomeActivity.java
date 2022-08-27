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
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    // declaration 
    // buttons
    private Button playersPlus_btn;
    private Button playersMinus_btn;
    private Button spiesPlus_btn;
    private Button spiesMinus_btn;
    private Button timerPlus_btn;
    private Button timerMinus_btn;
    private Button startGame_btn;

    // textView
    private TextView numOfPlayers_tv;
    private TextView numOfSpies_tv;
    private TextView timer_tv;

    // checkbox
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // inflate
        // button
        playersPlus_btn = findViewById(R.id.playersPlus_id);
        playersMinus_btn = findViewById(R.id.playersMinus_id);
        spiesPlus_btn = findViewById(R.id.spiesPlus_id);
        spiesMinus_btn = findViewById(R.id.spiesMinus_id);
        timerPlus_btn = findViewById(R.id.timerPlus_id);
        timerMinus_btn = findViewById(R.id.timerMinus_id);
        startGame_btn = findViewById(R.id.start_btn_id);

        // textView
        numOfPlayers_tv = findViewById(R.id.numOfPlayers_id);
        numOfSpies_tv = findViewById(R.id.numOfSpies_id);
        timer_tv = findViewById(R.id.timer_id);

        // checkBox
        checkBox1 = findViewById(R.id.checkBox1_id);
        checkBox2 = findViewById(R.id.checkBox2_id);
        checkBox3 = findViewById(R.id.checkBox3_id);
        checkBox4 = findViewById(R.id.checkBox4_id);


        // get data from database and, set it into Game attributes
        Game.getDataFromDatabase();
        // put data on the view elements
        Game.prepareElements(numOfPlayers_tv, numOfSpies_tv, timer_tv);
        // handling  home activity events
        Game.homeEvents(numOfPlayers_tv, numOfSpies_tv, timer_tv, playersPlus_btn, playersMinus_btn, spiesPlus_btn, spiesMinus_btn, timerPlus_btn, timerMinus_btn, checkBox1, checkBox2, checkBox3, checkBox4, startGame_btn);
        // start game
        startGame_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // System.out.println("Categories = "+checkedCategories.size());
                if (Game.getCheckedCategories().size() > 0) {
                    // change background color of start button
                    startGame_btn.setBackgroundColor(startGame_btn.getResources().getColor(R.color.valid));
                    Game.generateRandomInfo();
                    Intent i = new Intent(startGame_btn.getContext(), tapActivtiy.class);
                    startActivityForResult(i, 1);
                } else {
                    Toast.makeText(getBaseContext(), "Choose at least one Category ", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        if(resultCode == tapActivtiy.TAP_RESULT_CODE_CASE1){
//////            Game.homeEvents(numOfPlayers_tv,numOfSpies_tv,timer_tv,playersPlus_btn,playersMinus_btn,spiesPlus_btn,spiesMinus_btn,timerPlus_btn,timerMinus_btn,checkBox1,checkBox2,checkBox3,checkBox4,startGame_btn);
////
////        }
//
//    }
//}

}