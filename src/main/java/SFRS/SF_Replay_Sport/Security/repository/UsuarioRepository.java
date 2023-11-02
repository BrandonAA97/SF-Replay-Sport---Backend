package SFRS.SF_Replay_Sport.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SFRS.SF_Replay_Sport.models.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<SFRS.SF_Replay_Sport.Security.entity.Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    void save(SFRS.SF_Replay_Sport.Security.entity.Usuario usuario);

}