package com.proyectokinesia.Dao;


import com.proyectokinesia.Entity.Persona;
import com.proyectokinesia.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaDAO extends JpaRepository<Persona, String> {
    List<Persona> findAll();

    Persona findByCedula(String cedula);

    Persona findByUsuario(Usuario us);

    boolean existsByCedula(String cedula);

    @Override
    <S extends Persona> S save(S entity);

    <S extends Persona> S findById(Integer id);


    @Query(value = "select p from Persona p, Rol  rol, Usuario u, Empresa e where rol.id =?1 and u.id = p.usuario.id and  p.empresa.id =?2 and p.empresa.id = e.id")
    List<Persona> finRolEmpresa(String rol, Integer id);

    @Query(value = "select p from Persona p , Usuario u where p.usuario.id =?1 and p.usuario.id = u.id")
    List<String> findRoles(Integer id);

}
