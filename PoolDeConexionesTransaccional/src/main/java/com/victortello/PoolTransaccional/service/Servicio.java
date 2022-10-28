package com.victortello.PoolTransaccional.service;

import java.sql.SQLException;
import java.util.List;

import com.victortello.PoolTransaccional.models.Categoria;
import com.victortello.PoolTransaccional.models.Producto;

public interface Servicio {

    // las tablas deben estar relacionados para poder usar en el mismo servicio

    // Productos

    List<Producto> listarProductos() throws SQLException;

    Producto porIDProducto(Long id) throws SQLException;

    Producto guardarProducto(Producto producto) throws SQLException;

    void eliminarProducto(Long id) throws SQLException;

    // Categorias

    List<Categoria> listarCategorias() throws SQLException;

    Categoria porIdCategoria(Long id) throws SQLException;

    Categoria guardarCategoria(Categoria categoria) throws SQLException;

    void eliminarCategoria(Long id) throws SQLException;

    // productos y categorias

    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;

}
