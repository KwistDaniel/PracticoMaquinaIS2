/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOConectVenCF;
import Objects.ConectVenCF;

/**
 *
 * @author kwist
 */
public class BusinessObjectConVenCF {
    private static DAO<ConectVenCF> conectVenCF;
    
    public static int cargarConectVenCF(ConectVenCF c){
        conectVenCF = new DAOConectVenCF();
        return conectVenCF.create(c);
    }
}
