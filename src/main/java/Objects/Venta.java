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
public class Venta {
    private int COD_VENTA;
    private String DNI_V;
    private String Sexo_V;
    private double P_Total;
    private double P_Final;
    private int COD_ENVIO;
    
    public Venta(){
        
    };

    public Venta(int COD_VENTA, String DNI_V, String Sexo_V, double P_Total, double P_Final, int COD_ENVIO) {
        this.COD_VENTA = COD_VENTA;
        this.DNI_V = DNI_V;
        this.Sexo_V = Sexo_V;
        this.P_Total = P_Total;
        this.P_Final = P_Final;
        this.COD_ENVIO = COD_ENVIO;
    }
    
    public Venta(Venta aux) {
        this.COD_VENTA = aux.COD_VENTA;
        this.DNI_V = aux.DNI_V;
        this.Sexo_V = aux.Sexo_V;
        this.P_Total = aux.P_Total;
        this.P_Final = aux.P_Final;
        this.COD_ENVIO = aux.COD_ENVIO;
    }

    public int getCOD_VENTA() {
        return COD_VENTA;
    }

    public void setCOD_VENTA(int COD_VENTA) {
        this.COD_VENTA = COD_VENTA;
    }

    public String getDNI_V() {
        return DNI_V;
    }

    public void setDNI_V(String DNI_V) {
        this.DNI_V = DNI_V;
    }

    public String getSexo_V() {
        return Sexo_V;
    }

    public void setSexo_V(String Sexo_V) {
        this.Sexo_V = Sexo_V;
    }

    public double getP_Total() {
        return P_Total;
    }

    public void setP_Total(double P_Total) {
        this.P_Total = P_Total;
    }

    public double getP_Final() {
        return P_Final;
    }

    public void setP_Final(double P_Final) {
        this.P_Final = P_Final;
    }

    public int getCOD_ENVIO() {
        return COD_ENVIO;
    }

    public void setCOD_ENVIO(int COD_ENVIO) {
        this.COD_ENVIO = COD_ENVIO;
    }
    
    
            
}
