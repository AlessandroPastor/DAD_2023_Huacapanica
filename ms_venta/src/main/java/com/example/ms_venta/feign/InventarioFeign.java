package com.example.ms_venta.feign;


import com.example.ms_venta.dto.InventarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inventario-service", path = "/inventario")
public interface InventarioFeign {

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDto> listarPorld(@PathVariable(required = true) Integer id);
}
