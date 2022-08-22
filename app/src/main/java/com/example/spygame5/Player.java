package com.example.spygame5;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Mohamed
 */
public class Player {
    public static final String PLAYER_ROLE_SPY = "spy";
    public static final String PLAYER_ROLE_LOCAL= "local";


    private String name;
    private String role; // local | spy


    public Player(String name, String role){
        this.name  = name;
        this.role  = role;
    }

    public Player() {
        name = "null";
        role = PLAYER_ROLE_LOCAL;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }


    public String getRole() {
        return role;
    }





}
