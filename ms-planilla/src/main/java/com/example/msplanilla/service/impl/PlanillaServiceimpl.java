package com.example.msplanilla.service.impl;

import com.example.msplanilla.entity.Planilla;
import com.example.msplanilla.repository.PlanillaRepository;
import com.example.msplanilla.service.PlanillaService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanillaServiceimpl implements PlanillaService {
    @Autowired
    private PlanillaRepository planillaRepository;
    @Override
    public List<Planilla> listar(){
        return planillaRepository.findAll();
    }
    @Override
    public Planilla guardar(Planilla planilla) {
        return planillaRepository.save(planilla);
    }
    @Override
    public Planilla actualizar(Planilla planilla) {
        return planillaRepository.save(planilla);
    }
    @Override
    public Optional<Planilla> listarPorId(Integer id){
        return planillaRepository.findById(id);
    }
    @Override
    public void eliminarPorId(Integer id) {
        planillaRepository.deleteById(id);
    }
}
