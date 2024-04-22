package com.example.ventadetalle.service.impl;

import com.example.ventadetalle.entity.VentaDetalle;
import com.example.ventadetalle.repository.VentaDetalleRepository;
import com.example.ventadetalle.service.VentaDetalleService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetalleServiceImpl implements VentaDetalleService {
    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;
    @Override
    public List<VentaDetalle> listar(){
        return ventaDetalleRepository.findAll();
    }
    @Override
    public VentaDetalle guardar(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }
    @Override
    public VentaDetalle actualizar(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }
    @Override
    public Optional<VentaDetalle> listarPorId(Integer id){
        return ventaDetalleRepository.findById(id);
    }
    @Override
    public void eliminarPorId(Integer id) {
        ventaDetalleRepository.deleteById(id);
    }
}
