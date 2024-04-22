package com.example.mscliente.service;

import com.example.mscliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Cliente guardar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    Optional<Cliente> listaPorld(Integer id);
    void eliminar(Integer id);
}
