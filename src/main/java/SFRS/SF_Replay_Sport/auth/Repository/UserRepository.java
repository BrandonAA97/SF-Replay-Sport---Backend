package SFRS.SF_Replay_Sport.auth.Repository;

import SFRS.SF_Replay_Sport.auth.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

   
}
