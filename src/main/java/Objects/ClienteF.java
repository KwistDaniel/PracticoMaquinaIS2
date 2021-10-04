/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.List;

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
    
    public static Object[][] getDataVector(List<ClienteF> clientef){
        Object[][] objects = new Object[clientef.size()][0];
        for(int i = 0; i < clientef.size() ; i++){
            objects[i] = clientef.get(i).toObject();
        }   
        return objects;
    }
    private Object[] toObject(){
        return new Object[]{getNombre(),getApellido(),getDni(),getSexo(),getTelefono(),getdNac(),getmNac(),getyNac(),getdireccion(),getEmail()};
    }
}