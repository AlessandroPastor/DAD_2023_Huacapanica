package com.example.ms_venta.entity;

import com.example.ms_venta.dto.ClientoDto;
import com.example.ms_venta.dto.InventarioDto;
import jakarta.persistence.*;
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
    private String todo;

    @Transient
    private ClientoDto clientoDto;
    @Transient
    private InventarioDto inventarioDto;
}
