/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



/**
 *
 * @author kwist
 */
public class DAOVendedor implements DAO<Vendedor> {

    @Override
    public List<Vendedor> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendedor readOne(String... ids) {
        Vendedor vendedor = new Vendedor();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vendedor WHERE (Status=1) AND (user='" + ids[0] + "') AND (pass='" + ids[1] + "')");
            while(rs.next()){
                vendedor.setDni(rs.getString("DNI"));
                vendedor.setNombre(rs.getString("NOMBRE"));
                vendedor.setApellido(rs.getString("APELLIDO"));
                vendedor.setTelefono(rs.getString("TELEFONO"));
                vendedor.setSexo(rs.getString("SEXO"));
                vendedor.setfNac(rs.getString("FNac"));
                vendedor.setEmail(rs.getString("EMAIL"));
                vendedor.setUser(rs.getString("USER"));
                vendedor.setPass(rs.getString("PASS"));
                vendedor.setPrioridad(rs.getInt("PRIORITY"));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return vendedor;
    }

    @Override
    public int create(Vendedor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Vendedor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Vendedor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendedor> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendedor> readSome(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
