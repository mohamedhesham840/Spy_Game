package com.example.spygame5;

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
public class Game {


    private static int numOfPlayers;
    private static int numOfSpies;
    private static int time;
    private static Player players[] = new Player[numOfPlayers];
    private static String categories[];     // sets / packs
    private static String catLocations[][]; // locations of each categories
    private static int categoryIndex; // random from categories   list
    private static int locationsIndex;// random from catLocations list





    // display on card
    private static String localPlayerNote; // message for the local player
    private static String spyPlayerNote; // message for the spy player


    // transfer data and navigate to the unknown card activity (intents and events)
    public static void generateGame() {



    }

    // --------------------------------------------------

    // events and elements on the unknown card activity
    public static void onUnknownCardActivity() {

    }

    // --------------------------------------------------

    // display the cards details & deal with events (called in spy card & local
    // card

    public static void onDisplayCarxdActivity() {

    }


    // --------------------------------------------------
    /*

         create players objects and assign random rule and name for each player
         generate random index for [categoryIndex][locationIndex]
         henawy
     */
    public static void generateRandomInfo() {

    }



    /*
     *
     * called in result activity to display name of spy players & nam of local
     * players
     * deals with events if exist
     *
     */
    public static void displayResult() {

    }



    // --------------------------------------------------


    // set default data to database
    public static void setDefaultDatabase() {

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
     * num of spies -> less than half num of players
     * note: event will do nothing if one of constraints not valid
     * when all constraints valid: change Start button color to *@color/valid*
     *
     *
     */
    public static void homeEvents() {

    }
    // --------------------------------------------------

    // default data ( called after getDefaultDatabase )
    // push the data into home elements- note : this could be bart of activity code
    public static void prepareElements() {

    }

    // --------------------------------------------------

    // deal with timer events (stop , reset) in the play activity
    public static void onPlay() {

    }




}
