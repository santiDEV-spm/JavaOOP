package com.santidev.appfacturas.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int id;
    private  String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<ItemFactura> items;

    private static int ultimoId;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ArrayList<ItemFactura>();
        this.id = ++ultimoId;
        this.fecha = new Date();
    }

    public int getId() {
        return id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){
        this.items.add(item);
    }
}
