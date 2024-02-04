package com.proyectokinesia.Service;

import com.proyectokinesia.Entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolSrvImpl {

    List<Rol> findAll();
    Rol findById(Integer id);
    Optional<Rol> findByRolName(String rol);
}
