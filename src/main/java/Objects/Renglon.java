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
public class Renglon {
    private int ID_Venta;
    private int COD_Mercancia;
    private int Cantidad;
    private double Precio_U;
    private int Descuento;
    private double Precio_F;

    public Renglon() {
    }

    public Renglon(int ID_Venta, int COD_Mercancia, int Cantidad, double Precio_U, int Descuento, double Precio_F) {
        this.ID_Venta = ID_Venta;
        this.COD_Mercancia = COD_Mercancia;
        this.Cantidad = Cantidad;
        this.Precio_U = Precio_U;
        this.Descuento = Descuento;
        this.Precio_F = Precio_F;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public int getCOD_Mercancia() {
        return COD_Mercancia;
    }

    public void setCOD_Mercancia(int COD_Mercancia) {
        this.COD_Mercancia = COD_Mercancia;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio_U() {
        return Precio_U;
    }

    public void setPrecio_U(double Precio_U) {
        this.Precio_U = Precio_U;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public double getPrecio_F() {
        return Precio_F;
    }

    public void setPrecio_F(double Precio_F) {
        this.Precio_F = Precio_F;
    }
    
    
}
