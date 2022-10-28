package com.victortello.PoolTransaccional.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.victortello.PoolTransaccional.models.Categoria;
import com.victortello.PoolTransaccional.models.Producto;
import com.victortello.PoolTransaccional.repositories.CategoriaRepositoryImp;
import com.victortello.PoolTransaccional.repositories.ProductoRepositoryImp;
import com.victortello.PoolTransaccional.repositories.Repository;
import com.victortello.PoolTransaccional.utils.ConexionDB;

public class CatalogoServicio implements Servicio {

    private Repository<Producto> repositoryProducto;
    private Repository<Categoria> repositoryCategoria;

    public CatalogoServicio() {
        this.repositoryProducto = new ProductoRepositoryImp();
        this.repositoryCategoria = new CategoriaRepositoryImp();
    }

    // productos
    @Override
    public List<Producto> listarProductos() throws SQLException {

        try (Connection connection = ConexionDB.getConnection()) {
            repositoryProducto.setConnection(connection);
            return repositoryProducto.listar();
        }

    }

    @Override
    public Producto porIDProducto(Long id) throws SQLException {

        try (Connection connection = ConexionDB.getConnection()) {
            repositoryProducto.setConnection(connection);
            return repositoryProducto.porID(id);
        }

    }

    @Override
    public Producto guardarProducto(Producto producto) throws SQLException {
        try (Connection connection = ConexionDB.getConnection()) {

            Producto nuevoProducto = null;
            repositoryProducto.setConnection(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                nuevoProducto = repositoryProducto.guardar(producto);
                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();

            }
            return nuevoProducto;
        }

    }

    @Override
    public void eliminarProducto(Long id) throws SQLException {
        try (Connection connection = ConexionDB.getConnection()) {
            repositoryProducto.setConnection(connection);
            try {
                repositoryProducto.eliminar(id);
                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();

            }
        }

    }

    // categorias
    @Override
    public List<Categoria> listarCategorias() throws SQLException {

        try (Connection connection = ConexionDB.getConnection()) {
            repositoryCategoria.setConnection(connection);
            return repositoryCategoria.listar();
        }

    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {

        try (Connection connection = ConexionDB.getConnection()) {
            repositoryCategoria.setConnection(connection);
            return repositoryCategoria.porID(0);
        }

    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try (Connection connection = ConexionDB.getConnection()) {
            repositoryCategoria.setConnection(connection);

            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try {
                nuevaCategoria = repositoryCategoria.guardar(categoria);
                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();

            }
            return nuevaCategoria;
        }

    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {

        try (Connection connection = ConexionDB.getConnection()) {
            repositoryCategoria.setConnection(connection);
            try {
                repositoryCategoria.eliminar(id);
                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();

            }
        }

    }

    // productos y categorias
    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try (Connection connection = ConexionDB.getConnection()) {
            repositoryProducto.setConnection(connection);
            repositoryCategoria.setConnection(connection);
            try {

                Categoria nuevaCategoria = repositoryCategoria.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                repositoryProducto.guardar(producto);

                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();

            }
        }

    }

}
