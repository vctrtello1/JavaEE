package com.victortello.services;

import java.util.List;
import java.util.Optional;

import com.victortello.models.Producto;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> byId(Long id);
}
