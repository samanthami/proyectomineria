package com.proyectokinesia.Service;

import com.proyectokinesia.Dao.RolDao;
import com.proyectokinesia.Entity.Rol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolSrv implements RolSrvImpl {

    private final RolDao rolDao;


    @Override
    public List<Rol> findAll() {
        return rolDao.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        return null;
    }

    @Override
    public Optional<Rol> findByRolName(String rol) {
        return rolDao.findByRolName(rol);
    }

    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }
}
