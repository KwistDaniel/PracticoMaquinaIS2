/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Button;
import java.util.List;

/**
 *
 * @author kwist
 */
public class Envio {
    private int cod;
    private int id_dir;
    private int estado;
    private String fecha;
    private String hora;

    public Envio() {
    }

    public Envio(int cod, int id_dir, int estado, String fecha, String hora) {
        this.cod = cod;
        this.id_dir = id_dir;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public Envio(Envio aux){
        this.cod = aux.cod;
        this.id_dir = aux.id_dir;
        this.estado = aux.estado;
        this.fecha = aux.fecha;
        this.hora = aux.hora;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public static Object[][] getDataVector(List<Envio> envios){
        Object[][] objects = new Object[envios.size()][0];
        for(int i = 0; i < envios.size() ; i++){
            objects[i] = envios.get(i).toObject();
        }   
        return objects;
    }
    public static Object[] getHeaders(){
        return new Object[]{"Codigo de Envio","Codigo de Direccion","Fecha","Hora","Estado"};
    }
    private Object[] toObject(){
        return new Object[]{getCod(),getId_dir(),getFecha(),getHora(),getEstado()};
    }

    
}
