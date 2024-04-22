package com.example.ms_venta.feign;


import com.example.ms_venta.dto.ClientoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-cliente", path = "/cliente")
public interface ClienteFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ClientoDto> listarPorld(@PathVariable(required = true) Integer id);
}
