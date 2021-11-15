/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOClienteJ;
import DAO.DAODireccion;
import Objects.ClienteJ;
import Objects.Direccion;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectClienteJ {
    private static DAO<ClienteJ> clientejDAO;
    private static DAO<Direccion> direccioncjDAO;
    
    public static ArrayList<ClienteJ> listarClientesJ(){
        clientejDAO = new DAOClienteJ();
        ArrayList<ClienteJ> clientesj = new ArrayList<ClienteJ>(clientejDAO.readAll());
        return clientesj;
    }
    
    public static ArrayList<Direccion> listarDireccionClientesJ(ClienteJ cj){
        
        ArrayList<Direccion> direccionescj = new ArrayList<Direccion>(BusinessObjectDireccion.direccionesClientesJ(cj));
        return direccionescj;
    }
}
