package SFRS.SF_Replay_Sport.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SFRS.SF_Replay_Sport.Security.entity.PrivilegiosUsuarios;
import SFRS.SF_Replay_Sport.Security.entity.Usuario;

//servicio para los privilegios del usuario admin
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return PrivilegiosUsuarios.build(usuario);
    }
}
