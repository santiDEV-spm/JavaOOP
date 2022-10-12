package com.santidev.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int id;
    private String descripcion;
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

    public void addItemFactura(ItemFactura item) {
        this.items.add(item);
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("Factura No: ");
        sb.append("Fecha Emisión:").append(df.format(this.fecha))
                .append("\n");
        sb.append(id)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t\t RFC: ")
                .append(cliente.getRfc())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n")
                .append("\n#\t\tNombre\t\t$\t\tCant.\t\tTotal\n");


        for (ItemFactura item: this.items) {
            sb.append(item.getProducto().getCodigo())
                    .append("\t\t")
                    .append(item.getProducto().getNombre())
                    .append("\t\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t\t")
                    .append(item.getCantidad())
                    .append("\t\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }

        sb.append("\nTotal General: ").append(calcularTotal());

        return sb.toString();
    }
}
