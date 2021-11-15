/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOConectVenCJ;
import Objects.ClienteJ;
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
    
    public static ClienteJ recuperarCJ(int codv){
        conectVenCJ = new DAOConectVenCJ();
        ConectVenCJ cvcj = new ConectVenCJ();
        try{
            cvcj = new ConectVenCJ(conectVenCJ.readOne(String.valueOf(codv)));
        }
        catch(Exception e){
            cvcj.setCUIT("0");
        }
        ClienteJ cj = new ClienteJ();
        cj.setCUIT(cvcj.getCUIT());
        return cj;
    }
}
