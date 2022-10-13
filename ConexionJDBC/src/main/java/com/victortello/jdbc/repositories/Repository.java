package com.victortello.jdbc.repositories;

import java.util.List;

public interface Repository <T>{
    List<T> listar();
    T porID(long id);
    void guardar(T t);
    void eliminar(Long id);

}
