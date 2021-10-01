/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import DataBase.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author kwist
 */
public class DBQueries {
    public static void createAllTables(){
        //aca llamo las otras queries
    }
    public static void tablaUsuarios(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            
            
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Usuarios (" +
                    "cod INT NOT NULL," +
                    "id VARCHAR(255) NOT NULL," +
                    "pass STRING(255) NOT NULL" +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(cod)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();

    }
    public static void tablaCliente(){
        
    }
    
}
