package com.example.spygame5;

import android.content.Context;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.Toast;

import com.example.spygame5.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 *
 * @author mohamed
 *
 */
public class Game  extends AppCompatActivity {

    // these attributes for array declaration
    private static final int maxNumOfPlayers = 20;


    // game attributes

    private static int numOfPlayers;
    private static int numOfSpies;
    private static int time;

    private static Player players[]= new Player[maxNumOfPlayers];
    private static ArrayList<String>categories        = new ArrayList<String>();
    private static ArrayList<String>checkedCategories = new ArrayList<String>();
    private static HashMap<String, ArrayList<String>> catLocations = new HashMap<>();
    private static String randomLocation;



    // -------------------------------





    // display on card
    private static String localPlayerNote; // message for the local player
    private static String spyPlayerNote;   // message for the spy player
/*

        BackEnd Algorithm:

        1- getDataFromDatabase();
        3- prepareElements();
        4- homeEvents();
        5- generateRandomInfo();
        5- tap card activity
        6- navigate between spy, local, and tap activities
        7- timer activity
        8- result activity


     */




    // --------------------------------------------------
    /*

         create players objects and assign random rule and name for each player
         generate random index for [categoryIndex][locationIndex]

     */


    public static void generateRandomInfo() {

        Random rand = new Random();

        for (int i = 0; i < numOfPlayers; i++) {

            players[i] = new Player("Player " + (i + 1), Player.PLAYER_ROLE_LOCAL);
        }
        // random rule for each player
        int x = 0;
        while (x < numOfSpies) {
            int i = rand.nextInt(numOfPlayers);
            if (!players[i].getRole().equals(Player.PLAYER_ROLE_SPY)) {
                players[i].setRole(Player.PLAYER_ROLE_SPY);
                x++;
            }

        }
        // random location

        String  randomCategory   = checkedCategories.get(rand.nextInt(checkedCategories.size()));// ex: countries
        randomLocation =  catLocations.get(randomCategory).get( rand.nextInt(catLocations.get(randomCategory).size()));;


    }


    // --------------------------------------------------


        // get default data from database into the attributes : categories,
        // catLocations, numOfPlayers, numOfSpies,... , etc
        public static void getDataFromDatabase(DataBaseHelper db) {
            numOfPlayers    = 3;
            numOfSpies      = 1;
            time = 1;


            List<Pair<String, String>> allCategories = db.getAllCategories();

            for (Pair<String, String> x : allCategories) {
                if (!catLocations.containsKey(x.first)) {
                    categories.add(x.first);
                    ArrayList<String> elements = new ArrayList<>();
                    elements.add(x.second);
                    catLocations.put(x.first, elements);
                } else {
                    catLocations.get(x.first).add(x.second);
                }
            }


    }


