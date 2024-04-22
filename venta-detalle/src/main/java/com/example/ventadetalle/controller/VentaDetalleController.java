package com.example.ventadetalle.controller;

import com.example.ventadetalle.entity.VentaDetalle;
import com.example.ventadetalle.service.VentaDetalleService;
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
    public ResponseEntity<List<VentaDetalle>> list(){
        return ResponseEntity.ok().body(ventaDetalleService.listar());
    }
    @PostMapping()
    public ResponseEntity<VentaDetalle> save(@RequestBody VentaDetalle ventaDetalle){
        return ResponseEntity.ok(ventaDetalleService.guardar(ventaDetalle));
    }
    @PutMapping()
    public ResponseEntity<VentaDetalle> update(@RequestBody VentaDetalle ventaDetalle){
        return ResponseEntity.ok(ventaDetalleService.actualizar(ventaDetalle));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(ventaDetalleService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<VentaDetalle>>eliminar(@PathVariable(required = true) Integer id){
        ventaDetalleService.eliminarPorId(id);
        return ResponseEntity.ok(ventaDetalleService.listar());
    }
}
