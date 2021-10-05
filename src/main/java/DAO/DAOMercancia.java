/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Mercancia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kwist
 */
public class DAOMercancia implements BusinessObject {

    @Override
    public List<Mercancia> readAll() {
        List<Mercancia> mercancias = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Mercancia WHERE ( Status = 1 ) ");
            Mercancia mercancia;
            while (rs.next()){
                mercancia = new Mercancia();
                mercancia.setCod(rs.getInt("COD"));
                mercancia.setNombre(rs.getString("NOMBRE"));
                mercancia.setDescripcion(rs.getString("DESCRIPCION"));
                mercancia.setPrecio_u(rs.getDouble("PRECIO_UNITARIO"));
                mercancia.setCantidad(rs.getInt("CANTIDAD"));
                mercancia.setColor(rs.getString("COLOR"));
                mercancia.setCategoria(rs.getString("CATEGORIA"));
                mercancia.setCalidad(rs.getInt("CALIDAD"));
                mercancia.setAncho(rs.getInt("MEDIDA_ANCHO"));
                mercancia.setAlto(rs.getInt("MEDIDA_ALTO"));
                mercancia.setMetcuad(rs.getInt("METROS_CUADRADOS"));
                mercancias.add(mercancia);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return mercancias;
    }

    @Override
    public Object readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
