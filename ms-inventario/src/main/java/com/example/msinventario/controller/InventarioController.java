package com.example.msinventario.controller;

import com.example.msinventario.entity.Inventario;
import com.example.msinventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping()
    public ResponseEntity<List<Inventario>> listar(){
        return ResponseEntity.ok(inventarioService.listar());
    }

    @PostMapping
    public ResponseEntity<Inventario>guardar(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.guardar(inventario));
    }

    @PutMapping
    public ResponseEntity<Inventario>actualizar(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.actualizar(inventario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(inventarioService.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Inventario>>eliminar(@PathVariable(required = true) Integer id){
        inventarioService.eliminar(id);
        return ResponseEntity.ok(inventarioService.listar());
    }
}
