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
public class ConectDirCJ {
    private int ID_DIR;
    private String CUIT;

    public ConectDirCJ() {
    }

    public ConectDirCJ(int ID_DIR, String CUIT) {
        this.ID_DIR = ID_DIR;
        this.CUIT = CUIT;
    }

    public int getID_DIR() {
        return ID_DIR;
    }

    public void setID_DIR(int ID_DIR) {
        this.ID_DIR = ID_DIR;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
    
    
}
