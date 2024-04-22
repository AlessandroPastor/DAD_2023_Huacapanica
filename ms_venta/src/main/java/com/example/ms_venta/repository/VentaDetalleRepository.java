package com.example.ms_venta.repository;

import com.example.ms_venta.entity.Venta;
import com.example.ms_venta.entity.VentaDetallada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDetalleRepository extends JpaRepository <VentaDetallada, Integer> {
}
