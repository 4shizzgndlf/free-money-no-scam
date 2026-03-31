package com.example.freemoneynoscam.utility;

import java.sql.*;

public class ConnectionManager {
    private Connection conn;

    public ConnectionManager() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emails","root","Hda34ewyHda34ewy");
        }
        catch (Exception e){
            System.out.println("Could not connect to database");
        }
    }

    public Connection getConnection (){
        return this.conn;
    }

    public void closeConnection(){
        try{
            this.conn.close();
        }
        catch(Exception E){
            System.out.println("Could not close connection");
        }
    }
}