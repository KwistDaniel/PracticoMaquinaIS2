/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOEnvio;
import Objects.Envio;

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
}
