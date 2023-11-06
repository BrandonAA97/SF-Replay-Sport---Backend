package SFRS.SF_Replay_Sport.auth.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SFRS.SF_Replay_Sport.auth.Repository.UserRepository;
import SFRS.SF_Replay_Sport.auth.Request.LoginRequest;
import SFRS.SF_Replay_Sport.auth.Request.RegisterRequest;
import SFRS.SF_Replay_Sport.auth.Response.AuthResponse;
import SFRS.SF_Replay_Sport.auth.User.Role;
import SFRS.SF_Replay_Sport.auth.User.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    // private final EmailService emailService;

    public AuthResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
         loginRequest.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String authorities = user.getAuthorities().toString();
        String username = user.getUsername();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .username(username)
            .authorities(authorities)
            .build();
    }

    public AuthResponse registerUser(RegisterRequest registerRequest){
        User user = User.builder()
            .username(registerRequest.getUsername())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .email(registerRequest.getEmail())
            .role(Role.USER)
            .build();
        userRepository.save(user);
      
        // emailService.sendEmailRegister(new Email(), registerRequest);
        // return AuthResponse.builder()
        //     .token(jwtService.getToken(user))
        //     .build();  
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
    public AuthResponse registerAdmin(RegisterRequest registerRequest){
        User user = User.builder()
            .username(registerRequest.getUsername())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .email(registerRequest.getEmail())
            .role(Role.ADMINISTRADOR)
            .build();
        userRepository.save(user);
        

        // emailService.sendEmailRegister(new Email(), registerRequest);

        // return AuthResponse.builder()
        //     .token(jwtService.getToken(user))
        //     .build();
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
        }
}