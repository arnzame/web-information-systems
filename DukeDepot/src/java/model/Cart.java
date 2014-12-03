/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class Cart extends DBAccess{
    int userID;
    ArrayList<String> productList;
    
    public Cart (int ui){
        userID = ui;
        ResultSet rs = doQuery("SELECT productID FROM Cart WHERE userID = " + userID + ";");
        
    }
    
}
