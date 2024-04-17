package com.example.ms_venta.controller;

import com.example.ms_venta.entity.Venta;
import com.example.ms_venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @GetMapping()
    public ResponseEntity<List<Venta>> list(){
        return ResponseEntity.ok().body(ventaService.listar());
    }
    @PostMapping()
    public ResponseEntity<Venta> save(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.guardar(venta));
    }
    @PutMapping()
    public ResponseEntity<Venta> update(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.actualizar(venta));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venta> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(ventaService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){ ventaService.eliminarPorId(id);
        return "Eliminado Correctamente :3";
    }
}
