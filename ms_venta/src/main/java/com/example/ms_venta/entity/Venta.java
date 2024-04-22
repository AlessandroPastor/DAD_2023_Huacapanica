package com.example.ms_venta.entity;

import com.example.ms_venta.dto.ClientoDto;
import com.example.ms_venta.dto.InventarioDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List <VentaDetallada> detalle;
    @Transient
    private ClientoDto clientoDto;

}
