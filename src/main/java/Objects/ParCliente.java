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
public class ParCliente {
    ClienteF clientef;
    ClienteJ clientej;
    int tipo; //1-2
    
    public ParCliente(){
        
    }

    public ParCliente(ClienteF clientef, ClienteJ clientej,int tipo) {
        this.clientef = clientef;
        this.clientej = clientej;
        this.tipo = tipo;
    }

    public ClienteF getClientef() {
        return clientef;
    }

    public void setClientef(ClienteF clientef) {
        this.clientef = clientef;
    }

    public ClienteJ getClientej() {
        return clientej;
    }

    public void setClientej(ClienteJ clientej) {
        this.clientej = clientej;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
