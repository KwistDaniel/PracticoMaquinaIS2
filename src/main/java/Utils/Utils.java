/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objects.Direccion;
import Objects.Envio;

/**
 *
 * @author kwist
 */
public class Utils {
    public String envioydirToString(Envio eaux, Direccion daux){
        String estado = new String("Sin Entregar");
        if(eaux.getEstado() == 1){
            estado = "Entregado";
        }
        String retorno = new String();
        return retorno;
    }
}
