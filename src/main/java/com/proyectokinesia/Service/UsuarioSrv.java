package com.proyectokinesia.Service;


import com.proyectokinesia.Dao.RolDao;
import com.proyectokinesia.Dao.UsuarioDao;
import com.proyectokinesia.Entity.Rol;
import com.proyectokinesia.Entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioSrv implements UsuarioImpl {

    private final UsuarioDao dao;
    private final RolDao rolDao;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> find() {
        return dao.findAll();
    }

    @Override
    public  Usuario findById(Integer Id) {
        return dao.findById(Id);
    }

    @Override
    public Usuario save(Usuario usuario, Integer idRol) throws Exception {
        if(!dao.existsByUsuario(usuario.getUsuario())) {
            Optional<Rol> rol = rolDao.findById(idRol);
            List<Rol> rolSave = new ArrayList<>();
            rol.ifPresent(rolSave::add);
            usuario.setRoles(rolSave);
            return dao.save(usuario);
        }
        throw new Exception("El usuario ya existe");
    }


    public void update(Usuario usuario) {
        dao.save(usuario);
    }


    public Optional<Usuario> findByUsuario(String usuario) {
        return  dao.findByUsuario(usuario);
    }


    public Usuario estado(Integer Id) {
        Usuario usr = dao.findById(Id);
        usr.setEstado(!usr.getEstado());
        return dao.save(usr);
    }
}
