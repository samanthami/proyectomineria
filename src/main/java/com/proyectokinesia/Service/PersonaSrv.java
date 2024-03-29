package com.proyectokinesia.Service;


import com.proyectokinesia.Dao.EmpresaDao;
import com.proyectokinesia.Dao.PersonaDAO;
import com.proyectokinesia.Dao.RolDao;
import com.proyectokinesia.Dao.UsuarioDao;
import com.proyectokinesia.Entity.Empresa;
import com.proyectokinesia.Entity.Persona;
import com.proyectokinesia.Entity.Rol;
import com.proyectokinesia.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaSrv implements PersonaImpl {
    private final PersonaDAO personaDAO;
    private  final EmpresaDao empresaDao;
    private final UsuarioDao usuarioDao;
    private final RolDao rolDao;

    public PersonaSrv(PersonaDAO personaDAO, EmpresaDao empresaDao, UsuarioDao usuarioDao,
                      RolDao rolDao) {
        this.personaDAO = personaDAO;
        this.empresaDao = empresaDao;
        this.usuarioDao= usuarioDao;
        this.rolDao = rolDao;
    }

    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public Persona findCedula(String cedula) {
        return personaDAO.findByCedula(cedula);
    }

    @Override
    public Persona findById(Integer Id) {
        return personaDAO.findById(Id);
    }

    @Override
    public Persona findByUsuario(Usuario usuario) {
        return personaDAO.findByUsuario(usuario);
    }


    @Override
    public Persona saveP(Persona persona, Integer id, Integer idRol) {
        Usuario usr = persona.getUsuario();
        Optional<Rol> rol = rolDao.findById(idRol);
        if(rol.isPresent()) usr.setRoles(rol.stream().toList());
        usuarioDao.save(usr);
        Empresa em = empresaDao.findById(id);
        persona.setEmpresa(em);
        return personaDAO.save(persona);
    }

    @Override
    public Persona save(Persona persona) {
        return personaDAO.save(persona);
    }


    @Override
    public void update(Persona persona) {
        personaDAO.save(persona);
    }



    public List<Persona> finbyRolEmpresa(String rol, String em){
        Empresa emp = empresaDao.findByNombreempresa(em);
        Integer id = emp.getId();
        return personaDAO.finRolEmpresa(rol, id);
    }

    public Persona saveNamePer(Persona per, String em){
        Empresa emp = empresaDao.findByNombreempresa(em);
        per.setEmpresa(emp);
        Usuario ud = per.getUsuario();
        usuarioDao.save(ud);
        return personaDAO.save(per);
    }
}
