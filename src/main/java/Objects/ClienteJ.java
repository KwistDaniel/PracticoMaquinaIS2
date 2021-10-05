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
public class ClienteJ {
    private String CUIT;
    private String sitIVA;
    private String nombre;
    private int idDir; //REVISAR
    private String telefono;
    private String email;
    private String dFund;
    private String mFund;
    private String yFund;
    
    public ClienteJ(){
        
    }
    public ClienteJ(ClienteJ aux) {
        this.CUIT = aux.CUIT;
        this.sitIVA = aux.sitIVA;
        this.nombre = aux.nombre;
        this.idDir = aux.idDir;
        this.telefono = aux.telefono;
        this.email = aux.email;
        this.dFund = aux.dFund;
        this.mFund = aux.mFund;
        this.yFund = aux.yFund;
    }
    public ClienteJ(String CUIT, String sitIVA, String nombre, int idDir, String telefono, String email, String dFund, String mFund, String yFund) {
        this.CUIT = CUIT;
        this.sitIVA = sitIVA;
        this.nombre = nombre;
        this.idDir = idDir;
        this.telefono = telefono;
        this.email = email;
        this.dFund = dFund;
        this.mFund = mFund;
        this.yFund = yFund;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getSitIVA() {
        return sitIVA;
    }

    public void setSitIVA(String sitIVA) {
        this.sitIVA = sitIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdFund() {
        return dFund;
    }

    public void setdFund(String dFund) {
        this.dFund = dFund;
    }

    public String getmFund() {
        return mFund;
    }

    public void setmFund(String mFund) {
        this.mFund = mFund;
    }

    public String getyFund() {
        return yFund;
    }

    public void setyFund(String yFund) {
        this.yFund = yFund;
    }

    @Override
    public String toString() {
        return "CUIT: " + CUIT + " Nombre: " + nombre + " Situacion IVA: " + sitIVA + " Telefono: " + telefono + " Email: " + email + " Fundacion: " + dFund + "/" + mFund + "/" + yFund;
    }
    
    
    
    
    
}
