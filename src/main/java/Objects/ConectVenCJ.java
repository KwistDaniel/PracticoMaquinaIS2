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
public class ConectVenCJ {
    private int COD_VENTA;
    private String CUIT;

    public ConectVenCJ() {
    }

    public ConectVenCJ(int COD_VENTA, String CUIT) {
        this.COD_VENTA = COD_VENTA;
        this.CUIT = CUIT;
    }
    
    public ConectVenCJ(ConectVenCJ cvcj) {
        this.COD_VENTA = cvcj.COD_VENTA;
        this.CUIT = cvcj.CUIT;
    }

    public int getCOD_VENTA() {
        return COD_VENTA;
    }

    public void setCOD_VENTA(int COD_VENTA) {
        this.COD_VENTA = COD_VENTA;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

}
