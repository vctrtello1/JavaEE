package com.victortello.PoolTransaccional;

import java.sql.SQLException;
import java.util.Date;

import com.victortello.PoolTransaccional.models.Categoria;
import com.victortello.PoolTransaccional.models.Producto;
import com.victortello.PoolTransaccional.service.CatalogoServicio;
import com.victortello.PoolTransaccional.service.Servicio;

public class PoolTransaccional {

    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();

        // Instertar nueva categoria

        System.out.println("Nueva categoria");

        Categoria categoria = new Categoria();
        categoria.setCnombre_categoria("linea blanca");
        servicio.guardarCategoria(categoria);

        // insertar nuevo produco

        System.out.println("Nuevo producto");

        Producto productoNuevo = new Producto();
        productoNuevo.setCnombre_articulo("Marrucol");
        productoNuevo.setFprecio((float) 50);
        productoNuevo.setDfecha_registro(new Date());
        Categoria categoriaNueva = new Categoria();
        categoriaNueva.setId_categoria(2L);
        productoNuevo.setCategoria(categoriaNueva);
        productoNuevo.setSku("6");
        servicio.guardarProductoConCategoria(productoNuevo, categoria);

        System.out.println("________________________");
        // listar productos
        servicio.listarProductos().forEach(System.out::println);

        // Actualizar producto

        System.out.println("Actualizar producto");

        Producto producto = new Producto();
        producto.setId(1L);
        producto.setCnombre_articulo("Caguama");
        producto.setFprecio((float) 150);
        producto.setDfecha_registro(new Date());

        producto.setCategoria(categoria);
        producto.setSku("7");
        servicio.guardarProductoConCategoria(producto, categoria);

        producto.setSku("9");
        servicio.guardarProductoConCategoria(producto, categoria);

        System.out.println("________________________");
        // listar productos
        servicio.listarProductos().forEach(System.out::println);

    }

}
