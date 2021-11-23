/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kwist
 */
public class DataBase {
    private static DataBase INSTANCE;
    private static Connection connection;
    /*private static String url = "jdbc:mariadb://dvnikst.duckdns.org:3306/is2-daquino-gk";
    private static String user = "user1";
    private static String password = "951753";
    */
    private static String url = "jdbc:mariadb://localhost:3306/is2-daquino-gk";
    private static String user = "root";
    private static String password = "";
    
    
    private DataBase(){//esto va priv
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the DB successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private static void createInstance(){
        INSTANCE = new DataBase();
    }
    
    public static DataBase getInstance(){
        try{
            if(INSTANCE == null){
                createInstance();
            } else if (INSTANCE.getConnection().isClosed()){
                connection = DriverManager.getConnection(url,user,password);
                System.out.println("Connected to the DB successfully");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
    public void disconnect(){
        try{
            connection.close();
            System.out.println("Disconnected to the DB successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
