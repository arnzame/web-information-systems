/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;

/**
 *
 * @author aaron
 */
public class UserController {
    //Needed methods: login, logout
    //Logout needs to delete all records from cart and set isloggedin to false
    //Login needs to validate user input, check password against username in DB, 
    //then set isloggedin to true.
    public boolean login(String un, String pw){
        //SQL injection check
        if (un.contains("=/;\"\'\\&|()=+`<>") || pw.contains("=/;\"\'\\&|()=+`<>"))
            return false;
        
        return false;
    }
    
    public boolean addUser(){
        
        return false;
    }
}
