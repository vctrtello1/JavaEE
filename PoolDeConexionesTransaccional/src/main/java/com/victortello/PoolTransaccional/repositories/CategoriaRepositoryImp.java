package com.victortello.PoolTransaccional.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.victortello.PoolTransaccional.models.Categoria;

public class CategoriaRepositoryImp implements Repository<Categoria> {

    private Connection connection;

    public CategoriaRepositoryImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Categoria> listar() throws SQLException {

        List<Categoria> categorias = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select id_categoria, cnombre_categoria from categorias");

            while (resultSet.next()) {
                Categoria categoria = crearCategoria(resultSet);
                categorias.add(categoria);

            }

        }

        return categorias;
    }

    @Override
    public Categoria porID(long id) throws SQLException {

        Categoria categoria = null;

        try (PreparedStatement preparableStatement = connection.prepareStatement(
                "select id_categoria, cnombre_categoria "
                        + " from categorias where id_categoria = ?")) {
            preparableStatement.setLong(1, id);
            try (ResultSet resultSet = preparableStatement.executeQuery()) {
                if (resultSet.next()) {
                    categoria = crearCategoria(resultSet);
                }
            }

        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {

        String sql;

        if (categoria.getId_categoria() != null && categoria.getId_categoria() > 0) {
            sql = "update categorias set cnombre_categoria = ? where id_categoria = ?";
        } else {

            sql = "insert into categorias(cnombre_categoria) values (?)";
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, categoria.getCnombre_categoria());
            if (categoria.getId_categoria() != null && categoria.getId_categoria() > 0) {
                preparedStatement.setLong(2, categoria.getId_categoria());

            }

            preparedStatement.executeUpdate();

            if (categoria.getId_categoria() == null) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        categoria.setId_categoria(resultSet.getLong(1));

                    }

                }
            }

        }

        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Categoria crearCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId_categoria(resultSet.getLong("id_categoria"));
        categoria.setCnombre_categoria(resultSet.getString(resultSet.getString("cnombre_categoria")));
        return categoria;
    }

}
