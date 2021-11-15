/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.ArrayList;


/**
 *
 * @author tovib
 */
public class Presupuesto {
    private int cod_Presupuesto;
    private String fecha,fecha_Vencimiento;
    private int dni_Cliente;
    private String vendedor;
    ArrayList <Renglon> list_mercancia = new ArrayList<>();
    
  
    public Presupuesto (int cod_Presupuesto,String fecha,String fecha_Vencimiento, int dni_cliente,String vendedor,ArrayList<Renglon> list_mercancia){

        this.cod_Presupuesto = cod_Presupuesto;
        this.dni_Cliente = dni_cliente;
        this.fecha = fecha;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.vendedor = vendedor;
        this.list_mercancia = list_mercancia;
}

    public int getCod_Presupuesto() {
        return cod_Presupuesto;
    }

    public void setCod_Presupuesto(int cod_Presupuesto) {
        this.cod_Presupuesto = cod_Presupuesto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public int getDni_Cliente() {
        return dni_Cliente;
    }

    public void setDni_Cliente(int dni_Cliente) {
        this.dni_Cliente = dni_Cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Renglon> getList_mercancia() {
        return list_mercancia;
    }

    public void setList_mercancia(ArrayList<Renglon> list_mercancia) {
        this.list_mercancia = list_mercancia;
    }
    
    
}
