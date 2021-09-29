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
    private String calleDir;
    private String numDir;
    private String pisoDir;
    private String deptoDir;
    private String codPostal;
    private String localidad;
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
        this.calleDir = aux.calleDir;
        this.numDir = aux.numDir;
        this.pisoDir = aux.pisoDir;
        this.deptoDir = aux.deptoDir;
        this.codPostal = aux.codPostal;
        this.localidad = aux.localidad;
        this.email = aux.email;
    }
    public Persona (String nombre, String apellido, String dni, String sexo, String telefono, String dNac, String mNac, String yNac, String calleDir, String numDir, String pisoDir, String deptoDir, String codPostal, String localidad, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.dNac = dNac;
        this.mNac = mNac;
        this.yNac = yNac;
        this.calleDir = calleDir;
        this.numDir = numDir;
        this.pisoDir = pisoDir;
        this.deptoDir = deptoDir;
        this.codPostal = codPostal;
        this.localidad = localidad;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {//ACOMODAR
        String template = "\tPersona:\n" +
                "Nombre: %s\n" +
                "Apellido: %s\n" +
                "Teléfono: %s\n" +
                "DNI: %s\n" +
                "Sexo: %s\n" +
                "Direccción: %s\n" +
                "Fecha de nacimiento: %s\n" +
                "Email: %s\n";

        return "a";//String.format(template, this.getNombre(), this.getApellido(), this.getTelefono(), this.getDni(), this.getSexo(), this.getDireccion(), this.getFechaNac(), this.getEmail());
    }
    
    
    
}
