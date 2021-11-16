/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject_Manager;

import DAO.DAO;
import DAO.DAOConectVenCF;
import Objects.ClienteF;
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
    
    public static ClienteF recuperarCF(int codv){
        conectVenCF = new DAOConectVenCF();
        ConectVenCF cvcf = new ConectVenCF();
        try{
            cvcf = new ConectVenCF(conectVenCF.readOne(String.valueOf(codv)));
        }
        catch(Exception e){
            cvcf.setDNI("0");
            cvcf.setSexo("0");
        }
        ClienteF cf = new ClienteF();
        cf.setDni(cvcf.getDNI());
        cf.setSexo(cvcf.getSexo());
        return cf;
    }
}
