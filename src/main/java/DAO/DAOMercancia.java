/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Mercancia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kwist
 */
public class DAOMercancia implements BusinessObject<Mercancia> {

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
                mercancia.setPartida(rs.getInt("PARTIDA"));
                mercancias.add(mercancia);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return mercancias;
    }

    
    
    
    @Override
    public Mercancia readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Mercancia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Mercancia mercancia) {
        String sqlUpdate = "UPDATE Mercancia SET NOMBRE = ?, DESCRIPCION = ?, PRECIO_UNITARIO = ?, CANTIDAD = ?, COLOR = ?, CATEGORIA = ?, CALIDAD = ?, MEDIDA_ANCHO = ?, MEDIDA_ALTO = ?, METROS_CUADRADOS = ?" +
                "WHERE (COD = '" + mercancia.getCod() + "')";
        int exito =0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try{
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1,mercancia.getNombre());
            statement.setString(2,mercancia.getDescripcion());
            statement.setDouble(3,mercancia.getPrecio_u());
            statement.setInt(4, mercancia.getCantidad());
            statement.setString(5,mercancia.getColor());
            statement.setString(6,mercancia.getCategoria());
            statement.setInt(7,mercancia.getCalidad());
            statement.setInt(8,mercancia.getAncho());
            statement.setInt(9,mercancia.getAlto());
            statement.setInt(10,mercancia.getMetcuad());
            statement.executeUpdate();
            exito = 1;
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Mercancia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
