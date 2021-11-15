/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.ClienteJ;
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
public class DAOClienteJ implements DAO<ClienteJ> {

    @Override
    public List<ClienteJ> readAll() {
        List<ClienteJ> clientesj = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ClienteJuridico WHERE ( Status = 1 ) ");
            ClienteJ clientej;
            while (rs.next()){
                clientej = new ClienteJ();
                clientej.setCUIT(rs.getString("CUIT"));
                clientej.setNombre(rs.getString("NOMBRE"));
                clientej.setSitIVA(rs.getString("SITIVA"));
                clientej.setTelefono(rs.getString("TELEFONO"));
                clientej.setEmail(rs.getString("EMAIL"));
                clientej.setfFund(rs.getString("FFund"));
                clientesj.add(clientej);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return clientesj;
    }

    @Override
    public ClienteJ readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(ClienteJ t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(ClienteJ t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ClienteJ t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteJ> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteJ> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
