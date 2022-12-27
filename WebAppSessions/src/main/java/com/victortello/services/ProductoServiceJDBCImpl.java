package com.victortello.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.victortello.exceptions.ServiceJDBCException;
import com.victortello.models.Producto;
import com.victortello.repositories.ProductoRepositoryImpl;
import com.victortello.repositories.Repository;

import java.sql.Connection;

public class ProductoServiceJDBCImpl implements ProductoService {

    private Repository<Producto> repositoryJDBC;

    public ProductoServiceJDBCImpl(Connection connection) {
        this.repositoryJDBC = new ProductoRepositoryImpl(connection);
    }

    @Override
    public List<Producto> listar() {

        try {
            return repositoryJDBC.listar();
        } catch (SQLException e) {

            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public Optional<Producto> findById(Long id) {

        try {
            return Optional.ofNullable(repositoryJDBC.findById(id));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }

    }

}
