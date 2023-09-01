package SFRS.SF_Replay_Sport.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SFRS.SF_Replay_Sport.models.Dtos.UsuarioDto;
import SFRS.SF_Replay_Sport.models.Dtos.UsuarioRequest;
import SFRS.SF_Replay_Sport.models.entity.Usuario;
import SFRS.SF_Replay_Sport.repositories.UsuarioRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioService {
    private final UsuarioRepo usuarioRepo; 

    public void addUsuario(UsuarioRequest usuarioRequest){
             Usuario usuario = Usuario.builder()
             .nombre(usuarioRequest.getNombre())
             .apellido(usuarioRequest.getApellido())
             .correo(usuarioRequest.getCorreo())
             .build();

    usuarioRepo.save(usuario);

}

    public List<UsuarioDto> getAllUser(){
         List<Usuario> usuarios = usuarioRepo.findAll();
         return usuarios.stream().map(this::mapToUsuarioDto).toList();
    }

    private UsuarioDto mapToUsuarioDto(Usuario usuario){
        return UsuarioDto.builder()
        .id(usuario.getId())
        .nombre(usuario.getNombre())
        .apellido(usuario.getApellido())
        .correo(usuario.getCorreo())
        .build();
    }


   public ResponseEntity <Usuario> findUserById(Long id){
        Usuario usuario = usuarioRepo.findById(id).get();
        return ResponseEntity.ok(usuario);
   }
    public void deleteByUserId(Long id){
         Usuario usuario = usuarioRepo.findById(id).get();
         usuarioRepo.delete(usuario);
    }
}
