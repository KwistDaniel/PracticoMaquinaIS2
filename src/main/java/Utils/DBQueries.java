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
        tablaVendedores();
        tablaMercancias();
        tablaClientesFisicos();
        tablaClientesJuridicos();
        tablaDirecciones();
        tablaConexionDirClientF();
        tablaConexionDirClientJ();
        tablaEnvios();
        tablaVentas();
        tablaRenglonesVenta();
        tablaConexionVenClientF();
        tablaConexionVenClientJ();
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
                    "USER VARCHAR(255) NOT NULL," +
                    "PASS VARCHAR(255) NOT NULL," +
                    "TELEFONO LONGTEXT NOT NULL," +
                    "SEXO VARCHAR(10) NOT NULL," +
                    "FNac VARCHAR(10) NOT NULL," +
                    "EMAIL LONGTEXT NOT NULL," +
                    "PRIORITY INT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,SEXO))");
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
                    "SEXO VARCHAR(10) NOT NULL," +
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
                    "SEXO_CF VARCHAR(10) NOT NULL," + 
                    "Status INT NOT NULL, " + 
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
                    "Status INT NOT NULL, " + 
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
                    "CALLE VARCHAR(255)," + 
                    "NUMERO VARCHAR(255)," + 
                    "PISO VARCHAR(255)," + 
                    "DEPTO VARCHAR(255)," + 
                    "COD_POSTAL VARCHAR(255)," + 
                    "LOCALIDAD VARCHAR(255)," + 
                    "Status INT NOT NULL," +
                    "PRIMARY KEY (ID))");
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
                    "PARTIDA INT NOT NULL," +
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
                    "ESTADO_ENVIO INT NOT NULL," +
                    "FECHA_ENVIO VARCHAR(10) NOT NULL," +
                    "HORA_ENVIO VARCHAR(6) NOT NULL," +
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
                    "SEXO_CF VARCHAR(10) NOT NULL," + 
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
                    "DNI_VENDEDOR VARCHAR(10) NOT NULL," +
                    "SEXO_VENDEDOR VARCHAR(10) NOT NULL," +
                    "PRECIO_TOTAL VARCHAR(255) NOT NULL," +
                    "PRECIO_FINAL VARCHAR(255) NOT NULL," +
                    "COD_ENVIO INT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(COD)," +
                    "FOREIGN KEY (COD_ENVIO) REFERENCES Envio(COD)," +
                    "FOREIGN KEY (DNI_VENDEDOR,SEXO_VENDEDOR) REFERENCES Vendedor(DNI,SEXO))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaRenglonesVenta(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE RenglonVenta (" + 
                    "COD INT NOT NULL," +
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
    
    
    
    /**DROPS**/
    public static void dropAllTables(){
        dropClientesFisicos();
        dropClientesJuridicos();
        dropConexionDirClientF();
        dropConexionDirClientJ();
        dropVentas();
        dropEnvios();
        dropDirecciones();
        dropConexionVenClientF();
        dropConexionVenClienJ();
        dropMercancias();
        dropRenglonesVenta();
        dropVendedores();

    }
    public static void dropVendedores(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Vendedor");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropMercancias(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Mercancia");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropClientesFisicos(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ClienteFisico");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropClientesJuridicos(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ClienteJuridico");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropConexionDirClientF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ConectDirCliF");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropConexionDirClientJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ConectDirCliJ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropDirecciones(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Direccion");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropVentas(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Venta");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropEnvios(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Envio");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropRenglonesVenta(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE RenglonVenta");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropConexionVenClientF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ConectVenCliF");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void dropConexionVenClienJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE ConectVenCliJ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    
    
    
    
    /**INSERTS**/
    public static void insertAllTables(){
        insertVendedores();
        insertMercancias();
        insertClientesF();
        insertDirecciones();
        insertConectorDirClienteF();
    }
    public static void insertVendedores(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Vendedor VALUES ('36421350','Debora','Kwist','dkwist','36421350','3382-571051','Femenino','12/11/1991','deborakwist@gmail.com',2,1),('11111111','Usuario','Admin','user','user','0000-000000','Masculino','11/11/1991','admin@gmail.com',1,1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertMercancias(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Mercancia VALUES (1,'Objeto1','Desc Obj1','15.2','20','Negro',10101,'Porcelanatos',1,20,10,200,1),(2,'Objeto2','Desc Obj2','17.2','3','Gris',10111,'Ceramicos',1,15,15,225,1),(3,'Objeto3','Desc Obj3','11.2','27','Gris',10112,'Ceramicos',2,15,15,225,1),(4,'Objeto4','Desc Obj4','45','35','Blanco',10201,'Porcelanatos',1,30,50,15000,1),(5,'Objeto5','Desc Obj5','921','25','Azul Cielo',154201,'Griferia',1,17,52,1500,1),(6,'Objeto6','Desc Obj6','225','26','Rojo',1501,'Ceramica',2,28,28,7500,1),(7,'Objeto7','Desc Obj7','396','1505','Celeste',14201,'Mosaico',4,17,17,250,1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertClientesF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ClienteFisico VALUES ('39662252','Daniel','Kwist','3382-406601','Masculino','30/12/1996','kwistdaniel@gmail.com',1),('42000189','Tobias','Burger','2664-509666','Masculino','29/04/1999','tovibur@hotmai.com',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertDirecciones(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Direccion VALUES (1,'Rivadavia','1305','2','2','5700','San Luis',1),(2,'Centenario','229','','','6100','Rufino',1),(3,'Ejercito de los andes','1025','2','2','5700','San Luis',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertConectorDirClienteF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ConectDirCliF VALUES (1,'39662252','Masculino',1),(2,'39662252','Masculino',1),(3,'42000189','Masculino',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
    }
    
    /*
    Queries importantes:
    **JOIN PARA CONSEGUIR DIRECCIONES DE UN CLIENTEF POR DNI Y SEXO:**
    SELECT ID,CALLE,NUMERO,PISO,DEPTO,COD_POSTAL,LOCALIDAD FROM Direccion INNER JOIN (SELECT ID_DIR FROM conectdirclif WHERE (DNI_CF='39662252') AND (SEXO_CF='Masculino')) AS DJ ON ID = DJ.ID_DIR WHERE (Status = 1)
    
    **JOIN PARA LISTAR VENTAS:
    SELECT //hacer como arriba, join de interseccion con subconsulta deberia andar
    
*/
}
