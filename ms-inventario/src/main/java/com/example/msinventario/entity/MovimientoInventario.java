package com.example.msinventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fecha;
    private Date hora;
    private String Cliente;
    private String Proveedor;
    private Float manguera;
    private Float cantidad;
    private Double preciounitario;
    private Double ingreso_egreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Inventario inventario;

}
