package com.example.ventadetalle.service;

import com.example.ventadetalle.entity.VentaDetalle;

import java.util.List;
import java.util.Optional;

public interface VentaDetalleService {
    public List<VentaDetalle> listar();
    public VentaDetalle guardar(VentaDetalle ventaDetallea);
    public VentaDetalle actualizar(VentaDetalle ventaDetallea);
    public Optional<VentaDetalle> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}
