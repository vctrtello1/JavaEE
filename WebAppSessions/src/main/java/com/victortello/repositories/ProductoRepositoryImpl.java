package com.victortello.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

import com.victortello.models.Categoria;
import com.victortello.models.Producto;

public class ProductoRepositoryImpl implements Repository<Producto> {
    private Connection connection;

    public ProductoRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select id_producto,cnombre_articulo,fprecio,dfecha_registro,sku,cnombre_categoria,id_categoria from productos p"
                                + " inner join categorias c on (p.icategoria = c.id_categoria);")) {
            while (resultSet.next()) {
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
            resultSet.close();
        }

        return productos;
    }

    @Override
    public Producto findById(Long id) throws SQLException {

        Producto producto = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select id_producto,cnombre_articulo,fprecio,dfecha_registro,sku,cnombre_categoria,id_categoria from productos p"
                        + " inner join categorias c on (p.icategoria = c.id_categoria) where id_producto = ?;")) {
            preparedStatement.setLong(1, id);

            // try con recursos
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }

            }
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {

        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "update productos set cnombre_articulo= ?, fprecio = ?, dfecha_registro= ?,icategoria=?,sku=? where id_producto=?;";
        } else {
            sql = "insert into productos(cnombre_articulo,fprecio,dfecha_registro,icategoria,sku) values (?,?,?,?,?)";

        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, producto.getCnombre_articulo());
            preparedStatement.setFloat(2, producto.getFprecio());
            preparedStatement.setDate(3, new Date(producto.getDfecha_registro().getTime()));
            preparedStatement.setLong(4, producto.getCategoria().getId_categoria());
            preparedStatement.setString(5, producto.getSku());

            if (producto.getId() != null && producto.getId() > 0) {
                preparedStatement.setLong(6, producto.getId());
            } else {
                // forma de obtener la fecha
                preparedStatement.setDate(3, new Date(producto.getDfecha_registro().getTime()));

            }

            preparedStatement.executeUpdate();

            if (producto.getId() == null) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        producto.setId(resultSet.getLong(1));
                    }

                }

            }

            return producto;

        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {

        try (PreparedStatement preparedStatement = connection
                .prepareStatement("delete from productos where id  = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();

        }

    }

    private Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("Id_producto"));
        producto.setCnombre_articulo(resultSet.getNString("cnombre_articulo"));
        producto.setFprecio(resultSet.getFloat("fprecio"));
        producto.setDfecha_registro(resultSet.getDate("dfecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId_categoria(resultSet.getLong("id_categoria"));
        categoria.setCnombre_categoria(resultSet.getString("cnombre_categoria"));
        producto.setCategoria(categoria);
        producto.setSku(resultSet.getString("sku"));
        return producto;
    }

}
