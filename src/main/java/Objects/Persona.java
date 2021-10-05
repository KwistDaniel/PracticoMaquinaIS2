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
    private String fNac;
    private String email;
    
    
    
    public Persona(){   
    }
    public Persona(Persona aux){
        this.nombre = aux.nombre;
        this.apellido = aux.apellido;
        this.dni = aux.dni;
        this.sexo = aux.sexo;
        this.telefono = aux.telefono;
        this.fNac = aux.fNac;
        this.email = aux.email;
    }
    public Persona (String nombre, String apellido, String dni, String sexo, String telefono, String fNac, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.fNac = fNac;
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

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " Sexo: " + sexo + " Telefono: " + telefono + " Fecha Nac: " + fNac + " Email: " + email;
    }

    
    
    
    
}
