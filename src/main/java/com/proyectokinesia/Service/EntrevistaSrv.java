package com.proyectokinesia.Service;

import com.proyectokinesia.Dao.EntrevistaDao;
import com.proyectokinesia.Entity.Entrevista;
import com.proyectokinesia.Entity.Persona;
import lombok.extern.java.Log;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@Service
public class EntrevistaSrv  implements EntrevistaImpl {

    private final EntrevistaDao dao;
    private final InformeSrv informeSrv;
    private final PersonaSrv personaSrv;

    public EntrevistaSrv(EntrevistaDao dao, InformeSrv informeSrv, PersonaSrv personaSrv) {
        this.dao = dao;
        this.informeSrv= informeSrv;
        this.personaSrv = personaSrv;
    }

    @Override
    public List<Entrevista> findAll() {
        return dao.findAll();
    }

    @Override
    public Entrevista findById(Integer id) {
          return dao.findById(id).orElseGet(Entrevista::new);
    }

    @Override
    public Entrevista save(Entrevista entrevista) {
        return dao.save(entrevista);
    }

    @Override
    public void update(Entrevista entrevista) {
        dao.save(entrevista);
    }

    @Override
    public List<Entrevista> findByNombreEntrevistador(String cedula) {
        return dao.findByCedulaEntrevistador(cedula);
    }

    @Override
    public List<Entrevista> findByFecha(Date fecha) {
        return Collections.emptyList();
    }


    public JasperPrint printInforme(Integer id){
        String path = "emociones/informe.jasper";
        Map<String, Object> params = new HashMap<>();
        params.put("id", Integer.parseInt(id.toString()));
        try {
            return informeSrv.init(path,params);
        }catch (Exception ex){
            log.info("Error al generar el informe" + ex);
        }
        return null;
    }
    public List<Entrevista> findAll(String nombre){
        return dao.allentrevista(nombre);
    }

    public Entrevista saveByCedula(Entrevista entrevista, String cedula){
        Persona pe = personaSrv.findCedula(cedula);
        entrevista.setPersonaIdpersona(pe);
        return dao.save(entrevista);
    }
}
