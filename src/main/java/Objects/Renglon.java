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
    private int COD_Renglon;
    private int COD_Venta;
    private int COD_Mercancia;
    private int PARTIDA_Mercancia;
    private int Cantidad;
    private double Precio_U;
    private int Descuento;
    private double Precio_F;

    public Renglon() {
    }

    public Renglon(int COD_Renglon, int COD_Venta, int COD_Mercancia, int PARTIDA_Mercancia, int Cantidad, double Precio_U, int Descuento, double Precio_F) {
        this.COD_Renglon = COD_Renglon;
        this.COD_Venta = COD_Venta;
        this.COD_Mercancia = COD_Mercancia;
        this.PARTIDA_Mercancia = PARTIDA_Mercancia;
        this.Cantidad = Cantidad;
        this.Precio_U = Precio_U;
        this.Descuento = Descuento;
        this.Precio_F = Precio_F;
    }
    
    public Renglon(Renglon aux){
        this.COD_Renglon = aux.COD_Renglon;
        this.COD_Venta = aux.COD_Venta;
        this.COD_Mercancia = aux.COD_Mercancia;
        this.PARTIDA_Mercancia = aux.PARTIDA_Mercancia;
        this.Cantidad = aux.Cantidad;
        this.Precio_U = aux.Precio_U;
        this.Descuento = aux.Descuento;
        this.Precio_F = aux.Precio_F;
    }

    public int getCOD_Renglon() {
        return COD_Renglon;
    }

    public void setCOD_Renglon(int COD_Renglon) {
        this.COD_Renglon = COD_Renglon;
    }

    public int getCOD_Venta() {
        return COD_Venta;
    }

    public void setCOD_Venta(int ID_Venta) {
        this.COD_Venta = ID_Venta;
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

    public int getPARTIDA_Mercancia() {
        return PARTIDA_Mercancia;
    }

    public void setPARTIDA_Mercancia(int PARTIDA_Mercancia) {
        this.PARTIDA_Mercancia = PARTIDA_Mercancia;
    }
    
    
}
