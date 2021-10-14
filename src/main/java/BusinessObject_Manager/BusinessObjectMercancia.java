/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOMercancia;
import Objects.Mercancia;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectMercancia {
    
    private static DAO<Mercancia> mercanciaDAO;
    
    public static ArrayList<Mercancia> listarMercancias(){
        mercanciaDAO = new DAOMercancia();
        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>(mercanciaDAO.readAll());
        return mercancias;
    }
    
    public static int modificarMercancia(Mercancia m){
        int exito;
        mercanciaDAO = new DAOMercancia();
        exito = mercanciaDAO.update(m);
        return exito;
    }
}
