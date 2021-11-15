/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOConectVenCJ;
import Objects.ConectVenCJ;

/**
 *
 * @author kwist
 */
public class BusinessObjectConVenCJ {
    private static DAO<ConectVenCJ> conectVenCJ;
    
    public static int cargarConectVenCJ(ConectVenCJ c){
        conectVenCJ = new DAOConectVenCJ();
        return conectVenCJ.create(c);
    }
}
