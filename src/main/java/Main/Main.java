/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.LogIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Utils.DBQueries;

/**
 *
 * @author kwist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LogIn li = new LogIn();
        li.setVisible(true);
        
            /**Ordenado**/
        /**/
        DBQueries.dropAllTables();
        DBQueries.createAllTables();
        DBQueries.insertAllTables();
        /**/
    }
    
}
