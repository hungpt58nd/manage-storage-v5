package com.uet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String username = "STORM";
    private String password = "671999";

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=manage;"
            + "integratedSecurity=true;user=sa;password=root";


    public Connection createConnection(){
        Connection connection = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL);
        } catch (Exception e){
            System.out.println("Connection error");
        }

        return connection;
    }
}
