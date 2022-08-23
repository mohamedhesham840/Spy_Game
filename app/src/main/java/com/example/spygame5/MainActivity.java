package com.example.spygame5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // declarations
    // act as button
    ImageView info_imv;
    ImageView login_imv;
    TextView  rules_tv;

    // others
    boolean   visible = false; // for appear/disappear rules text view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();   // make the app full screen

        // inflate
        login_imv  = findViewById(R.id.log_id);
        info_imv = findViewById(R.id.info_id);
        rules_tv = findViewById(R.id.rules_id);

        // events
        login_imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),HomeActivity.class);
                startActivity(i);

            }
        });

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
}