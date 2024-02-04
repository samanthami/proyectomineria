package com.proyectokinesia.Dao;

import com.proyectokinesia.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolDao  extends JpaRepository<Rol,String> {

    Optional<Rol> findByRolName(String s);
}
