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
        return entrevistaSrv.findByNombreEntrevistador(cedula);
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
        Emocion emocion1 = new Emocion("Aceptación", 0);
        Emocion emocion2 = new Emocion("Nervioso", 0);
        Emocion emocion3 = new Emocion("Confundido", 0);
        Emocion emocion4 = new Emocion("Inseguro", 0);
        Emocion emocion5 = new Emocion("Verdad", 0);
        Emocion emocion6 = new Emocion("Mentira", 0);


        for (String dato : kinesia.getResultados()) {
            if (dato.equals("confianza")) {
                confianza++;
                emocion = new Emocion("Confianza", confianza);
            } else if (dato.equals("aceptación")) {
                aceptacion++;
                emocion1 = new Emocion("Aceptación", aceptacion);
            } else if (dato.equals("nervioso")) {
                nervioso++;
                emocion2 = new Emocion("Nervioso", nervioso);
            }  else if (dato.equals("inseguro")) {
                inseguro++;
                emocion4 = new Emocion("Inseguro", inseguro);
            } else if (dato.equals("verdad")) {
                verdad++;
                emocion5 = new Emocion("Verdad", verdad);
            } else if (dato.equals("mentira")) {
                mentira++;
                emocion6 = new Emocion("Mentira", mentira);
            }

        }

        List<Emocion> emociones7 = Arrays.asList(emocion, emocion1, emocion2, emocion3, emocion4, emocion5, emocion6);
        emociones7.sort(Comparator.comparing(Emocion::getCantidadc));

        List<Emocion> aux = new ArrayList<>();
        for (int i = 0; i < emociones7.size(); i++) {
            if (emociones7.get(i).getCantidadc() != 0) {
                Emocion aux1 = new Emocion(emociones7.get(i).getNombreC(), emociones7.get(i).getCantidadc());
                aux.add(aux1);
            }
        }
        System.out.println(aux);

        String labia = null;
        labia = "1. El usuario al momento de realizar la entrevista presentó las siguientes características\n";
        for (int i = 0; i < aux.size(); i++) {
            labia +=  aux.get(i).getNombreC()+ " con una frecuencia de: " + aux.get(i).getCantidadc() + "\n";
        }

        Entrevista en = entrevistaSrv.findById(id);
        en.setGestos(labia);
        entrevistaSrv.update(en);

    }

}
