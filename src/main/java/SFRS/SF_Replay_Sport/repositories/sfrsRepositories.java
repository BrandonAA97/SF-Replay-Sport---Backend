package SFRS.SF_Replay_Sport.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import SFRS.SF_Replay_Sport.models.sfrsModels;

public interface sfrsRepositories extends JpaRepository<sfrsModels, Long>{

    
}