/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOVendedor;
import Objects.Vendedor;

/**
 *
 * @author kwist
 */
public class BusinessObjectVendedor {
    private static DAO<Vendedor> vendedorDAO;
    
    public static Vendedor buscarVendedor(String... ids){
        vendedorDAO = new DAOVendedor();
        Vendedor vendedor = new Vendedor(vendedorDAO.readOne(ids[0],ids[1]));
        return vendedor;
    }
}
