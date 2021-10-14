/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOClienteF;
import DAO.DAODireccion;
import Objects.ClienteF;
import Objects.Direccion;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectClienteF {
    private static DAO<ClienteF> clientefDAO;
    private static DAO<Direccion> direccioncfDAO;
    
    public static ArrayList<ClienteF> listarClientesF(){
        clientefDAO = new DAOClienteF();
        ArrayList<ClienteF> clientesf = new ArrayList<ClienteF>(clientefDAO.readAll());
        return clientesf;
    }
    
    public static ArrayList<Direccion> listarDireccionClientesF(ClienteF cf){
        
        ArrayList<Direccion> direccionescf = new ArrayList<Direccion>(BusinessObjectDireccion.direccionesClientesF(cf));
        return direccionescf;
    }
}
