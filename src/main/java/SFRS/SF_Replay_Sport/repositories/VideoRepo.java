package SFRS.SF_Replay_Sport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SFRS.SF_Replay_Sport.models.entity.Video;

public interface VideoRepo extends JpaRepository<Video,Long>{
    
}
