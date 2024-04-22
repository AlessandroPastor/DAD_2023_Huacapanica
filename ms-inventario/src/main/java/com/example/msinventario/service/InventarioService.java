package com.example.msinventario.service;

import com.example.msinventario.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    List<Inventario> listar();
    Inventario guardar(Inventario inventario);
    Inventario actualizar(Inventario inventario);
    Optional<Inventario> listaPorld(Integer id);
    void eliminar(Integer id);
}
