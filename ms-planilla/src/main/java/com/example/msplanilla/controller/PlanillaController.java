package com.example.msplanilla.controller;

import com.example.msplanilla.entity.Planilla;
import com.example.msplanilla.service.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/planilla")
public class PlanillaController {
    @Autowired
    private PlanillaService planillaService;
    @GetMapping()
    public ResponseEntity<List<Planilla>> list(){
        return ResponseEntity.ok().body(planillaService.listar());
    }
    @PostMapping()
    public ResponseEntity<Planilla> save(@RequestBody Planilla planilla){
        return ResponseEntity.ok(planillaService.guardar(planilla));
    }
    @PutMapping()
    public ResponseEntity<Planilla> update(@RequestBody Planilla planilla){
        return ResponseEntity.ok(planillaService.actualizar(planilla));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Planilla> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(planillaService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Planilla>>eliminar(@PathVariable(required = true) Integer id){
        planillaService.eliminarPorId(id);
        return ResponseEntity.ok(planillaService.listar());
    }
}
