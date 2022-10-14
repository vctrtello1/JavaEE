package com.victorTello.Pool;

import java.util.Date;

import com.victorTello.Pool.models.Categoria;
import com.victorTello.Pool.models.Producto;
import com.victorTello.Pool.repositories.ProductoRepositoryImp;
import com.victorTello.Pool.repositories.Repository;

public class PoolDeConexiones {

    public static void main(String[] args) {

        // cerrado de forma automatica

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

    }
}
