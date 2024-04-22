package com.example.mscliente.repository;

import com.example.mscliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepostiroy extends JpaRepository<Cliente, Integer> {
}
