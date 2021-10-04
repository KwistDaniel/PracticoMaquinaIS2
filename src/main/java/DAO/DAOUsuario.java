/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



/**
 *
 * @author kwist
 */
public class DAOUsuario implements BusinessObject<Usuario> {

    @Override
    public List<Usuario> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario readOne(String... ids) {
        Usuario usuario = new Usuario();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Usuario WHERE (Status=1) AND (id='" + ids[0] + "')");
            while(rs.next()){
                usuario.setUser(rs.getString("id"));
                usuario.setPass(rs.getString("pass"));
                usuario.setPrioridad(rs.getInt("priority"));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return usuario;
    }

    @Override
    public int create(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
