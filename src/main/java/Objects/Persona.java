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
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String sexo;
    private String telefono;
    private String dNac;
    private String mNac;
    private String yNac;
    private int idDir;
    private String email;
    
    
    
    public Persona(){   
    }
    public Persona(Persona aux){
        this.nombre = aux.nombre;
        this.apellido = aux.apellido;
        this.dni = aux.dni;
        this.sexo = aux.sexo;
        this.telefono = aux.telefono;
        this.dNac = aux.dNac;
        this.mNac = aux.mNac;
        this.yNac = aux.yNac;
        this.idDir = aux.idDir;
        this.email = aux.email;
    }
    public Persona (String nombre, String apellido, String dni, String sexo, String telefono, String dNac, String mNac, String yNac, int idDir, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.dNac = dNac;
        this.mNac = mNac;
        this.yNac = yNac;
        this.idDir = idDir;
        this.email = email;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getdNac() {
        return dNac;
    }

    public void setdNac(String dNac) {
        this.dNac = dNac;
    }

    public String getmNac() {
        return mNac;
    }

    public void setmNac(String mNac) {
        this.mNac = mNac;
    }

    public String getyNac() {
        return yNac;
    }

    public void setyNac(String yNac) {
        this.yNac = yNac;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
