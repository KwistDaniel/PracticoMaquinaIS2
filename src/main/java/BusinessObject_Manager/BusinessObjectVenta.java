/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOVenta;
import Objects.Mercancia;
import Objects.Venta;
import java.util.ArrayList;

/**
 *
 * @author kwist
 */
public class BusinessObjectVenta {
    private static DAO<Venta> ventaDAO;
    
    public static ArrayList<Mercancia> listarMercancias(){
        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>(BusinessObjectMercancia.listarMercancias());
        return mercancias;
    }
    
    public static Venta nuevaVenta(){
        ventaDAO = new DAOVenta();
        Venta v = new Venta();
        v.setCOD_VENTA(ventaDAO.lastCode() + 1);
        return v;
    }
    public static int cargarVenta(Venta v){
        ventaDAO = new DAOVenta();
        return ventaDAO.create(v);
    }
}
