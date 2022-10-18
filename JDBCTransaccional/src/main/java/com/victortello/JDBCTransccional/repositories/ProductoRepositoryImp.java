package com.victortello.JDBCTransccional.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.victortello.JDBCTransccional.models.Categoria;
import com.victortello.JDBCTransccional.models.Producto;
import com.victortello.JDBCTransccional.utils.ConexionDB;

public class ProductoRepositoryImp implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();

    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select id_producto,cnombre_articulo,fprecio,dfecha_registro,sku,cnombre_categoria,id_categoria from productos p"
                                + " inner join categorias c on (p.icategoria = c.id_categoria);")) {
            while (resultSet.next()) {
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto porID(long id) {
        Producto producto = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "select id_producto,cnombre_articulo,fprecio,dfecha_registro,sku,cnombre_categoria,id_categoria from productos p"
                        + " inner join categorias c on (p.icategoria = c.id_categoria) where id_producto = ?;")) {
            preparedStatement.setLong(1, id);

            // try con recursos
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "update productos set cnombre_articulo= ?, fprecio = ?, dfecha_registro= ?,icategoria=?,sku=? where id_producto=?;";
        } else {
            sql = "insert into productos(cnombre_articulo,fprecio,dfecha_registro,icategoria,sku) values (?,?,?,?,?)";

        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

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

        } catch (Exception exception) {

            exception.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("delete from productos where id  = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
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
