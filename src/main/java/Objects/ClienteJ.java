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
    private String fFund;
    
    public ClienteJ(){
        
    }
    public ClienteJ(ClienteJ aux) {
        this.CUIT = aux.CUIT;
        this.sitIVA = aux.sitIVA;
        this.nombre = aux.nombre;
        this.idDir = aux.idDir;
        this.telefono = aux.telefono;
        this.email = aux.email;
        this.fFund = aux.fFund;
    }
    public ClienteJ(String CUIT, String sitIVA, String nombre, int idDir, String telefono, String email, String fFund) {
        this.CUIT = CUIT;
        this.sitIVA = sitIVA;
        this.nombre = nombre;
        this.idDir = idDir;
        this.telefono = telefono;
        this.email = email;
        this.fFund = fFund;
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

    public String getfFund() {
        return fFund;
    }

    public void setfFund(String fFund) {
        this.fFund = fFund;
    }

    @Override
    public String toString() {
        return "CUIT: " + CUIT + " Nombre: " + nombre + " Situacion IVA: " + sitIVA + " Telefono: " + telefono + " Email: " + email + " Fundacion: " + fFund;
    }
    
    
    
    
    
}
