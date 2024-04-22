package com.example.ms_venta.entity;

import com.example.ms_venta.dto.InventarioDto;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class VentaDetallada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer inventarioId;
    public VentaDetallada() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

    @Transient
    private InventarioDto inventarioDto;
}
