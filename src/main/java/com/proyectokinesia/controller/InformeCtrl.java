package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Entrevista;
import com.proyectokinesia.Service.EntrevistaSrv;
import com.proyectokinesia.Service.InformeSrv;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class InformeCtrl {

    private final InformeSrv informeSrv;
    private final EntrevistaSrv entrevistaSrv;

    public InformeCtrl(InformeSrv informeSrv, EntrevistaSrv entrevistaSrv) {
        this.informeSrv = informeSrv;
        this.entrevistaSrv = entrevistaSrv;
    }

    @GetMapping(value = "/informe/print/{id}")
    public void getInforme(@PathVariable Integer id, HttpServletResponse response) throws JRException, IOException {
        var jp = entrevistaSrv.printInforme(id);
        Entrevista en = entrevistaSrv.findById(id);
        String nm = ("Entrevista")+"_" + en.personaIdpersona.getNombre() + en.getPersonaIdpersona().getApellido() ;
        informeSrv.writePdfReport(jp, response, nm);

    }
}
