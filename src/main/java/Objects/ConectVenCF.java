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
public class ConectVenCF {
    private int COD_VENTA;
    private String DNI;
    private String Sexo;

    public ConectVenCF() {
    }

    public ConectVenCF(int COD_VENTA, String DNI, String Sexo) {
        this.COD_VENTA = COD_VENTA;
        this.DNI = DNI;
        this.Sexo = Sexo;
    }

    public int getCOD_VENTA() {
        return COD_VENTA;
    }

    public void setCOD_VENTA(int COD_VENTA) {
        this.COD_VENTA = COD_VENTA;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    
}
