/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Direccion;
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
public class DAODireccion implements BusinessObject<Direccion> {

    @Override
    public List<Direccion> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direccion readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Direccion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Direccion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Direccion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Direccion> readAllIds(String... ids) {
        List<Direccion> direcciones = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT ID,CALLE,NUMERO,PISO,DEPTO,COD_POSTAL,LOCALIDAD FROM Direccion INNER JOIN (" + ids[0] + ") AS DJ ON ID = DJ.ID_DIR WHERE (Status=1)");
            Direccion direccion;
            while (rs.next()){
                direccion = new Direccion();
                direccion.setIdDir(rs.getInt("ID"));
                direccion.setCalleDir(rs.getString("CALLE"));
                direccion.setNumDir(rs.getString("NUMERO"));
                direccion.setPisoDir(rs.getString("PISO"));
                direccion.setDeptoDir(rs.getString("DEPTO"));
                direccion.setCodPostal(rs.getString("COD_POSTAL"));
                direccion.setLocalidad(rs.getString("LOCALIDAD"));
                direcciones.add(direccion);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return direcciones;
    }

    @Override
    public Direccion lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
