package com.victortello.PoolTransaccional;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.victortello.JDBCTransccional.utils.ConexionDB;
import com.victortello.PoolTransaccional.models.Categoria;
import com.victortello.PoolTransaccional.models.Producto;
import com.victortello.PoolTransaccional.repositories.ProductoRepositoryImp;
import com.victortello.PoolTransaccional.repositories.Repository;

public class PoolTransaccional {

    public static void main(String[] args) throws SQLException {

        // cerrado de forma automatica

        try (Connection connection = ConexionDB.getInstance();) {

            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {

                Repository<Producto> repository = new ProductoRepositoryImp();

                // insertar nuevo produco

                System.out.println("Nuevo producto");

                Producto productoNuevo = new Producto();
                productoNuevo.setCnombre_articulo("Marrucol");
                productoNuevo.setFprecio((float) 50);
                productoNuevo.setDfecha_registro(new Date());
                Categoria categoriaNueva = new Categoria();
                categoriaNueva.setId_categoria(2L);
                productoNuevo.setCategoria(categoriaNueva);
                productoNuevo.setSku("5");
                repository.guardar(productoNuevo);

                System.out.println("________________________");
                // listar productos
                repository.listar().forEach(System.out::println);

                // Actualizar producto

                System.out.println("Actualizar producto");

                Producto producto = new Producto();
                producto.setId(1L);
                producto.setCnombre_articulo("Caguama");
                producto.setFprecio((float) 150);
                producto.setDfecha_registro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId_categoria(2L);
                producto.setCategoria(categoria);
                producto.setSku("5");
                repository.guardar(producto);

                producto.setSku("1");
                repository.guardar(producto);

                System.out.println("________________________");
                // listar productos
                repository.listar().forEach(System.out::println);

                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                ex.printStackTrace();
            }

        }

    }

}
