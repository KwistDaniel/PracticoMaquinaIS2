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
            throwables.printStackTrace(System.out);
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
                    "SITIVA VARCHAR(30) NOT NULL," + 
                    "CUITL VARCHAR(15)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,SEXO))");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
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
                    "SITIVA VARCHAR(255) NOT NULL," +
                    "TELEFONO LONGTEXT NOT NULL," +
                    "EMAIL LONGTEXT NOT NULL," +
                    "FFund VARCHAR(10)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(CUIT))");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
                    "METROS_CUADRADOS REAL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(COD,PARTIDA))");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
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
                    "ID_DIR INT," +
                    "ESTADO_ENVIO INT," +
                    "FECHA_ENVIO VARCHAR(10)," +
                    "HORA_ENVIO VARCHAR(6)," +
                    "Status INT NOT NULL," +
                    "FOREIGN KEY (ID_DIR) REFERENCES Direccion(ID), " +
                    "PRIMARY KEY(COD))");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void tablaVentas(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Venta (" +
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
            throwables.printStackTrace(System.out);
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
                    "PARTIDA_Mercancia INT NOT NULL," +
                    "Cantidad INT NOT NULL," +
                    "Precio_U REAL NOT NULL," +
                    "Descuento INT NOT NULL," +
                    "Precio_F REAL NOT NULL," +
                    "PRIMARY KEY(ID_Venta,COD_Mercancia,PARTIDA_Mercancia))");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
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
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    
    
    
    
    /**INSERTS**/
    public static void insertAllTables(){
        insertVendedores();
        insertMercancias();
        insertClientesF();
        insertClientesJ();
        insertDirecciones();
        insertConectorDirClienteF();
        insertConectorDirClienteJ();
        insertEnvio();
        insertVenta();
        insertRenglonVenta();
        insertConectVenCliF();
        insertConectVenCliJ();
    }
    public static void insertVendedores(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Vendedor VALUES "
                    + "('36421350','Debora','Kwist','dkwist','36421350','3382-571051','Femenino','12/11/1991','deborakwist@gmail.com',2,1),"
                    + "('38747243','Luciano','Gianotti','lgianotti','38747243','011-245424','Masculino','26/02/1994','lgia@gmail.com',3,1),"
                    + "('11111111','Usuario','Admin','user','user','0000-000000','Masculino','11/11/1991','admin@gmail.com',1,1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertMercancias(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Mercancia VALUES "
                    + "(1,'Soho Lounge','Porcelanato Soho Lounge','4500','8','Blanco',10101,'Porcelanatos',1,45,90,1.22,1),"
                    + "(1,'Soho Lounge','Porcelanato Soho Lounge','4500','21','Blanco',10111,'Porcelanatos',1,45,90,1.22,1),"
                    + "(2,'Ilva Burlington Ice','Porcelanato Ilva Burlington Ice','4700','7','Blanco',10201,'Porcelanatos',1,60,120,1.48,1),"
                    + "(2,'Ilva Burlington Ice','Porcelanato Ilva Burlington Ice','4700','17','Blanco',10222,'Porcelanatos',1,60,120,1.48,1),"
                    + "(3,'Legni Identica Acacia','Porcenalato Legni Identica Acaci','4999','50','Acacia',10354,'Porcelanatos',1,22,90,1.22,1),"
                    + "(4,'Legno Nogal Cortines','Ceramico Legno Nogal','1910','40','Nogal',10111,'Ceramicos',1,45,30,1.35,1),"
                    + "(5,'Ciment Arena','Ceramico Ciment Arena','845','7','Arena',10121,'Ceramicos',1,40,40,1,1),"
                    + "(5,'Ciment Arena','Ceramico Ciment Arena','845','30','Arena',10122,'Ceramicos',1,40,40,1,1),"
                    + "(6,'Pavimenti Palladio','Ceramico Pavimenti Palladio','990','14','Blanco Satinado',20122,'Ceramicos',2,35,60,1.47,1),"
                    + "(7,'Bacha Porcelana Piazza','Bacha de porcelana de apoyar','7500','12','Blanco',0,'Bacha',0,0,0,0,1),"
                    + "(8,'Bacha Piazza','Bacha sobre mesada de empotre','10000','5','Blanco',0,'Bacha',0,0,0,0,1),"
                    + "(9,'Griferia Enblem Piazza','Griferia Cocina Monocomando','10000','10','Negro',0,'Griferia',0,0,0,0,1),"
                    + "(10,'Griferia Mesada FV','Griferia para mesada de cocina','6500','15','Gris Cromado',0,'Griferia',0,0,0,0,1),"
                    + "(11,'Combo Sanitario Ferrum','Inodoro Bidet y Deposito','140000','5','Blanco',0,'Sanitarios',0,0,0,0,1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertClientesF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ClienteFisico VALUES "
                    + "('39662252','Daniel','Kwist','3382-406601','Masculino','30/12/1996','kwistdaniel@gmail.com','Monotributo','20-39662252-2',1),"
                    + "('42000189','Tobias','Burger','2664-509666','Masculino','29/04/1999','tovibur@hotmai.com','Consumidor Final','20-42000189-5',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertClientesJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ClienteJuridico VALUES "
                    + "('20-123456789-3','Constructora 1 SRL','Resposable Inscripto','2664-405540','contructora@const.com','31/12/2000',1),"
                    + "('20-457896656-3','Constructora 2','Responsable Inscripto','2664-558899','example@ex.com','12/11/2001',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertDirecciones(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Direccion VALUES "
                    + "(1,'Reservada','1','1','1','1','1',1),"
                    + "(2,'Rivadavia','1305','2','2','5700','San Luis',1),"
                    + "(3,'Centenario','229','','','6100','Rufino',1),"
                    + "(4,'Ejercito de los andes','1025','2','2','5700','San Luis',1),"
                    + "(5,'Bolivar','1045','','','5700','San Luis',1),"
                    + "(6,'Tomas Jofre','456','5','4','5700','San Luis',1),"
                    + "(7,'Junin','774','','','5700','San Luis',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertConectorDirClienteF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ConectDirCliF VALUES "
                    + "(2,'39662252','Masculino',1),"
                    + "(3,'39662252','Masculino',1),"
                    + "(4,'42000189','Masculino',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertConectorDirClienteJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ConectDirCliJ VALUES "
                    + "(5,'20-123456789-3',1),"
                    + "(6,'20-123456789-3',1),"
                    + "(7,'20-457896656-3',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertEnvio(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Envio VALUES "
                    + "(1,1,0,'26/11/2021','10:30',1),"
                    + "(2,2,1,'16/11/2021','17:00',1),"
                    + "(3,6,0,'30/11/2021','11:00',1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertVenta(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Venta VALUES "
                    + "(1,'36421350','Femenino','449.0','359.2',1,1),"
                    + "(2,'36421350','Femenino','540.0','477.0',2,1),"
                    + "(3,'36421350','Femenino','1980.0','1980.0',3,1)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertRenglonVenta(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO RenglonVenta VALUES "
                    + "(1,1,3,10112,20,11.2,20,179.2),"
                    + "(2,1,4,10201,5,45,20,180),"
                    + "(3,2,4,10201,7,45,20,252),"
                    + "(4,2,6,1501,1,225,0,225),"
                    + "(5,3,7,14201,5,396,0,1980)");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertConectVenCliF(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ConectVenCliF VALUES "
                    + "(1,'39662252','Masculino'),"
                    + "(2,'39662252','Masculino')");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    public static void insertConectVenCliJ(){
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ConectVenCliJ VALUES "
                    + "(3,'20-12345678-3')");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
        DataBase.getInstance().disconnect();
    }
    
    /*
    Queries Join:
    **JOIN PARA CONSEGUIR DIRECCIONES DE UN CLIENTEF POR DNI Y SEXO:**
    SELECT ID,CALLE,NUMERO,PISO,DEPTO,COD_POSTAL,LOCALIDAD FROM Direccion INNER JOIN (SELECT ID_DIR FROM conectdirclif WHERE (DNI_CF='39662252') AND (SEXO_CF='Masculino')) AS DJ ON ID = DJ.ID_DIR WHERE (Status = 1)
    
*/
}
