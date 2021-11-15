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
    private String sitIva;
    private String cuit_l;
    
    public ClienteF(){
        
    }
    
    public ClienteF (ClienteF aux){
        super(aux);
        this.sitIva = aux.sitIva;
        this.cuit_l = aux.cuit_l;
    }
  
    public ClienteF(String nombre, String apellido, String dni, String sexo, String telefono, String fNac, String email, String sitIva, String cuit_l){
        super(nombre,apellido,dni,sexo,telefono,fNac,email);
        this.sitIva = sitIva;
        this.cuit_l = cuit_l;
    }

    public String getSitIva() {
        return sitIva;
    }

    public void setSitIva(String sitIva) {
        this.sitIva = sitIva;
    }

    public String getCuit_l() {
        return cuit_l;
    }

    public void setCuit_l(String cuit_l) {
        this.cuit_l = cuit_l;
    }
    
    public static Object[][] getDataVector(List<ClienteF> clientef){
        Object[][] objects = new Object[clientef.size()][0];
        for(int i = 0; i < clientef.size() ; i++){
            objects[i] = clientef.get(i).toObject();
        }   
        return objects;
    }
    public static Object[] getHeaders(){
        return new Object[]{"Nombre","Apellido","DNI","Sexo","Telefono","Nacimiento","Email","Situacion IVA","CUIT-CUIL"};
    }
    private Object[] toObject(){
        return new Object[]{getNombre(),getApellido(),getDni(),getSexo(),getTelefono(),getfNac(),getEmail(),getSitIva(),getCuit_l()};
    }
    
    @Override
    public String toString(){
        return "Cliente: \n Nombre: " + getNombre() + "\n Apellido: " + getApellido() + "\n DNI: " + getDni() + "\n Sexo: " + getSexo() + "\n Telefono: " + getTelefono() + "\n Fecha Nac: " + getfNac() + "\n Email: " + getEmail() + "\n Situacion IVA: " + getSitIva() + "\n CUIT: " + getCuit_l();
    }
    
    
}