package com.proyectokinesia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emocion implements Serializable {

    private String nombreC;
    private Integer cantidadc;
    private BigDecimal porcentajeEmocion;

    public String getNombreC() {
        return nombreC;
    }


    public Integer getCantidadc() {
        return cantidadc;
    }

    public void setCantidadc(Integer cantidadc) {
        this.cantidadc = cantidadc;
    }

    public BigDecimal getPorcentajeEmocion() {
        return porcentajeEmocion;
    }

    public void setPorcentajeEmocion(BigDecimal porcentajeEmocion) {
        this.porcentajeEmocion = porcentajeEmocion;
    }
}
