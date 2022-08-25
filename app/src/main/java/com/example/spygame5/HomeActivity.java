package com.example.spygame5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {



    // view elements
    Button start_btn;

    //--------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start_btn = findViewById(R.id.start_btn_id);


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = Game.generateGameIntent(getBaseContext(), tapActivtiy.class);

                startActivity(temp);
            }
        });


    }

}