/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objects.Direccion;
import Objects.Envio;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author kwist
 */
public class Utils {
    public static Color backgroundColor = Color.decode("#D2042D");
    public static Color foregroundColor = Color.decode("#f5f5DC");
    public static Color fontColor = Color.decode("#FAFAFA");
    
    public static String ERROR = "Error";
    public static String EXITO = "Exito";
    public static String WRONGVALUE = "Valor incorrecto";
    public static String SELECTAMOUNT = "Seleccione una cantidad";
    public static String ADVICE = "Aviso";
    
    public static String LOGINERROR = "Datos de inicio de sesion incorrectos";
    
    public static String VENCONFIRM = "¿Desea cargar la venta?";
    public static String VENCONF = "Se ha cargado la venta correctamente";
    public static String HORERR = "Hora incorrecta";
    
    public static String ENVIONOSEL = "No se selecciono ningun envio";
    public static String ENVIOELIM = "Envio eliminado correctamente";
    public static String ENVIONOELIM = "No se pudo eliminar el envio";
    public static String ENVIOYAENT = "Este envio ya fue entregado";
    public static String ENVIOESTACT = "Estado del envio actualizado correctamente";
    public static String ENVIONOESTACT = "No se pudo actualizar el estado del envio";
    
    public static String OPCANCEL = "Operacion cancelada";
    
    
    
    
    
    
    
    public String envioydirToString(Envio eaux, Direccion daux){
        String estado = new String("Sin Entregar");
        if(eaux.getEstado() == 1){
            estado = "Entregado";
        }
        String retorno = new String();
        return retorno;
    }
    
    public static void popUpMSG(String msg, String ttl){
        UIManager UI = new UIManager();
        UI.put("OptionPane.messageForeground",fontColor);
        UI.put("OptionPane.background",backgroundColor);
        UI.put("Panel.background",backgroundColor);
        UI.put("Button.background",backgroundColor);
        UI.put("Button.foreground",fontColor);
        JOptionPane.showMessageDialog(null, msg, ttl, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int popUpYNOp(String msg, String ttl){
        UIManager UI = new UIManager();
        UI.put("OptionPane.messageForeground",fontColor);
        UI.put("OptionPane.background",backgroundColor);
        UI.put("Panel.background",backgroundColor);
        UI.put("Button.background",backgroundColor);
        UI.put("Button.foreground",fontColor);
        return JOptionPane.showConfirmDialog(null,msg,ttl,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
    }
    
    public static String popUpInD(String msg, String ttl){
        UIManager UI = new UIManager();
        UI.put("OptionPane.messageForeground",fontColor);
        UI.put("OptionPane.background",backgroundColor);
        UI.put("Panel.background",backgroundColor);
        UI.put("Button.background",backgroundColor);
        UI.put("Button.foreground",fontColor);
        return JOptionPane.showInputDialog(null,msg,ttl,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean validateDate(final String dateToValidate){
        boolean result;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate check = LocalDate.parse(dateToValidate,df);
        LocalDate now = LocalDate.now(ZoneId.of("America/Argentina/San_Luis"));
        if(check.isBefore(now)){
            result = false;
        }
        else if(check.isEqual(now)){
            result = true;
        }
        else if(check.isAfter(now)){
            result = true;
        }
        else{
            result = false; //x las du
        }
        return result;
    }
    
}
