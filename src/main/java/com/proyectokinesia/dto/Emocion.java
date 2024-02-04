package com.proyectokinesia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emocion implements Serializable {

    private String nombreC;
    private Integer cantidadc;

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public Integer getCantidadc() {
        return cantidadc;
    }

    public void setCantidadc(Integer cantidadc) {
        this.cantidadc = cantidadc;
    }

}
