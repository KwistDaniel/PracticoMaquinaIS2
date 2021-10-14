/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.ClienteF;
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
public class DAOClienteF implements DAO<ClienteF> {

    @Override
    public List<ClienteF> readAll() {
        List<ClienteF> clientesf = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ClienteFisico WHERE ( Status = 1 ) ");
            ClienteF clientef;
            while (rs.next()){
                clientef = new ClienteF();
                clientef.setDni(rs.getString("DNI"));
                clientef.setNombre(rs.getString("NOMBRE"));
                clientef.setApellido(rs.getString("APELLIDO"));
                clientef.setTelefono(rs.getString("TELEFONO"));
                clientef.setSexo(rs.getString("SEXO"));
                clientef.setfNac(rs.getString("FNac"));
                clientef.setEmail(rs.getString("EMAIL"));
                clientesf.add(clientef);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return clientesf;
    }

    @Override
    public ClienteF readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(ClienteF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(ClienteF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ClienteF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteF> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteF> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
