package com.example.mscliente.service.impl;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.repository.ClienteRepostiroy;
import com.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepostiroy clienteRepostiroy;
    @Override
    public List<Cliente> listar() {
        return clienteRepostiroy.findAll();
    }
    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepostiroy.save(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepostiroy.save(cliente);
    }

    @Override
    public Optional<Cliente> listaPorld(Integer id) {
        return clienteRepostiroy.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepostiroy.deleteById(id);
    }
}
