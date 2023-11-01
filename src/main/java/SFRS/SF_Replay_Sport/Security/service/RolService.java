package SFRS.SF_Replay_Sport.Security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SFRS.SF_Replay_Sport.Security.entity.Rol;
import SFRS.SF_Replay_Sport.Security.enums.RolNombre;
import SFRS.SF_Replay_Sport.Security.repository.RolRepository;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
