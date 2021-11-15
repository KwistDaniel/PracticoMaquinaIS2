/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.ConectVenCF;
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
public class DAOConectVenCF implements DAO<ConectVenCF>{

    @Override
    public List<ConectVenCF> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConectVenCF readOne(String... ids) {
        ConectVenCF cvcf = new ConectVenCF();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ConectVenCliF WHERE (COD_VENTA='" + ids[0] + "')");
            while(rs.next()){
                cvcf.setCOD_VENTA(rs.getInt("COD_VENTA"));
                cvcf.setDNI(rs.getString("DNI_CF"));
                cvcf.setSexo(rs.getString("SEXO_CF"));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return cvcf;
    }

    @Override
    public int create(ConectVenCF t) {
        String sqlInsert = " INSERT INTO ConectVenCliF (COD_VENTA, DNI_CF, SEXO_CF)" +
                " VALUES (?, ?, ?)";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, t.getCOD_VENTA());
            statement.setString(2, t.getDNI());
            statement.setString(3, t.getSexo());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(ConectVenCF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ConectVenCF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectVenCF> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectVenCF> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
