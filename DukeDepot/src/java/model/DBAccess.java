/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import javax.naming.*;
/**
 *
 * @author aaron
 */
public abstract class DBAccess {
    protected Connection getConnection(){
        String dbPath = null;
        Connection connection = null;
        try {
            Context envCxt = (Context) (new InitialContext()).lookup("java:comp/env");
            dbPath = (String) envCxt.lookup("DatabasePath");
        } catch (NamingException e) {
            System.out.println("Database connection failed. ");
            e.printStackTrace();
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            initDB(connection);
        } catch (SQLException sqe) {
            System.err.println(sqe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found.");
        }
        return connection;
    }
    private void initDB(Connection connection){
        Statement statement;
        ResultSet rs;
        
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(70);
            
            String userinit = "CREATE TABLE IF NOT EXISTS dukeDepot.Users (userID INT PRIMARY KEY NOT NULL AUTOINCREMENT, "
                    + "firstName VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL, dob VARCHAR(10), shipAddress VARCHAR(100), "
                    + "gender CHAR(1), age INT, isAdmin BOOLEAN NOT NULL CHECK (isAdmin IN (0, 1)), userName VARCHAR(30) NOT NULL UNIQUE, "
                    + "password BLOB NOT NULL, secretQuestion BLOB NOT NULL, secretAnswer BLOB NOT NULL);"
                    + "CREATE TABLE IF NOT EXISTS dukeDepot.Product (productID INT PRIMARY KEY NOT NULL AUTOINCREMENT, "
                    + "productName VARCHAR(25) NOT NULL, price REAL, size VARCHAR(3), description VARCHAR(300), imageurl VARCHAR(150), "
                    + "category VARCHAR(20));"
                    + "CREATE TABLE IF NOT EXISTS dukeDepot.Payment (paymentID INT PRIMARY KEY AUTOINCREMENT, userID INT NOT NULL REFERENCES Users(userID), " 
                    + "cardType VARCHAR(15) NOT NULL, cvv BLOB NOT NULL, cardNumber BLOB NOT NULL, expDate BLOB NOT NULL, cardholder BLOB NOT NULL, "
                    + "billingAddress BLOB NOT NULL); "
                    + "CREATE TABLE IF NOT EXISTS dukeDepot.Cart (userID INT NOT NULL REFERENCES Users(userID), productID INT NOT NULL REFERENCES"
                    + " Product(productID), size VARCHAR (3), quantity INT NOT NULL);";
            int executeUpdate = statement.executeUpdate(userinit);
        } catch (SQLException sqe) {
            System.err.println(sqe.getMessage());
            //Remove Later
            System.out.println(sqe.getMessage());
        }
    }
    private String encrypt(String s){
        try {
            Context envCxt = (Context) (new InitialContext()).lookup("java:comp/env");
            String key = (String) envCxt.lookup("Key");
        } catch (NamingException e) {
            System.out.println("Key Failed.");
        }
        return null;
    }
    
    private String decrypt(String s){
        try {
            Context envCxt = (Context) (new InitialContext()).lookup("java:comp/env");
            String key = (String) envCxt.lookup("Key");
        } catch (NamingException e) {
            System.out.println("Key Failed.");
        }
        return null;
    }
}
