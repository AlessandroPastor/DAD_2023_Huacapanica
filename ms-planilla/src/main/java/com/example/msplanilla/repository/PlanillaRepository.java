package com.example.msplanilla.repository;

import com.example.msplanilla.entity.Planilla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanillaRepository extends JpaRepository<Planilla, Integer> {
}
