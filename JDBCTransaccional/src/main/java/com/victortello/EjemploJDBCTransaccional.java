package com.victortello;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.victortello.JDBCTransccional.models.Categoria;
import com.victortello.JDBCTransccional.models.Producto;
import com.victortello.JDBCTransccional.repositories.ProductoRepositoryImp;
import com.victortello.JDBCTransccional.repositories.Repository;
import com.victortello.JDBCTransccional.utils.ConexionDB;

public class EjemploJDBCTransaccional {
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

            // deberia botar por que ya existe el sku
            producto.setSku("1");
            repository.guardar(producto);

            System.out.println("________________________");
            repository.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
