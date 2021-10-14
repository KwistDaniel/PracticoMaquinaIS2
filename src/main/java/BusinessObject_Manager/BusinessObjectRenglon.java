/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAORenglon;
import Objects.Renglon;

/**
 *
 * @author kwist
 */
public class BusinessObjectRenglon {
    private static DAO<Renglon> renglonDAO;
    
    public static Renglon nuevoRenglon(){
        renglonDAO = new DAORenglon();
        Renglon e = new Renglon();
        e.setCOD_Renglon(renglonDAO.lastCode() + 1);
        return e;
    }
    
    public static int cargarRenglon(Renglon r){
        renglonDAO = new DAORenglon();
        return renglonDAO.create(r);
    }
    
}
