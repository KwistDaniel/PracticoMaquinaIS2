/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author kwist
 */
public class ConectDirCF {
    private int ID_DIR;
    private String DNI;
    private String Sexo;

    public ConectDirCF() {
    }

    public ConectDirCF(int ID_DIR, String DNI, String Sexo) {
        this.ID_DIR = ID_DIR;
        this.DNI = DNI;
        this.Sexo = Sexo;
    }

    public int getID_DIR() {
        return ID_DIR;
    }

    public void setID_DIR(int ID_DIR) {
        this.ID_DIR = ID_DIR;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    
}
