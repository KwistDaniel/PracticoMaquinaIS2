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
public class Usuario {
    private String user;
    private String pass;
    private int prioridad;
    
    public Usuario(){
        
    }
    
    public Usuario(Usuario usuario){
        this.user = usuario.user;
        this.pass = usuario.pass;
        this.prioridad = usuario.prioridad;
    }

    public Usuario(String user, String pass, int prioridad) {
        this.user = user;
        this.pass = pass;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
