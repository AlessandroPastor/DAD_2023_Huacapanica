package com.example.ventadetalle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
@Entity
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String dniRUC;
    private String cliente;
    private String direccion;
    private FormaPago FormaPago;

    public enum FormaPago {
        CONTADO,
        CREDITO
    }

}
