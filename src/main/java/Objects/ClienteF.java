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
public class ClienteF extends Persona {
    public ClienteF(){
        
    }
    
    public ClienteF (ClienteF aux){
        super(aux);
    }
  
    public ClienteF(String nombre, String apellido, String dni, String sexo, String telefono, String dNac, String mNac, String yNac, Direccion direccion , String email){
        super(nombre,apellido,dni,sexo,telefono,dNac,mNac,yNac,direccion,email);
    }
}