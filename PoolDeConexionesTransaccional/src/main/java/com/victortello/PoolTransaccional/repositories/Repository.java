package com.victortello.PoolTransaccional.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<T> listar() throws SQLException;
    T porID(long id) throws SQLException;
    T guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;

}
