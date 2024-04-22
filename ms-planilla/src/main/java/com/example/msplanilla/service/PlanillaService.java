package com.example.msplanilla.service;

import com.example.msplanilla.entity.Planilla;

import java.util.List;
import java.util.Optional;

public interface PlanillaService {
    public List<Planilla> listar();
    public Planilla guardar(Planilla planilla);
    public Planilla actualizar(Planilla planilla);
    public Optional<Planilla> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}
