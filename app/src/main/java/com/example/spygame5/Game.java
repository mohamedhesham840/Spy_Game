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
 * @author mohamed
 */
public class Game {
    private static int numOfPlayers;
    private static int numOfSpies;
    private static Player players[] = new Player[numOfPlayers];
    private static String categories[]; // sets / packs
    private static String catLocations[][]; // locations of each categories

    // display on card
    private static String localPlayerNote; // message for the local player
    private static String spyPlayerNote; // message for the spy player

    // transfere data and navigate to the unkown card activity (intents and events)
    public static void generateGame() {

    }

    // --------------------------------------------------

    // events and elements on the unkown card activity
    public static void onUnkownCardActivity() {

    }

    // --------------------------------------------------

    // display the cards details & deal with events (called in spy card & local
    // card)

    public static void onDisplayCardActivity() {

    }

    // --------------------------------------------------

    // create players objects and assign randome rule and name for each player
    public static void generatePlayersInfo() {

    }

    // --------------------------------------------------

    /*
     * deals with elements & events of home activity
     *
     * constraints:
     * num of players -> minimum 3
     * categories -> minimum 2 ( choose two categories )
     * num of spies -> less than half num of players
     * note: event will do nothing if one of constraints not valid
     * when all constraints vaild: change Start button color to *@color/valid*
     *
     *
     */
    public static void homeEvents() {

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

    // push the data into home elements- note : this could be bart of activity code
    public static void prepareElements() {

    }

    // --------------------------------------------------

    // deal with timer events (stop , reset) in the play activity
    public static void onPlay() {

    }

    /*
     * -------------------------------------------------
     * called in result activity to display name of spy players & nam of local
     * players
     * deals with events if exist
     */
    public static void displayResult() {

    }

}
