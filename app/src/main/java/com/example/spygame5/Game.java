package com.example.spygame5;

import android.content.Context;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
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
    // 1
    // finals
    // these attributes for array declaration
    private static final int maxNumOfPlayers = 15;
    private static final int maxNumOfCategories = 10; // depend on num of categories appear on the screen
    private static final int maxNumOfLocations  = 20;

    // game attributes
    private static int numOfPlayers;
    private static int numOfSpies;
    private static int time;

    private static Player players[]= new Player[maxNumOfPlayers];
    private static ArrayList<String>checkedCategories = new ArrayList<String>();
    private static ArrayList<String>categories        = new ArrayList<String>();
    private static int numOfCategories;// store actual size of categories
    private static int numOfLocations;// store actual size of all categories
    private static String catLocations [][] = new String[maxNumOfCategories][maxNumOfLocations];
    private static int categoryIndex; // random from categories   list
    private static int locationsIndex;// random from catLocations list




    // -------------------------------





    // display on card
    private static String localPlayerNote; // message for the local player
    private static String spyPlayerNote; // message for the spy player
/*

        BackEnd Algorithm:

        1- getDataFromDatabase();
        3- prepareElements();
        4- homeEvents();
        5- generateRandomInfo();
        5- to unknown card activity
        6- handle there events and show player cards -> done
        7- timer activity
        8- result activity


     */

    // transfer data and navigate to the unknown card activity (intents and events)
    public static Intent generateGameIntent(Context packageContext, Class<?> cls) {


        // testing
        numOfPlayers = 5;
        numOfSpies = 2;
        numOfCategories = 4;
        numOfLocations = 3;
        spyPlayerNote = "Try to Understand what location the locals are talking about";
        localPlayerNote = "u are Local\n\nAll players except the Spy know this location.\nAsk the other players questions\nto figure out who of them Spy.";
//        players[0] = new Player("player1", Player.PLAYER_ROLE_LOCAL);
//        players[1] = new Player("player2", Player.PLAYER_ROLE_SPY);
//        players[2] = new Player("player3", Player.PLAYER_ROLE_LOCAL);
//        players[3] = new Player("player4", Player.PLAYER_ROLE_LOCAL);
//        players[4] = new Player("player5", Player.PLAYER_ROLE_SPY);
//        players[5] = new Player("player6", Player.PLAYER_ROLE_LOCAL);
//        players[6] = new Player("player7", Player.PLAYER_ROLE_SPY);



//        categoryIndex = 1; // random
//        locationsIndex= 2; // random

        catLocations[0][0]= "Ain Shams university";
        catLocations[0][1]= "Cairo university" ;
        catLocations[0][2]=  "Azhar univirsity";
        catLocations[1][0]= "Alex" ;
        catLocations[1][1]= "Cairo";
        catLocations[1][2]= "Aswan" ;
        catLocations[2][0]= "A" ;
        catLocations[2][1]= "B";
        catLocations[2][2]= "C" ;
        catLocations[3][0]= "one" ;
        catLocations[3][1]= "two";
        catLocations[3][2]= "three";
        generateRandomInfo();

        Intent toUnknownCard = new Intent(packageContext, cls);
        return toUnknownCard;



    }

    // ----------------------implementation of these two methods in there activities------

    // events and elements on the unknown card activity : this code will be written inside unknown card activity
    public  void onUnknownCardActivity() {

    }

    // --------------------------------------------------

    // display the cards details & deal with events (called in spy card & local
    // card

    public  void onDisplayCardActivity() {

    }



    // --------------------------------------------------
    /*

         create players objects and assign random rule and name for each player
         generate random index for [categoryIndex][locationIndex]
         henawy
     */


    public static void generateRandomInfo() {

        Random rand = new Random();
        for (int i = 0; i < numOfPlayers; i++) {

            players[i] = new Player("player" + (i + 1), "local");
        }

        int x = 0;
        while (x < numOfSpies) {
            int i = rand.nextInt(numOfPlayers);
            if (!players[i].getRole().equals("spy")) {
                players[i].setRole("spy");
                x++;
            }

        }
        int temp   = rand.nextInt(checkedCategories.size());
        switch(checkedCategories.get(temp)){
            case "Countries":
                categoryIndex= 0;
                break;
            case "Places":
                categoryIndex = 1;
                break;
            case "Objects":
                categoryIndex = 2;
                break;
            case "Geography":
                categoryIndex = 3;

        }
        locationsIndex = rand.nextInt(numOfLocations);




    }


    /*
     *
     * called in result activity to display name of spy players & nam of local
     * players
     * deals with events if exist
     *
     */
    public  void displayResult() {

    }



    // --------------------------------------------------


    // set default data to database
    public static  void setDefaultDatabase() {

    }
    // --------------------------------------------------

    // get default data from database into the attributes : categories,
    // catLocations, numOfPlayers, numOfSpies,... , etc
    public static void getDataFromDatabase() {


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
    public static  void homeEvents(TextView players_txt, TextView spies , TextView Time, Button plus_player, Button mines_player, Button plus_spy, Button mines_spy, Button plus_time, Button mines_time, CheckBox countries, CheckBox places, CheckBox objects, CheckBox geography, Button start)
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

                    Toast.makeText(players_txt.getContext(), "You Over Maximum Number Of Player", Toast.LENGTH_SHORT).show();
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
                    }
                }
                /*
                 * 8 8-1= 7
                 *
                 *
                 *
                 * */
                else {
                    if (numOfSpies<=(numOfPlayers-1)/2)
                    {
                        numOfPlayers--;
                        players_txt.setText(String.valueOf(numOfPlayers));
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
                        Toast.makeText(plus_spy.getContext(), "You Over Number Of spies According To Number Of Players ", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(plus_spy.getContext(), "You Over Number Of spies According To Number Of Players ", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Time.getContext(), "Time Shouldnot Over 15 Minutes", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mines_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time= Integer.parseInt(Time.getText().toString());
                if (time>3) {
                    time--;
                    Time.setText(String.valueOf(time));
                }
            }
        });
//        countries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b == true) {
//                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
//                    checkedCategories.add(countries.getText().toString());
//
//                }
//                else if (b==false) {
//                    if (checkedCategories.size()==1)
//                    {
//                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
//                    }
//                    if (checkedCategories.contains(countries.getText().toString()))
//                    {
//                        checkedCategories.remove(countries.getText().toString());
//                    }
//
//
//                }
//
//            }
//        });
//        places.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b == true)
//                {
//                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
//                    checkedCategories.add(places.getText().toString());
//
//                }
//                else
//                {
//                    if( checkedCategories.size()==1)
//                    {
//                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
//                    }
//                    if (checkedCategories.contains(places.getText().toString()))
//                    {
//                        checkedCategories.remove(places.getText().toString());
//                    }
//
//
//                }
//            }
//        });
//        objects.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b == true) {
//                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
//
//                    checkedCategories.add(objects.getText().toString());
//                }
//                else {
//                    if( checkedCategories.size()==1)
//                    {
//                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
//                    }
//                    if (checkedCategories.contains(objects.getText().toString()))
//                    {
//                        checkedCategories.remove(objects.getText().toString());
//                    }
//
//
//                }
//            }
//        });
//        geography.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b == true)
//                {
//                    checkedCategories.add(geography.getText().toString());
//                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
//                }
//                else {
//                    if (checkedCategories.size()==1)
//                    {
//                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
//                    }
//                    if (checkedCategories.contains(geography.getText().toString()))
//                    {
//                        checkedCategories.remove(geography.getText().toString());
//                    }
//
//
//                }
//            }
//        });


        countries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                    checkedCategories.add(countries.getText().toString());

                }
                if (b==false) {
                    if (checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(countries.getText().toString()))
                    {
                        checkedCategories.remove(countries.getText().toString());
                    }


                }
                Toast.makeText(countries.getContext(), "test", Toast.LENGTH_LONG).show();

            }
        });
        places.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                    checkedCategories.add(places.getText().toString());

                }
                else
                {
                    if( checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(places.getText().toString()))
                    {
                        checkedCategories.remove(places.getText().toString());
                    }


                }
            }
        });
        objects.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));

                    checkedCategories.add(objects.getText().toString());
                }
                else {
                    if( checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(objects.getText().toString()))
                    {
                        checkedCategories.remove(objects.getText().toString());
                    }


                }
            }
        });
        geography.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                {
                    checkedCategories.add(geography.getText().toString());
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                }
                else {
                    if (checkedCategories.size()==1)
                    {
                        start.setBackgroundColor(start.getResources().getColor(R.color.notValid));
                    }
                    if (checkedCategories.contains(geography.getText().toString()))
                    {
                        checkedCategories.remove(geography.getText().toString());
                    }


                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Categories = "+checkedCategories.size());
                if (checkedCategories.size()>=1)
                {
                    start.setBackgroundColor(start.getResources().getColor(R.color.valid));
                    Intent i= generateGameIntent(start.getContext(), tapActivtiy.class);
                    start.getContext().startActivity(i);
                }
                else {
                    Toast.makeText(start.getContext(), "Choose At least One Category ", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }


    // --------------------------------------------------

    // default data ( called after getDefaultDatabase )
    // push the data into home elements- note : this could be bart of activity code


    public static void prepareElements(TextView players_veiw,TextView spies_veiw,TextView time_veiw )
    {

        players_veiw.setText(String.valueOf(numOfPlayers));
        spies_veiw.setText(String.valueOf(numOfSpies));
        time_veiw.setText(String.valueOf(time));

    }

    // --------------------------------------------------

    // deal with timer events (stop , reset) in the play activity
    public  void onPlay() {

    }



    // ------------------------------ setter & getters -------------------------------



    public static void setSpyPlayerNote(String spyPlayerNote) {
        Game.spyPlayerNote = spyPlayerNote;
    }

    public static String getSpyPlayerNote() {
        return spyPlayerNote;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        Game.numOfPlayers = numOfPlayers;
    }

    public static int getNumOfSpies() {
        return numOfSpies;
    }

    public static void setNumOfSpies(int numOfSpies) {
        Game.numOfSpies = numOfSpies;
    }

    public static int getNumOfCategories() {
        return numOfCategories;
    }

    public static void setNumOfCategories(int numOfCategories) {
        Game.numOfCategories = numOfCategories;
    }

    public static String getLocalPlayerNote() {
        return localPlayerNote;
    }

    public static void setLocalPlayerNote(String localPlayerNote) {
        Game.localPlayerNote = localPlayerNote;
    }

    public static ArrayList<String> getCheckCategories() {
        return checkedCategories;
    }

    public static ArrayList<String> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<String> categories) {
        Game.categories = categories;
    }

    public static void setCheckCategories(ArrayList<String> checkCategories) {
        Game.checkedCategories = checkCategories;
    }

    public static String[][] getCatLocations() {
        return catLocations;
    }

    public static void setCatLocations(String[][] catLocations) {
        Game.catLocations = catLocations;
    }

    public static int getCategoryIndex() {
        return categoryIndex;
    }

    public static void setCategoryIndex(int categoryIndex) {
        Game.categoryIndex = categoryIndex;
    }

    public static int getLocationsIndex() {
        return locationsIndex;
    }

    public static void setLocationsIndex(int locationsIndex) {
        Game.locationsIndex = locationsIndex;
    }

    public static Player[] getPlayers() {
        return players;
    }

    public static void setPlayers(Player[] players) {
        Game.players = players;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        Game.time = time;
    }
}
