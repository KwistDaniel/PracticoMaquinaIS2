/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOEnvio;
import Objects.Envio;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectEnvio {
    private static DAO<Envio> envioDAO;
    
    public static Envio nuevoEnvio(){
        envioDAO = new DAOEnvio();
        Envio e = new Envio();
        e.setCod(envioDAO.lastCode() + 1);
        return e;
    }
    
    public static int cargarEnvio(Envio e){
        envioDAO = new DAOEnvio();
        return envioDAO.create(e);
    }
    
    public static ArrayList<Envio> listarEnvios(){
        envioDAO = new DAOEnvio();
        ArrayList<Envio> envios = new ArrayList<Envio> (envioDAO.readAll());
        return envios;
    }
    
    public static int actualizarEstado(Envio e){
        envioDAO = new DAOEnvio();
        return envioDAO.update(e);
    }
    
    public static int eliminarEnvio(Envio e){
        envioDAO = new DAOEnvio();
        return envioDAO.delete(e);
    }
}