    // --------------------------------------------------
    /* user customization
     * deals with elements & events of home activity
     *
     * constraints:
     * num of players -> minimum 3
     * categories     -> minimum 2 ( choose two categories )
     * timers         -> minimum 1 minute
     * num of spies   -> less than half num of players
     * note: event will do nothing if one of constraints not valid
     * when all constraints are valid: change Start button color to *@color/valid*
     *
     *
     */
    public static  void homeEvents(TextView players_txt, TextView spies , TextView Time, Button plus_player, Button mines_player, Button plus_spy, Button mines_spy, Button plus_time, Button mines_time, CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, Button start)
    {



        plus_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOfPlayers= Integer.parseInt(players_txt.getText().toString());
                if(numOfPlayers<maxNumOfPlayers) {
                    numOfPlayers++;
                    players_txt.setText(String.valueOf(numOfPlayers));
                }

                else {

                    Toast.makeText(players_txt.getContext(), "You reached max num of players", Toast.LENGTH_SHORT).show();
                }
            }


        });
        mines_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOfPlayers= Integer.parseInt(players_txt.getText().toString());
                if ((numOfPlayers-1)%2 == 0)
                {
                    if (numOfSpies<(numOfPlayers-1)/2)
                    {
                        numOfPlayers--;
                        players_txt.setText(String.valueOf(numOfPlayers));
                    }else{
                        Toast.makeText(plus_spy.getContext(), "Num of spies must be less than half num of players", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    if (numOfSpies<=(numOfPlayers-1)/2)
                    {
                        numOfPlayers--;
                        players_txt.setText(String.valueOf(numOfPlayers));
                    }else{
                        Toast.makeText(plus_spy.getContext(), "Num of spies must be less than half num of players", Toast.LENGTH_SHORT).show();

                    }

                }
                /*if (numOfPlayers>3&&(numOfPlayers-1)>2*numOfSpies) {
                    numOfPlayers--;
                    players_txt.setText(String.valueOf(numOfPlayers));
                }*/


            }
        });
        plus_spy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOfSpies= Integer.parseInt(spies.getText().toString());
                if (numOfPlayers%2==0)
                {
                    if ((numOfSpies+1)<numOfPlayers/2)
                    {
                        numOfSpies++;
                        spies.setText(String.valueOf(numOfSpies));
                    }
                    else
                    {
                        Toast.makeText(plus_spy.getContext(), "Num of spies must be less than half num of players", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    if ((numOfSpies+1)<=numOfPlayers/2)
                    {
                        numOfSpies++;
                        spies.setText(String.valueOf(numOfSpies));
                    }
                    else
                    {
                        Toast.makeText(plus_spy.getContext(), "Num of spies must be less than half num of players", Toast.LENGTH_SHORT).show();
                    }
                }





            }
        });
        mines_spy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numOfSpies= Integer.parseInt(spies.getText().toString());
                if(numOfSpies>1) {
                    numOfSpies--;
                    spies.setText(String.valueOf(numOfSpies));
                }else{
                    Toast.makeText(Time.getContext(), "you reached minimum num of spies", Toast.LENGTH_SHORT).show();

                }
            }
        });
        plus_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time= Integer.parseInt(Time.getText().toString());
                if(time<15) {
                    time++;
                    Time.setText(String.valueOf(time));
                }
                else
                {
                    Toast.makeText(Time.getContext(), "you reached max time", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mines_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time= Integer.parseInt(Time.getText().toString());
                if (time>1) {
                    time--;
                    Time.setText(String.valueOf(time));
                }else{
                    Toast.makeText(Time.getContext(), "you reached minimum time", Toast.LENGTH_SHORT).show();

                }
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                    checkedCategories.add(checkBox1.getText().toString());

                }
                if (b==false) {
                    if (checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(checkBox1.getText().toString()))
                    {
                        checkedCategories.remove(checkBox1.getText().toString());
                    }


                }


            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                    checkedCategories.add(checkBox2.getText().toString());

                }
                else
                {
                    if( checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(checkBox2.getText().toString()))
                    {
                        checkedCategories.remove(checkBox2.getText().toString());
                    }


                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));

                    checkedCategories.add(checkBox3.getText().toString());
                }
                else {
                    if( checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(checkBox3.getText().toString()))
                    {
                        checkedCategories.remove(checkBox3.getText().toString());
                    }


                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                {
                    checkedCategories.add(checkBox4.getText().toString());
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                }
                else {
                    if (checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(checkBox4.getText().toString()))
                    {
                        checkedCategories.remove(checkBox4.getText().toString());
                    }


                }
            }
        });


    }


    // --------------------------------------------------

    // default data ( called after getDefaultDatabase )
    // push the data into home elements- note : this could be bart of activity code


    public static void prepareElements(TextView players_veiw,TextView spies_veiw,TextView time_veiw, CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4 )
    {


        checkedCategories.clear();
        players_veiw.setText(String.valueOf(numOfPlayers));
        spies_veiw.setText(String.valueOf(numOfSpies));
        time_veiw.setText(String.valueOf(time));

        checkBox1.setText(categories.get(0));
        checkBox2.setText(categories.get(1));
        checkBox3.setText(categories.get(2));
        checkBox4.setText(categories.get(3));



    }

    // --------------------------------------------------




    // ------------------------------ setter & getters -------------------------------



    // setters

    public static void setRandomLocation(String randomLocation) {
        Game.randomLocation = randomLocation;
    }
    public static void setCheckedCategories(ArrayList<String> checkedCategories) { Game.checkedCategories = checkedCategories; }
    public static void setSpyPlayerNote(String spyPlayerNote) {Game.spyPlayerNote = spyPlayerNote;}
    public static void setNumOfPlayers(int numOfPlayers) {
        Game.numOfPlayers = numOfPlayers;
    }
    public static void setNumOfSpies(int numOfSpies) {
        Game.numOfSpies = numOfSpies;
    }
    public static void setLocalPlayerNote(String localPlayerNote) {  Game.localPlayerNote = localPlayerNote; }
    public static void setCategories(ArrayList<String> categories) {
        Game.categories = categories;
    }
    public static void setCheckCategories(ArrayList<String> checkCategories) { Game.checkedCategories = checkCategories;}
    public static void setPlayers(Player[] players) {
        Game.players = players;
    }
    public static void setTime(int time) {
        Game.time = time;
    }
    public static void setCatLocations(HashMap<String, ArrayList<String>> catLocations) {Game.catLocations = catLocations;}





// getters



    public static String getRandomLocation() { return randomLocation;}
    public static int getTime() {return time;}
    public static Player[] getPlayers() {
        return players;
    }

    public static HashMap<String, ArrayList<String>> getCatLocations() {return catLocations; }
    public static String getLocalPlayerNote() {
        return localPlayerNote;
    }
    public static int getNumOfSpies() {
        return numOfSpies;
    }
    public static int getNumOfPlayers() {
        return numOfPlayers;
    }
    public static String getSpyPlayerNote() {
        return spyPlayerNote;
    }
    public static ArrayList<String> getCheckedCategories() { return checkedCategories;}
    public static ArrayList<String> getCheckCategories() {
        return checkedCategories;
    }
    public static ArrayList<String> getCategories() {
        return categories;
    }


}
