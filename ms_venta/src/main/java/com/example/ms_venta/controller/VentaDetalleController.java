package com.example.ms_venta.controller;


import com.example.ms_venta.entity.VentaDetallada;
import com.example.ms_venta.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventadetalle")
public class VentaDetalleController {
    @Autowired
        private VentaDetalleService ventaDetalleService;
    @GetMapping()
    public ResponseEntity<List<VentaDetallada>> list(){
        return ResponseEntity.ok().body(ventaDetalleService.listar());
    }
    @PostMapping()
    public ResponseEntity<VentaDetallada> save(@RequestBody VentaDetallada ventaDetallada){
        return ResponseEntity.ok(ventaDetalleService.guardar(ventaDetallada));
    }
    @PutMapping()
    public ResponseEntity<VentaDetallada> update(@RequestBody VentaDetallada ventaDetallada){
        return ResponseEntity.ok(ventaDetalleService.actualizar(ventaDetallada));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VentaDetallada> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(ventaDetalleService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){ ventaDetalleService.eliminarPorId(id);
        return "Eliminado Correctamente :3";
    }
}
