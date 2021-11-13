/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Envio;
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
public class DAOEnvio implements DAO<Envio> {

    @Override
    public List<Envio> readAll() {
        List<Envio> envios = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Envio WHERE ( Status = 1 ) ");
            Envio envio;
            while (rs.next()){
                envio = new Envio();
                envio.setCod(rs.getInt("COD"));
                envio.setId_dir(rs.getInt("ID_DIR"));
                envio.setEstado(rs.getInt("ESTADO_ENVIO"));
                envio.setFecha(rs.getString("FECHA_ENVIO"));
                envio.setHora(rs.getString("HORA_ENVIO"));
                envios.add(envio);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return envios;
    }

    @Override
    public Envio readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Envio t) {
        String sqlInsert = " INSERT INTO Envio (COD, ID_DIR, ESTADO_ENVIO, FECHA_ENVIO, HORA_ENVIO, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, t.getCod());
            statement.setInt(2, t.getId_dir());
            statement.setInt(3, t.getEstado());
            statement.setString(4, t.getFecha());
            statement.setString(5, t.getHora());
            statement.setInt(6, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Envio t) {
        String sqlUpdate = " UPDATE Envio SET ID_DIR = ?, ESTADO_ENVIO = ?, FECHA_ENVIO = ?, HORA_ENVIO = ?" +
                " WHERE (COD = '" + t.getCod() + "')";
        int exito = 0;
        Connection connection = DataBase.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setInt(1, t.getId_dir());
            statement.setInt(2, t.getEstado());
            statement.setString(3, t.getFecha());
            statement.setString(4, t.getHora());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Envio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Envio> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        int aux = 0;
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT IFNULL(MAX(COD),0) AS MAXIMO FROM Envio");
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
    public List<Envio> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
