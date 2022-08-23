package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocalPlayerCard extends AppCompatActivity {
    // declaration
        Button next_btn;
        TextView playerNote_tv;
        TextView playerRule_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_player_card);
        // inflate
        next_btn = findViewById(R.id.localNext_button_id);
        playerNote_tv = findViewById(R.id.localNote_textView_id);
        playerRule_tv = findViewById(R.id.localRule_textView_id);

        Intent data = getIntent();
        int index = data.getIntExtra("player index", -1);

        if(index != -1) {

            playerRule_tv.setText(Game.getCategories()[Game.getCategoryIndex()] + "\nLocation: " + Game.getCatLocations()[Game.getCategoryIndex()][Game.getLocationsIndex()]);
            playerNote_tv.setText(Game.getLocalPlayerNote());

            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    setResult(1);
                    finish();// close the activity


                }
            });

        }




    }
}