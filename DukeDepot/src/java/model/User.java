/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aaron
 */
public class User extends DBAccess {
    
    Boolean isAdmin = false;
    Boolean isSuperAdmin = false;
    Boolean isLoggedIn = false;
    String userName;
    String password;
    String firstName;
    String lastName;
    int id;
    
    //Constructor
    public User(String un, String pw, String fn, String ln){
        userName = un;
        password = pw;
        firstName = fn;
        lastName = ln;
    }
    //Needed methods: Add user, validate password, validate secret question Q & A,
    //validate password, 
    //
    
    public Boolean isAdmin(){
        return isAdmin;
    }
    public Boolean isSuperAdmin(){
        return isSuperAdmin;
    }
    public Boolean isLoggedIn(){
        return isLoggedIn;
    }
    public void setAdmin(Boolean b){
        isAdmin = b;
    }
    public void setSuperAdmin(Boolean b){
        isSuperAdmin = b;
    }
    public void setLoggedIn(Boolean b){
        isLoggedIn = b;
    }
    public String getUserName(){
        return userName;
    }
    

}

