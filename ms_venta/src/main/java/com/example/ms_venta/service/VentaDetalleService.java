package com.example.ms_venta.service;

import com.example.ms_venta.entity.VentaDetallada;

import java.util.List;
import java.util.Optional;

public interface VentaDetalleService {

    public List<VentaDetallada> listar();
    public VentaDetallada guardar(VentaDetallada ventaDetallada);
    public VentaDetallada actualizar(VentaDetallada ventaDetallada);
    public Optional<VentaDetallada> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}
