/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author aaron
 */
public class User extends DBAccess {
    
    Boolean isAdmin = false;
    Boolean isLoggedIn = false;
    String userName;
    String firstName;
    String lastName;
    int id;
    public User(){
        
    }
    
    public void newUser(ArrayList<String> i) {
        ArrayList<String> info = i;
        isLoggedIn = true;
        if (info.get(6).equals("1"))
            isAdmin = true;
        userName = info.get(6);
        firstName = info.get(0);
        lastName = info.get(1);
        info.set(9, encrypt(info.get(9)));
        info.set(8, encrypt(info.get(8)));
        info.set(7, encrypt(info.get(7)));
        
        String value = null;
        for (String s : info){
            if (value != null) {
                value += ", ";
            }
            value += s;
        }
        ArrayList<String> s = doQuery("INSERT INTO dukeDepot.Users (firstName, lastName, dob, shipAddress, gender, isAdmin, userName, "
                + "password, secretQuestion, secretAnswer) VALUES ( " + value + ");");
    }
    
    public Boolean isAdmin(){
        return isAdmin;
    }
    public Boolean isLoggedIn(){
        return isLoggedIn;
    }
}


