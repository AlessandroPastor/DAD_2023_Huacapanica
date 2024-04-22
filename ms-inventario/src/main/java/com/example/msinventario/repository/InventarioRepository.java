package com.example.msinventario.repository;

import com.example.msinventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>  {
}
