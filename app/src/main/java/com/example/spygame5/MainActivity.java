package com.example.spygame5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //declarations
    private ImageView info_imv;
    private  ImageView log_imv;
    private TextView  rules_tv;

    private boolean   visible = false; // for appear/disappear rules text view

    // audio
    private  static MediaPlayer mediaPlayer;
    private static ImageView audioPlay_tv;
    private static ImageView audioPause_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();   // make the app full screen

        // inflate
        info_imv= findViewById(R.id.info_id);
        log_imv = findViewById(R.id.log_id);
        rules_tv= findViewById(R.id.rules_id) ;
        audioPause_tv= findViewById(R.id.audioPause_id);
        audioPlay_tv =findViewById(R.id.audioPlay_id);

        // events
        // navigate to home activity
        log_imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),HomeActivity.class);
                startActivity(i);

            }
        });

        // display on/off the game rule
        info_imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!visible)
                {
                    rules_tv.setVisibility(View.VISIBLE);
                    visible = true;
                }
                else
                {
                    rules_tv.setVisibility(View.INVISIBLE);
                    visible = false;

                }

            }
        });


    }

    public static void audioPlay(View v){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.audio2);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        audioPause_tv.setVisibility(View.INVISIBLE);
        audioPlay_tv.setVisibility(View.VISIBLE);



    }

    public static void audioPause(View v){
    if(mediaPlayer != null){
        mediaPlayer.pause();
        audioPause_tv.setVisibility(View.VISIBLE);
        audioPlay_tv.setVisibility(View.INVISIBLE);
    }
    }
    public static void audioStop(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        audioPause_tv.setVisibility(View.VISIBLE);
        audioPlay_tv.setVisibility(View.INVISIBLE);
    }

}