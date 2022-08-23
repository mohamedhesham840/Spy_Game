package com.example.spygame5;

import android.content.Context;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
public class Game  {

    // finals
    // these attributes for array declaration
    private static final int maxNumOfPlayers = 15;
    private static final int maxNumOfCategories = 10; // depend on num of categories appear on the screen
    private static final int maxNumOfLocations  = 20;

    // game attributes
    private static int numOfPlayers;
    private static int numOfSpies;
    private static int numOfCategories;
    private static int time;
    private static Player players[]    = new Player[maxNumOfPlayers];
    private static String categories[] = new String[maxNumOfCategories];     // sets / packs
    private static String catLocations[][] = new String[maxNumOfCategories][maxNumOfLocations]; // locations of each categories
    private static int categoryIndex; // random from categories   list
    private static int locationsIndex;// random from catLocations list






    // display on card
    private static String localPlayerNote; // message for the local player
    private static String spyPlayerNote; // message for the spy player


    // transfer data and navigate to the unknown card activity (intents and events)
    /*
        data -> {"num of players": numOfPlayers, "num of spies": numOfSpies, "location category":

     */
    public static Intent generateGameIntent(Context packageContext, Class<?> cls) {
        // testing
        numOfPlayers = 3;
        spyPlayerNote = "Try to Understand what location the locals are talking about";
        localPlayerNote = "fuck u";
        players[0] = new Player("player1", Player.PLAYER_ROLE_LOCAL);
        players[1] = new Player("player2", Player.PLAYER_ROLE_SPY);
        players[2] = new Player("player3", Player.PLAYER_ROLE_LOCAL);

        categoryIndex = 0;
        locationsIndex = 1;
        catLocations[0][0]= "cairo";
        catLocations[0][1]= "alex";
        categories[0]  = "towns";
// --------
        Intent toUnknownCard = new Intent(packageContext, cls);
        // timer
        return toUnknownCard;




    }

    // --------------------------------------------------

    // events and elements on the unknown card activity : this code will be written inside unknown card activity
    public  void onUnknownCardActivity() {
//
//        int  index = 0;
//        final int LOCAL_CARD_REQUEST_CODE = 1;
//        final int SPY_CARD_REQUEST_CODE = 1;
//        Button displayDetail_btn;
//        TextView playerName_tv;
//        // on onCreate methode
//        Intent data = getIntent();
//        Player players[] = (Player[]) data.getSerializableExtra("players array");
//        int numOfPlayers = data.getIntExtra   ("num of players", 0);
//        String category  = data.getStringExtra("location category");
//        String location  = data.getStringExtra("actual location" );
//        // inflate
//        displayDetail_btn = findViewById(R.id.id);
//        playerName_tv     = findViewById(R.id.id);
//
//        if(index < numOfPlayers){
//            playerName_tv.setText(players[index].getName());
//            // event
//            displayDetail_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(players[index].getRole() == Player.PLAYER_ROLE_LOCAL){
//                        Intent toLocalCard = new Intent(getBaseContext(), LocalPlayerCard.class);
//                        toLocalCard.putExtra("player index", index++);
//                        startActivityForResult(toLocalCard,LOCAL_CARD_REQUEST_CODE )
//                    }
//                    else if(players[index].getRole() == Player.PLAYER_ROLE_SPY){
//                        Intent toLocalCard = new Intent(getBaseContext(), SpyCard.class);
//                        toLocalCard.putExtra("player index", index++);
//                        startActivityForResult(toLocalCard,SPY_CARD_REQUEST_CODE);
//                    }
//                }
//            });
//        }
//        else{
//            // error
//
//        }


    }

    // --------------------------------------------------

    // display the cards details & deal with events (called in spy card & local
    // card

    public  void onDisplayCardActivity() {

//        // declaration
//        Button   next_btn;
//        TextView playerNote_tv;
//        TextView playerRule_tv;
//
//        // on onCreate method
//        Intent data = getIntent();
//        int index = data.getIntExtra("player index", 0);
//
//        // on LocalCardActivity
//        next_btn = findViewById(R.id.id);
//        playerNote_tv = findViewById(R.id.id);
//        playerRule_tv = findViewById(R.id.id);
//
//        playerRule_tv.setText(Game.categories[Game.categoryIndex] + "\nLocation: " + Game.catLocations[categoryIndex][Game.locationsIndex]);
//        playerNote_tv.setText(Game.localPlayerNote);
//
//        next_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(index < Game.numOfPlayers){
//
//                    setResult(1);
//
//
//                }else{// timer activity
//                    Intent toTimerActivity = new Intent(getBaseContext(), TimerActivity.class);
//                    startActivity(toTimerActivity);
//                }
//                finish();
//            }
//        });
//
//
//        // on SpyCardActivity
//
//
//        next_btn = findViewById(R.id.id);
//        playerNote_tv = findViewById(R.id.id);
//        playerRule_tv = findViewById(R.id.id);
//
//        playerRule_tv.setText("Spy"); // temp
//        playerNote_tv.setText(Game.spyPlayerNote);
//
//        next_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(index < Game.numOfPlayers){
//
//                    setResult(1);
//
//
//                }else{// timer activity
//                    Intent toTimerActivity = new Intent(getBaseContext(), TimerActivity.class);
//                    startActivity(toTimerActivity);
//                }
//                finish();
//            }
//        });

    }


    // --------------------------------------------------
    /*

         create players objects and assign random rule and name for each player
         generate random index for [categoryIndex][locationIndex]
         henawy
     */
    public  void generateRandomInfo() {

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
    public  void setDefaultDatabase() {

    }
    // --------------------------------------------------

    // get default data from database into the attributes : categories,
    // catLocations, numOfPlayers, numOfSpies,... , etc
    public  void getDataFromDatabase() {

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
    public  void homeEvents() {

    }
    // --------------------------------------------------

    // default data ( called after getDefaultDatabase )
    // push the data into home elements- note : this could be bart of activity code
    public  void prepareElements() {

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

    public static String[] getCategories() {
        return categories;
    }

    public static void setCategories(String[] categories) {
        Game.categories = categories;
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
