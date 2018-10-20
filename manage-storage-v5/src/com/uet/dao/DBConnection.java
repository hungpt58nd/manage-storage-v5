package com.uet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String username = "p4x";
    private String password = "Pyxis4All@";

    public Connection createConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage-storage?autoReconnect=true&useSSL=false",username,password);
        } catch (Exception e){
            System.out.println("Connection error");
        }

        return connection;
    }
}
