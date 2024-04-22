package com.example.ms_venta.dto;

import lombok.Data;

@Data
public class ClientoDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String DNI;
    private String correo;
    private String telefono;
    private String producto;
}
