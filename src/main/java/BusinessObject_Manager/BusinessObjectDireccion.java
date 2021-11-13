/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAODireccion;
import Objects.ClienteF;
import Objects.Direccion;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectDireccion {
    private static DAO<Direccion> direccionDAO;
    
    public static ArrayList<Direccion> direccionesClientesF(ClienteF cf){
        direccionDAO = new DAODireccion();
        ArrayList<Direccion> direcciones = new ArrayList<Direccion>(direccionDAO.readAllIds(cf.getDni(),cf.getSexo()));
        return direcciones;
    }
    
    public static Direccion readDir(String... ids){
        direccionDAO = new DAODireccion();
        Direccion dir = new Direccion(direccionDAO.readOne(ids[0]));
        return dir;
    }

}
