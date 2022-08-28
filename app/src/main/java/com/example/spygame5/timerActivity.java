package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class timerActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private static long  Time      ;
    private TextView    timer_view ;
    private ImageButton start_timer;
    private ImageButton reset_timer;
    private ImageButton  stop_timer ;
    private Button  skipToResult_btn;
    private boolean timerRunning;
    public static boolean audioState =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        getSupportActionBar().hide(); // make the app full screen

        // stop and release media player
        if(MainActivity.audioPlaying == true){
            Toast.makeText(this, "Sound has stopped, so that players can talk", Toast.LENGTH_SHORT).show();
        }
        MainActivity.audioStop();


//        timerRunning   = false;
        Intent extra = getIntent();
        audioState = extra.getBooleanExtra("audio", false);
        // inflate
        Time       = Game.getTime()*60*1000;
        timer_view =findViewById(R.id.textView3);
        start_timer=findViewById(R.id.onStop_id);
        reset_timer=findViewById(R.id.imageButton4);
        stop_timer =findViewById(R.id.onPlay_id);
        skipToResult_btn=findViewById(R.id.skipToResult_button_id);

        timer_view.setText(String.valueOf(Game.getTime())+":"+"00");

        // result event
        skipToResult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetTimer();
                Intent intent = new Intent(getBaseContext(), FinalCardSpyName.class);
                startActivity(intent);
                finish();
            }
        });

        // timer events
        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("test");
                if(timerRunning)
                {
                    StopTimer();
//                    System.out.println("in timer = true");
                }
                else
                {
                    StartTimer();
//                    System.out.println("in timer = false");

                }

            }
        });

        // -------------------

        stop_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopTimer();
            }
        });

        // -------------------

        reset_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ResetTimer();


            }

        });



    }

    // ------------------methods----------------

    public  void StartTimer()
    {
        countDownTimer=new CountDownTimer(Time, 1000) {
            @Override
            public void onTick(long l) {
                Time=l;
                UpdateCounterText();
            }

            @Override
            public void onFinish() {
                timerRunning=false;
                Intent i = new Intent(getBaseContext(), FinalCardSpyName.class);
                startActivity(i);
                finish();


            }
        }.start();
        timerRunning=true;
        start_timer.setVisibility(View.INVISIBLE);
        stop_timer.setVisibility (View.VISIBLE);




    }

    public  void UpdateCounterText()
    {
        int minutes=(int) (Time/1000)/60;
        int second=(int) (Time/1000)%60;
        String timeLeftFormatted=  String.format(Locale.getDefault(),"%02d:%02d",minutes,second);
        timer_view.setText(timeLeftFormatted);

    }
    public void StopTimer()
    {
        countDownTimer.cancel();
        timerRunning=false;
        stop_timer.setVisibility(View.INVISIBLE);
        start_timer.setVisibility(View.VISIBLE);
    }
    public void ResetTimer() {
        if (timerRunning) {
            countDownTimer.cancel();
            Time = Game.getTime() * 60 * 1000;

            UpdateCounterText();
            stop_timer.setVisibility(View.INVISIBLE);
            start_timer.setVisibility(View.VISIBLE);

            timerRunning = false;
        } else {
            Time = Game.getTime() * 60 * 1000;

            UpdateCounterText();


            // timerRunning=false;
        }

    }
}