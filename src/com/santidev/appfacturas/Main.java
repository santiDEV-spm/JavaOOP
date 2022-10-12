package com.santidev.appfacturas;

import com.santidev.appfacturas.modelo.Cliente;
import com.santidev.appfacturas.modelo.Factura;
import com.santidev.appfacturas.modelo.ItemFactura;
import com.santidev.appfacturas.modelo.Producto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRfc("PEMS000815EQ9");
        cliente.setNombre("Santiago");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la factura: ");
        String desc = sc.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto No. " + producto.getCodigo() + ": ");
            nombre = sc.next();
            producto.setNombre(nombre);

            System.out.println("ingrese el precio: ");
            precio = sc.nextFloat();
            producto.setPrecio(precio);

            System.out.println("Ingrese la cantidad: ");
            cantidad = sc.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println();

        }

        System.out.println(factura.generarDetalle());
    }

}
