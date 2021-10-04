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
        //aca llamo las otras queries?
    }
    public static void tablaUsuarios(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Usuario (" +
                    "cod INT NOT NULL," +
                    "id VARCHAR(255) NOT NULL," +
                    "pass VARCHAR(255) NOT NULL," +
                    "priority INT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(cod))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaClientesFisicos(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ClienteFisico (" +
                    "DNI VARCHAR(20) NOT NULL," +
                    "NOMBRE VARCHAR(255) NOT NULL," +
                    "APELLIDO VARCHAR(255) NOT NULL," +
                    "TELEFONO LONGTEXT NOT NULL," +
                    "SEXO VARCHAR(255) NOT NULL," +
                    "CALLE_DIR LONGTEXT NOT NULL," +
                    "NUMERO_DIR LONGTEXT NOT NULL," +
                    "PISO_DIR LONGTEXT NOT NULL," +
                    "DEPTO_DIR LONGTEXT NOT NULL," +
                    "COD_POSTAL_DIR LONGTEXT NOT NULL," +
                    "LOCALIDAD_DIR LONGTEXT NOT NULL," +
                    "dNac VARCHAR(2) NOT NULL," +
                    "mNac VARCHAR(2) NOT NULL," +
                    "yNac VARCHAR(4) NOT NULL," +
                    "EMAIL LONGTEXT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,SEXO)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaClientesJuridicos(){
        
    }
    public static void tablaVendedores(){
        
    }
    public static void tablaMercancias(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Mercancia(" +
                    "COD INT NOT NULL," +
                    "NOMBRE VARCHAR(255) NOT NULL," +
                    "DESCRIPCION VARCHAR(255) NOT NULL," +
                    "PRECIO_UNITARIO VARCHAR(255) NOT NULL," +
                    "CANTIDAD INT NOT NULL," +
                    "COLOR VARCHAR(255) NOT NULL," +
                    "CATEGORIA VARCHAR(255) NOT NULL," +
                    "CALIDAD INT," +
                    "MEDIDA_ANCHO VARCHAR(255)," +
                    "MEDIDA_ALTO VARCHAR(255)," +
                    "METROS_CUADRADOS VARCHAR(255)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(COD))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaEnvios(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Envio (" +
                    "cod INT NOT NULL," +
                    "id VARCHAR(255) NOT NULL," +
                    "pass VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(cod))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaVentas(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Venta (" +
                    "cod INT NOT NULL," +
                    "DNI_CLIENTE VARCHAR(255)," +
                    "SEXO_CLIENTE VARCHAR(255)," +
                    "DNI_VENDEDOR VARCHAR(255) NOT NULL," +
                    "SEXO_VENDEDOR VARCHAR(255) NOT NULL," +
                    "COD_MERCANCIA LONGTEXT NOT NULL," +
                    "CANTIDAD LONGTEXT NOT NULL," +
                    "PRECIO_DE_RENGLON_TOTAL VARCHAR(255) NOT NULL," +
                    "PORC_DESCUENTO VARCHAR(255) NOT NULL," +
                    "PRECIO_TOTAL VARCHAR(255) NOT NULL," +
                    "PRECIO_FINAL VARCHAR(255) NOT NULL," +
                    "PAGO INT NOT NULL," +
                    "STATUS INT NOT NULL," +
                    "COD_ENVIO VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY(cod),"+
                    "FOREIGN KEY (DNI_CLIENTE,SEXO_CLIENTE) REFERENCES ClienteFisico(DNI,SEXO),"+
                    "FOREIGN KEY () REFERENCES ClienteJuridico(),"+
                    "FOREIGN KEY (DNI_VENDEDOR,SEXO_VENDEDOR) REFERENCES Vendedor(DNI,SEXO),"+
                    "FOREIGN KEY (COD_ENVIO) REFERENCES Envio(COD))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
}
