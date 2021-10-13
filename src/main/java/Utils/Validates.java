/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author kwist
 */
public class Validates {
    public static int validateIsNumber(final String s){
        if (s == null){
            return 0;
        }
        try{
            int exito = Integer.parseInt(s);
        } catch (NumberFormatException nfe){
            return 0;
        }
        return 1;
    }
    
    
    public static int validateHora(final String h, final String m){
        if((validateIsNumber(h) == 1) && (validateIsNumber(m) == 1)){
            int hh = Integer.parseInt(h), hm = Integer.parseInt(m);
            if(!((hh < 0 || hh > 24) || (hm < 0 || hm > 60))){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
}
