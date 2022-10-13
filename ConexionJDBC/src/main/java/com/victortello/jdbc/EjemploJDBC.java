package com.victortello.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.victortello.jdbc.models.Categoria;
import com.victortello.jdbc.models.Producto;
import com.victortello.jdbc.repositories.ProductoRepositoryImp;
import com.victortello.jdbc.repositories.Repository;
import com.victortello.jdbc.utils.ConexionDB;

public class EjemploJDBC {
    public static void main(String[] args) {

        // cerrado de forma automatica

        try (Connection connection = ConexionDB.getInstance();) {
            Repository<Producto> repository = new ProductoRepositoryImp();
            repository.listar().forEach(System.out::println);
            System.out.println("________________________");

            System.out.println(repository.porID(2L));
            Producto producto = new Producto();
            producto.setId(3L);
            producto.setCnombre_articulo("Teclado mecanico");
            producto.setFprecio((float) 50);
            producto.setDfecha_registro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId_categoria(2L);
            producto.setCategoria(categoria);
            repository.guardar(producto);

            System.out.println("________________________");
            repository.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    
}
