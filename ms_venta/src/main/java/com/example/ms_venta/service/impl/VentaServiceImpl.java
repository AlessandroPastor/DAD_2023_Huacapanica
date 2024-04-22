package com.example.ms_venta.service.impl;

import com.example.ms_venta.dto.ClientoDto;
import com.example.ms_venta.entity.Venta;
import com.example.ms_venta.entity.VentaDetallada;
import com.example.ms_venta.feign.ClienteFeign;
import com.example.ms_venta.feign.InventarioFeign;
import com.example.ms_venta.repository.VentaRepository;
import com.example.ms_venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private InventarioFeign inventarioFeign;

    @Override
    public List<Venta> listar(){
            return ventaRepository.findAll();
    }
    @Override
    public Venta guardar(Venta venta) {
        // Guardar el pedido en la base de datos
        return ventaRepository.save(venta);
    }
    @Override
    public Venta actualizar(Venta venta) {
        return ventaRepository.save(venta);
    }
    @Override
    public void eliminarPorId(Integer id) {
        ventaRepository.deleteById(id);
    }
    @Override
    public Optional<Venta> listarPorId(Integer id){
        Optional<Venta> venta= ventaRepository.findById(id);
        ClientoDto clientoDto = clienteFeign.listarPorld(venta.get().getClienteId()).getBody();
        /*for (PedidoDetalle pedidoDetalle : pedido.get().getDetalle()){
            pedidoDetalle.setProductoDto(productoFeign.buscarlistarPorld(pedidoDetalle.getProductoId()).getBody());
        }*/
        List<VentaDetallada> ventaDetalladas = venta.get().getDetalle().stream().map(ventaDetallada -> {
            ventaDetallada.setInventarioDto(inventarioFeign.listarPorld(ventaDetallada.getInventarioId()).getBody());
            return ventaDetallada;
        }).toList();
        /*--Captura Cliente-*/
        venta.get().setClientoDto(clientoDto);
        venta.get().setDetalle(ventaDetalladas);
        return ventaRepository.findById(id);
    }
}
