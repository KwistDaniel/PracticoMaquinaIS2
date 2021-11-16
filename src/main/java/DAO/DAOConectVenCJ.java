/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.ConectVenCJ;
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
public class DAOConectVenCJ implements DAO<ConectVenCJ>{

    @Override
    public List<ConectVenCJ> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConectVenCJ readOne(String... ids) {
        ConectVenCJ cvcj = new ConectVenCJ();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ConectVenCliJ WHERE (COD_VENTA='" + ids[0] + "')");
            while(rs.next()){
                cvcj.setCOD_VENTA(rs.getInt("COD_VENTA"));
                cvcj.setCUIT(rs.getString("CUIT_CJ"));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return cvcj;
    }

    @Override
    public int create(ConectVenCJ t) {
        String sqlInsert = " INSERT INTO ConectVenCliJ (COD_VENTA, CUIT_CJ)" +
                " VALUES (?, ?)";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, t.getCOD_VENTA());
            statement.setString(2, t.getCUIT());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(ConectVenCJ t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ConectVenCJ t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectVenCJ> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectVenCJ> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
