package com.example.freemoneynoscam.repository;

import com.example.freemoneynoscam.models.Email;
import com.example.freemoneynoscam.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailRepository {
    private ConnectionManager conn = new ConnectionManager();

    //Mangler en forbindelse til databasen
    public List<Email> getAllEmails(){
        List<Email> allEmails = new ArrayList<>();

        Connection database = conn.getConnection();
        try{
            PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM subscribers;");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                allEmails.add(new Email(rs.getString(1)));            }
        }
        catch(Exception e){
            System.out.println("Could not prepare statement");
        }
        return allEmails;
    }

    public void insertEmail(String email) throws SQLException {
        Connection database = conn.getConnection();
        String sql = "INSERT INTO subscribers (e_mail) VALUES (?)";
        PreparedStatement psts = database.prepareStatement(sql);
        psts.setString(1, email);
        psts.executeUpdate();
    }
}