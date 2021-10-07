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
public class Vendedor extends Persona{
    private int prioridad;
    private String user;
    private String pass;

    public Vendedor() {
        super();
    }

    public Vendedor(Vendedor aux) {
        super(aux);
        this.prioridad = aux.prioridad;
        this.user = aux.user;
        this.pass = aux.pass;
    }

    public Vendedor(int prioridad, String nombre, String apellido, String dni, String sexo, String telefono, String fNac, String email, String user, String pass) {
        super(nombre, apellido, dni, sexo, telefono, fNac, email);
        this.prioridad = prioridad;
        this.user = user;
        this.pass = pass;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
