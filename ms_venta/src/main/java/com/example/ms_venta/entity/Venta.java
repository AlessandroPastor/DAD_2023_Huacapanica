package com.example.ms_venta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
@Entity

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private Time hora;
    private String descripcion;
    private Integer clienteId;
    private Double cantidad;
    private BigDecimal unitario;
    private BigDecimal total;
    private String pago;
    private String estado;
    private Integer empleadoId;
    private String forma;
}
