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
        DBQueries.tablaVendedores();
        DBQueries.tablaMercancias();
        DBQueries.tablaClientesFisicos();
        DBQueries.tablaClientesJuridicos();
        DBQueries.tablaDirecciones();
        
        DBQueries.tablaConexionDirClientF();
        DBQueries.tablaConexionDirClientJ();
        
        DBQueries.tablaEnvios();
        DBQueries.tablaVentas();
        
        DBQueries.tablaRenglonesVenta();
        DBQueries.tablaConexionVenClientF();
        DBQueries.tablaConexionVenClientJ();
        
        
        
        
        
        //jdbc:mariadb://
        /*
        String url = "jdbc:mariadb://dvnikst.duckdns.org:3306/is2-daquino-gk";
        String user = "user1";
        String password = "951753";
        Connection connection = null;
        System.out.println("ASD");
        try {
            //Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE dfsgsddgsg (id INTEGER)";
            stmt.executeUpdate(sql);
            System.out.println("Query tirada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection.close();
            System.out.println("Disconnected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
*/
    }
    
}
