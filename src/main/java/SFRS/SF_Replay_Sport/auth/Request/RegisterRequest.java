package SFRS.SF_Replay_Sport.auth.Request;

import SFRS.SF_Replay_Sport.auth.User.Role;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    String username;
    String password;
    String email;
    List<Role> role;
}
