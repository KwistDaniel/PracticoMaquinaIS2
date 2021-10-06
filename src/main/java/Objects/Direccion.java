/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.List;

/**
 *
 * @author kwist
 */
public class Direccion {
    private int idDir;
    private String calleDir;
    private String numDir;
    private String pisoDir;
    private String deptoDir;
    private String codPostal;
    private String localidad;

    public Direccion() {
    }

    public Direccion(int idDir, String calleDir, String numDir, String pisoDir, String deptoDir, String codPostal, String localidad) {
        this.idDir = idDir;
        this.calleDir = calleDir;
        this.numDir = numDir;
        this.pisoDir = pisoDir;
        this.deptoDir = deptoDir;
        this.codPostal = codPostal;
        this.localidad = localidad;
    }
    
    public Direccion(Direccion aux) {
        this.idDir = aux.idDir;
        this.calleDir = aux.calleDir;
        this.numDir = aux.numDir;
        this.pisoDir = aux.pisoDir;
        this.deptoDir = aux.deptoDir;
        this.codPostal = aux.codPostal;
        this.localidad = aux.localidad;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getCalleDir() {
        return calleDir;
    }

    public void setCalleDir(String calleDir) {
        this.calleDir = calleDir;
    }

    public String getNumDir() {
        return numDir;
    }

    public void setNumDir(String numDir) {
        this.numDir = numDir;
    }

    public String getPisoDir() {
        return pisoDir;
    }

    public void setPisoDir(String pisoDir) {
        this.pisoDir = pisoDir;
    }

    public String getDeptoDir() {
        return deptoDir;
    }

    public void setDeptoDir(String deptoDir) {
        this.deptoDir = deptoDir;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public static Object[][] getDataVector(List<Direccion> direccion){
        Object[][] objects = new Object[direccion.size()][0];
        for(int i = 0; i < direccion.size() ; i++){
            objects[i] = direccion.get(i).toObject();
        }   
        return objects;
    }
    public static Object[] getHeaders(){
        return new Object[]{"ID","Calle","Numero","Piso","Depto","Codigo Postal","Localidad"};
    }
    private Object[] toObject(){
        return new Object[]{getIdDir(),getCalleDir(),getNumDir(),getPisoDir(),getDeptoDir(),getCodPostal(),getLocalidad()};
    }
    
    
}
