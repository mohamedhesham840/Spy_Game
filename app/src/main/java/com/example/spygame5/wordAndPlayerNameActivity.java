package com.example.spygame5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class wordAndPlayerNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_and_player_name);
        getSupportActionBar().hide();   // make the app full screen

    }
}