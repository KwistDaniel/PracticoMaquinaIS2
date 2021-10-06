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
        tablaClientesJuridicos();
        tablaClientesFisicos();
        tablaDirecciones();
        tablaConexionDirClientF();
        tablaConexionDirClientJ();
        tablaEnvios();
        tablaVendedores();
        tablaVentas();
        tablaRenglones();
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
                    "DNI VARCHAR(10) NOT NULL," +
                    "NOMBRE VARCHAR(255) NOT NULL," +
                    "APELLIDO VARCHAR(255) NOT NULL," +
                    "TELEFONO LONGTEXT NOT NULL," +
                    "SEXO VARCHAR(2) NOT NULL," +
                    "FNac VARCHAR(10) NOT NULL," +
                    "EMAIL LONGTEXT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,SEXO))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    
    public static void tablaClientesJuridicos(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ClienteJuridico (" +
                    "CUIT VARCHAR(15) NOT NULL," +
                    "NOMBRE VARCHAR(255) NOT NULL," +
                    "TELEFONO LONGTEXT NOT NULL," +
                    "SITIVA VARCHAR(255) NOT NULL," +
                    "FFund VARCHAR(10)," +
                    "EMAIL LONGTEXT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(CUIT))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    
    public static void tablaConexionDirClientF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ConectDirCliF (" +
                    "ID_DIR INT NOT NULL," +
                    "DNI_CF VARCHAR(10) NOT NULL," +
                    "SEXO_CF VARCHAR(2) NOT NULL," + 
                    "PRIMARY KEY(ID_DIR,DNI_CF,SEXO_CF))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaConexionDirClientJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ConectDirCliJ (" +
                    "ID_DIR INT NOT NULL," +
                    "CUIT_CJ VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY(ID_DIR,CUIT_CJ))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaDirecciones(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Direccion (" + 
                    "ID INT NOT NULL," + 
                    "CALLE LONGTEXT," + 
                    "NUMERO LONGTEXT," + 
                    "PISO LONGTEXT," + 
                    "DEPTO LONGTEXT," + 
                    "COD_POSTAL LONGTEXT," + 
                    "LOCALIDAD LONGTEXT," + 
                    "Status INT NOT NULL," +
                    "PRIMARY KEY (ID))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaVendedores(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Vendedor (" +
                    "DNI VARCHAR(10) NOT NULL," +
                    "NOMBRE VARCHAR(255) NOT NULL," +
                    "APELLIDO VARCHAR(255) NOT NULL," +
                    "TELEFONO VARCHAR(255) NOT NULL," +
                    "SEXO VARCHAR(2) NOT NULL," +
                    "FNac VARCHAR(10) NOT NULL," +
                    "EMAIL VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,SEXO))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
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
                    "PRECIO_UNITARIO REAL NOT NULL," +
                    "CANTIDAD INT NOT NULL," +
                    "COLOR VARCHAR(255) NOT NULL," +
                    "CATEGORIA VARCHAR(255) NOT NULL," +
                    "CALIDAD INT," +
                    "MEDIDA_ANCHO INT," +
                    "MEDIDA_ALTO INT," +
                    "METROS_CUADRADOS INT," +
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
                    "COD INT NOT NULL," +
                    "ID_DIR INT NOT NULL," +
                    "ESTADO_ENVIO VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "FOREIGN KEY (ID_DIR) REFERENCES Direccion(ID), " +
                    "PRIMARY KEY(COD))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaConexionVenClientF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ConectVenCliF (" +
                    "COD_VENTA INT NOT NULL," +
                    "DNI_CF VARCHAR(10) NOT NULL," +
                    "SEXO_CF VARCHAR(2) NOT NULL," + 
                    "PRIMARY KEY(COD_VENTA,DNI_CF,SEXO_CF))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaConexionVenClientJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ConectVenCliJ (" +
                    "COD_VENTA INT NOT NULL," +
                    "CUIT_CJ VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY(COD_VENTA,CUIT_CJ))");
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
            //Al proximo query, le meto los datos del vendedor tmb? como los manejo? y  como manejo al vendedor?
            statement.executeUpdate("CREATE TABLE Venta (" + //REVISAR ESTO COMO LO HAGO
                    "COD INT NOT NULL," +
                    "DNI_VENDEDOR VARCHAR(255) NOT NULL," +
                    "SEXO_VENDEDOR VARCHAR(255) NOT NULL," +
                    "PRECIO_TOTAL VARCHAR(255) NOT NULL," +
                    "PRECIO_FINAL VARCHAR(255) NOT NULL," +
                    "ESTADO_PAGO INT NOT NULL," +
                    "STATUS INT NOT NULL," +
                    "COD_ENVIO INT NOT NULL," +
                    "PRIMARY KEY(COD)," +
                    "FOREIGN KEY (COD_ENVIO) REFERENCES Envio(COD)," +
                    "FOREIGN KEY (DNI_VENDEDOR,SEXO_VENDEDOR) REFERENCES Vendedor(DNI,SEXO))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaRenglones(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE RenglonVenta (" + 
                    "ID_Venta INT NOT NULL," +
                    "COD_Mercancia INT NOT NULL," +
                    "Cantidad INT NOT NULL," +
                    "Precio_U REAL NOT NULL," +
                    "Descuento INT NOT NULL," +
                    "Precio_F REAL NOT NULL," +
                    "PRIMARY KEY(ID_Venta,COD_Mercancia))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    
    /*
    Queries importantes:
    **JOIN PARA CONSEGUIR DIRECCIONES DE UN CLIENTEF POR DNI Y SEXO:**
    SELECT ID,CALLE,NUMERO,PISO,DEPTO,COD_POSTAL,LOCALIDAD FROM Direccion INNER JOIN (SELECT ID_DIR FROM conectdirclif WHERE (DNI_CF='39662252') AND (SEXO_CF='M')) AS DJ ON ID = DJ.ID_DIR
    
    **JOIN PARA LISTAR VENTAS:
    SELECT //hacer como arriba, join de interseccion con subconsulta deberia andar
    
*/
}
