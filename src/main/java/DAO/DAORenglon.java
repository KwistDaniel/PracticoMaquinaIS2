/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Renglon;
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
public class DAORenglon implements BusinessObject<Renglon>{

    @Override
    public List<Renglon> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Renglon readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Renglon t) {
        String sqlInsert = " INSERT INTO RenglonVenta (COD, ID_Venta, COD_Mercancia, Cantidad, Precio_U, Descuento, Precio_F)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, t.getCOD_Renglon());
            statement.setInt(2, t.getCOD_Venta());
            statement.setInt(3, t.getCOD_Mercancia());
            statement.setInt(4, t.getCantidad());
            statement.setDouble(5, t.getPrecio_U());
            statement.setInt(6, t.getDescuento());
            statement.setDouble(7, t.getPrecio_F());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Renglon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Renglon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Renglon> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        int aux = 0;
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT IFNULL(MAX(COD),0) AS MAXIMO FROM RenglonVenta");
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
    
}
