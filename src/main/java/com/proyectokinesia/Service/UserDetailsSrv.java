package com.proyectokinesia.Service;

import com.proyectokinesia.Dao.UsuarioDao;
import com.proyectokinesia.Entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsSrv implements UserDetailsService {

    private final UsuarioDao userDao;

    public UserDetailsSrv(UsuarioDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = Optional.ofNullable(userDao.findByUsuario(username));

        if(!usuarioOptional.isPresent()){
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOptional.orElseThrow();

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority( role.getRolName())).collect(Collectors.toList());

        return  new org.springframework.security.core.userdetails.User(usuario.getUsuario(), new BCryptPasswordEncoder().encode(usuario.getContrasena()),usuario.getEstado(),true, true, true,  authorities);
    }
}
