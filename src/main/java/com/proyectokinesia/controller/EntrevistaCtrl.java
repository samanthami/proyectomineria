package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Entrevista;
import com.proyectokinesia.Exception.CustomException;
import com.proyectokinesia.Service.EntrevistaSrv;
import com.proyectokinesia.dto.Emocion;
import com.proyectokinesia.dto.Kinesia;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Log
@RestController
public class EntrevistaCtrl {

    private final EntrevistaSrv entrevistaSrv;

    public EntrevistaCtrl(EntrevistaSrv entrevistaSrv) {
        this.entrevistaSrv = entrevistaSrv;
    }

    @GetMapping(value = "/entrevista")
    public List<Entrevista> findAll() {
        return entrevistaSrv.findAll();
    }

    @PostMapping(value = "/entrevistain")
    public Entrevista entrevistain(@RequestBody Entrevista entrevista) {
        return entrevistaSrv.save(entrevista);
    }

    @GetMapping(value = "/entrevistaLi/{cedula}")
    public List<Entrevista> findEntrevistador(@PathVariable("cedula") String cedula) {
        return entrevistaSrv.findByCedulaEntrevistador(cedula);
    }

    @GetMapping(value = "/entrevistaI/{id}")
    public Entrevista findEntrevista(@PathVariable("id") Integer id) {
        return entrevistaSrv.findById(id);
    }


    @GetMapping(value = "/entrevistaEm/{nombre}")
    public List<Entrevista> findAllEntreEm(@PathVariable("nombre") String nombre) {
        return entrevistaSrv.findAll(nombre);

    }

    @PostMapping(value = "/entrevistaPst")
    public Entrevista saveEntrevista(@RequestParam String cedula, @RequestBody Entrevista entrevista) throws CustomException {
        return entrevistaSrv.saveByCedula(entrevista, cedula);
    }

    @PutMapping(value = "/entrevistaGestos/{id}")
    public void traeTodos(@RequestBody Kinesia kinesia, @PathVariable("id") Integer id) {
        int confianza = 0;
        int aceptacion = 0;
        int nervioso = 0;
        int inseguro = 0;
        int mentira = 0;
        int verdad = 0;

        Emocion emocion = null;
        Emocion emocion1 = Emocion.builder().nombreC("Aceptación").cantidadc(0).build();
        Emocion emocion2 = Emocion.builder().nombreC("Nervioso").cantidadc(0).build();
        Emocion emocion3 =Emocion.builder().nombreC("Confundido").cantidadc(0).build();
        Emocion emocion4 = Emocion.builder().nombreC("Inseguro").cantidadc(0).build();
        Emocion emocion5 = Emocion.builder().nombreC("Verdad").cantidadc(0).build();
        Emocion emocion6 = Emocion.builder().nombreC("Mentira").cantidadc(0).build();


        for (String dato : kinesia.getResultados()) {
            if (dato.equals("confianza")) {
                confianza++;
                emocion = Emocion.builder().nombreC("Confianza").cantidadc(confianza).build();
            } else if (dato.equals("aceptacion")) {
                aceptacion++;
                emocion1 = Emocion.builder().nombreC("Aceptación").cantidadc(aceptacion).build();
            } else if (dato.equals("nervioso")) {
                nervioso++;
                emocion2 = Emocion.builder().nombreC("Nervioso").cantidadc(nervioso).build();
            }  else if (dato.equals("inseguro")) {
                inseguro++;
                emocion4 = Emocion.builder().nombreC("Inseguro").cantidadc(inseguro).build();
            } else if (dato.equals("verdad")) {
                verdad++;
                emocion5 = Emocion.builder().nombreC("Verdad").cantidadc(verdad).build();
            } 

        }


        List<Emocion> emociones7 = Arrays.asList(emocion, emocion1, emocion2, emocion3, emocion4, emocion5, emocion6);
        emociones7.forEach(emocionDefined -> {
            BigDecimal porcentaje = BigDecimal.valueOf(emocionDefined.getCantidadc()).divide(BigDecimal.valueOf(kinesia.getResultados().size()),2, RoundingMode.DOWN).multiply(new BigDecimal(100));
            emocionDefined.setPorcentajeEmocion(porcentaje);
        });
        emociones7.sort(Comparator.comparing(Emocion::getCantidadc).reversed());

        List<Emocion> aux = new ArrayList<>();
        for (Emocion value : emociones7) {
            if (value.getCantidadc() != 0) {
                Emocion aux1 = Emocion.builder().nombreC(value.getNombreC()).porcentajeEmocion(value.getPorcentajeEmocion()).build();
                aux.add(aux1);
            }
        }
        System.out.println(aux);

        String labia ;
        labia = "1. El usuario al momento de realizar la entrevista presentó las siguientes características\n";
        for (Emocion value : aux) {
            labia += value.getNombreC() + " con una frecuencia de: " + value.getPorcentajeEmocion() + "%" + "\n";
        }

        Entrevista en = entrevistaSrv.findById(id);
        en.setGestos(labia);
        entrevistaSrv.update(en);

    }

}
