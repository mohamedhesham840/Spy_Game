package com.example.spygame5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FinalCardSpyName extends AppCompatActivity {

    TextView resultMessage_tv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_card_spy_name);

        // inflate
        resultMessage_tv = findViewById(R.id.resultHeader_id);
        if(Game.getNumOfSpies()>1){
            resultMessage_tv.setText("Spies are");
        }else{
            resultMessage_tv.setText("Spy is");

        }




        ArrayList<String> spies=new ArrayList<>();

        Player player[]=Game.getPlayers();


        for(int i=0;i<Game.getNumOfPlayers();i++){
            if(player[i].getRole().equals(Player.PLAYER_ROLE_SPY)){
                String name=player[i].getName();
                spies.add(name);

            }

        }
        ListView listView=(ListView)findViewById(R.id.result_listView_id);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.row,spies);

        listView.setAdapter(arrayAdapter);





    }
}


