package com.proyectokinesia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kinesia implements Serializable {

    private List<String> resultados;

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }
}