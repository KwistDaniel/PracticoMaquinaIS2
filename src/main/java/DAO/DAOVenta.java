/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author kwist
 */
public class DAOVenta implements DAO<Venta> {

    @Override
    public List<Venta> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Venta t) {
        String sqlInsert = " INSERT INTO Venta (COD, DNI_VENDEDOR, SEXO_VENDEDOR, PRECIO_TOTAL, PRECIO_FINAL, COD_ENVIO, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, t.getCOD_VENTA());
            statement.setString(2, t.getDNI_V());
            statement.setString(3, t.getSexo_V());
            statement.setDouble(4, t.getP_Total());
            statement.setDouble(5, t.getP_Final());
            statement.setInt(6, t.getCOD_ENVIO());
            statement.setInt(7, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Venta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Venta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        int aux = 0;
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT IFNULL(MAX(COD),0) AS MAXIMO FROM Venta");
            while(rs.next()){
                aux = rs.getInt("MAXIMO");
            }
            
        }catch (Exception throwables){
            throwables.printStackTrace();
            aux = 0;
            return aux;
        }
        DataBase.getInstance().disconnect();
        return aux;
    }

    @Override
    public List<Venta> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
