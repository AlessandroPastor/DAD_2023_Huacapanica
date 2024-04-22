package com.example.ms_venta.service.impl;

import com.example.ms_venta.entity.VentaDetallada;
import com.example.ms_venta.repository.VentaDetalleRepository;
import com.example.ms_venta.repository.VentaRepository;
import com.example.ms_venta.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
public class VentaDetalleServiceImpl implements VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;
    @Override
    public List<VentaDetallada> listar(){
        return ventaDetalleRepository.findAll();
    }
    @Override
    public VentaDetallada guardar(VentaDetallada pedidoDetalle) {
        return ventaDetalleRepository.save(pedidoDetalle);
    }
    @Override
    public VentaDetallada actualizar(VentaDetallada ventaDetallada) { return ventaDetalleRepository.save(ventaDetallada);}
    @Override
    public Optional<VentaDetallada> listarPorId(Integer id){
        return ventaDetalleRepository.findById(id);
    }
    @Override
    public void eliminarPorId(Integer id) {
        ventaDetalleRepository.deleteById(id);
    }
}
