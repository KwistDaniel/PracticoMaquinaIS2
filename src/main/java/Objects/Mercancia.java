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
public class Mercancia {
    private int cod;
    private String nombre;
    private String categoria;
    private String descripcion;
    private int cantidad;
    private double precio_u;
    private String color;
    private int tipo; //0 cualq, 1 porcelanato y ceramicos
    private int partida;
    private int ancho;
    private int alto;
    private int metcuad;
    private int calidad;

    public Mercancia() {
    }

    public Mercancia(int cod, String nombre, String categoria, String descripcion, int cantidad, double precio_u, String color, int tipo, int partida, int ancho, int alto, int metcuad, int calidad) {
        this.cod = cod;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_u = precio_u;
        this.color = color;
        this.tipo = tipo;
        this.partida = partida;
        this.ancho = ancho;
        this.alto = alto;
        this.metcuad = metcuad;
        this.calidad = calidad;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_u() {
        return precio_u;
    }

    public void setPrecio_u(double precio_u) {
        this.precio_u = precio_u;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getMetcuad() {
        return metcuad;
    }

    public void setMetcuad(int metcuad) {
        this.metcuad = metcuad;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }
    
    public static Object[][] getDataVector(List<Mercancia> mercancias){
        Object[][] objects = new Object[mercancias.size()][0];
        for(int i = 0; i < mercancias.size() ; i++){
            objects[i] = mercancias.get(i).toObject();
        }   
        return objects;
    }
    
    public static Object[] getHeaders(){
        return new Object[]{"Codigo","Nombre","Descripcion","Precio Unitario","Cantidad","Color","Categoria","Calidad","Ancho","Alto","Metros Cuadrados"};
    }
    
    private Object[] toObject(){
        return new Object[]{getCod(),getNombre(),getDescripcion(),getPrecio_u(),getCantidad(),getColor(),getCategoria(),getCalidad(),getAncho(),getAlto(),getMetcuad()};
    }

    @Override
    public String toString() {
        return cod + " " + nombre + " " + descripcion; 
    }
    
    
    
}
