/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.System.out;
import java.sql.*;

import javax.naming.*;
/**
 *
 * @author aaron
 */
public class DBAccess {
    public DBAccess(){
        
    }
    public Connection getConnection(){
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
            out.print(sqe.getMessage() + " getConn failed.");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found.");
        }
        return connection;
    }
    
    public boolean executeCommand(String command) {
        try {
          Connection connection = getConnection();
          if (connection == null) {
            return false;
          }
          Statement stmt = connection.createStatement();
          stmt.executeUpdate(command);
          connection.close();
        } catch (SQLException sqe) {
          sqe.printStackTrace();
          return false;
        }
        return true;
    }
    
  
    private void initDB(Connection connection){
        Statement statement;
        ResultSet rs;
        
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(70);
            
            String userinit = "CREATE TABLE IF NOT EXISTS Users (userID INT PRIMARY KEY, "
                    + "firstName VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL, dob VARCHAR(10), shipAddress VARCHAR(100), "
                    + "gender CHAR(1), age INT, isAdmin BOOLEAN NOT NULL, isSuperAdmin BOOLEAN NOT NULL,"
                    + " userName VARCHAR(30) NOT NULL UNIQUE, password BLOB NOT NULL, secretQuestion BLOB NOT NULL, secretAnswer VARCHAR(10000) NOT NULL); ";
            boolean executeUpdate = statement.execute(userinit);
            userinit =  "CREATE TABLE IF NOT EXISTS Product (productID INT PRIMARY KEY, "
                    + "productName VARCHAR(25) NOT NULL, price REAL, size VARCHAR(3), description VARCHAR(300), imageurl VARCHAR(150), "
                    + "category VARCHAR(20)); ";
            executeUpdate = statement.execute(userinit);
            userinit = "CREATE TABLE IF NOT EXISTS Payment (paymentID INT PRIMARY KEY, userID INT NOT NULL REFERENCES Users(userID), " 
                    + "cardType VARCHAR(15) NOT NULL, cvv BLOB NOT NULL, cardNumber BLOB NOT NULL, expDate BLOB NOT NULL, cardholder BLOB NOT NULL, "
                    + "billingAddress BLOB NOT NULL); ";
            executeUpdate = statement.execute(userinit);
            userinit = "CREATE TABLE IF NOT EXISTS Cart (userID INT NOT NULL REFERENCES Users(userID), productID INT NOT NULL REFERENCES"
                    + " Product(productID), size VARCHAR (3), quantity INT NOT NULL); ";
            executeUpdate = statement.execute(userinit);
            userinit = "CREATE TABLE IF NOT EXISTS Orders (orderID INT NOT NULL, userID INT NOT NULL REFERENCES Users(userID), productID INT NOT NULL REFERENCES"
                    + " Product(productID), size VARCHAR (3), quantity INT NOT NULL, paymentID INT NOT NULL REFERENCES Payment(paymentID), orderDate DATE); ";
            executeUpdate = statement.execute(userinit);
            userinit = "CREATE TABLE IF NOT EXISTS ClosedOrders (orderID INT NOT NULL, userID INT NOT NULL REFERENCES Users(userID), productID INT NOT NULL REFERENCES"
                    + " Product(productID), size VARCHAR (3), quantity INT NOT NULL, paymentID INT NOT NULL REFERENCES Payment(paymentID), orderDate DATE); ";
            executeUpdate = statement.execute(userinit);
            String insert = "INSERT OR REPLACE INTO Users(firstName, lastName, dob, shipAddress, gender, age, isAdmin, isSuperAdmin, username, password, secretQuestion, "
                    + "secretAnswer) VALUES('Ralph', 'Grove', '08-15-1970', '800 S. Main St, Harrisonburg, VA 22801', 'M', 54, 1, 1, 'grover', 'password', "
                    + "'Where did you attend college?', 'Louisville'); ";
            
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Users(firstName, lastName, dob, shipAddress, gender, age, isAdmin, isSuperAdmin, username, password, secretQuestion, "
                    + "secretAnswer) VALUES ('Zamecnik', 'Aaron', '07-15-1992', '800 S. Main St, Harrisonburg, VA 22801', 'M', 18, 0, 0, 'arnzame', 'password', "
                    + "'Where did you attend college?', 'JMU');";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Medium longsleeve purple t-shirt', "
                    + "19.99, 'M', 'Longsleeve JMU mens t shirt', './img/long_sleeve_t-shirt.jpg', 'men')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Large longsleeve purple t-shirt', "
                    + "19.99, 'L', 'Longsleeve JMU mens t shirt', './img/long_sleeve_t-shirt.jpg', 'men')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Extra-Large longsleeve purple t-shirt', "
                    + "19.99, 'XL', 'Longsleeve JMU mens t shirt', './img/long_sleeve_t-shirt.jpg', 'men')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Small Baby Onesie', "
                    + "11.99, 'S', 'Baby Onesie', './img/baby_onesie.jpg', 'kid')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Medium Baby Onesie', "
                    + "11.99, 'M', 'Baby Onesie', './img/baby_onesie.jpg', 'kid')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Large Baby Onesie', "
                    + "11.99, 'L', 'Baby Onesie', './img/baby_onesie.jpg', 'kid')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Small Womens Low-cut t-shirt', "
                    + "17.99, 'S', 'V-neck t-shirt', './img/low_cut_t-shirt.jpg', 'women')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Medium Womens Low-cut t-shirt', "
                    + "17.99, 'M', 'V-neck t-shirt', './img/low_cut_t-shirt.jpg', 'women')";
            executeUpdate = statement.execute(insert);
            insert = "INSERT OR REPLACE INTO Product(productName, price, size, description, imageurl, category) VALUES ('Large Womens Low-cut t-shirt', "
                    + "17.99, 'L', 'V-neck t-shirt', './img/low_cut_t-shirt.jpg', 'women')";
            executeUpdate = statement.execute(insert);
        } catch (SQLException sqe) {
            System.err.println(sqe.getMessage());
            //Remove Later
            out.println(sqe.getMessage() + " init failed.");
        }
    }
    public String encrypt(String s){
        String key = null;
        try {
            Context envCxt = (Context) (new InitialContext()).lookup("java:comp/env");
            key = (String) envCxt.lookup("Key");
        } catch (NamingException e) {
            System.out.println("Key Failed.");
        }
        
        return s;
    }
    
    public String decrypt(String s){
        String key = null;
        try {
            Context envCxt = (Context) (new InitialContext()).lookup("java:comp/env");
            key = (String) envCxt.lookup("Key");
        } catch (NamingException e) {
            System.out.println("Key Failed.");
        }
        
        return s;
    }
    public boolean validate(String s){
        return (!s.contains("=/;\"\'\\&|()=+`<>"));
    }
}
