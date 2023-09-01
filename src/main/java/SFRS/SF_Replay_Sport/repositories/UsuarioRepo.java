package SFRS.SF_Replay_Sport.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import SFRS.SF_Replay_Sport.models.entity.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

    
}
