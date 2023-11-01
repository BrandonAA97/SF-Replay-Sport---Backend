package SFRS.SF_Replay_Sport.Security.repository;

import SFRS.SF_Replay_Sport.Security.entity.Rol;
import SFRS.SF_Replay_Sport.Security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}