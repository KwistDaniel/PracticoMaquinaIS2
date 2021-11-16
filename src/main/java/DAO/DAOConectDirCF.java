/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.DataBase;
import Objects.ConectDirCF;
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
public class DAOConectDirCF implements DAO<ConectDirCF> {

    @Override
    public List<ConectDirCF> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConectDirCF readOne(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(ConectDirCF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(ConectDirCF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ConectDirCF t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectDirCF> readAllIds(String... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConectDirCF> readSome(String... ids) {
        //Aparentemente sin uso todavia. (Find Usages no devolvio resultados)
        List<ConectDirCF> conectoresdircf = new ArrayList<>();
        Connection connection = DataBase.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ConectDirCliF WHERE ((Status = 1) && (DNI_CF = '" + ids[0] + "') && (SEXO_CF = '" + ids[1] + "') ) ");
            ConectDirCF conectordircf;
            while (rs.next()){
                conectordircf = new ConectDirCF();
                conectordircf.setID_DIR(rs.getInt("ID_DIR"));
                conectordircf.setDNI(rs.getString("DNI_CF"));
                conectordircf.setSexo(rs.getString("SEXO_CF"));
                conectoresdircf.add(conectordircf);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        DataBase.getInstance().disconnect();
        return conectoresdircf;
    }
    
}
