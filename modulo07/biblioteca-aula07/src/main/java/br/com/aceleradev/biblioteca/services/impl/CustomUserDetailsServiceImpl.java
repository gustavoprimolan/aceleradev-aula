package br.com.aceleradev.biblioteca.services.impl;

import br.com.aceleradev.biblioteca.models.Usuario;
import br.com.aceleradev.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));

        List<GrantedAuthority> adminRoles =
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");

        List<GrantedAuthority> userRoles =
                AuthorityUtils.createAuthorityList("ROLE_USER");

        List<GrantedAuthority> roles = usuario.isAdmin() ? adminRoles : userRoles;

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
