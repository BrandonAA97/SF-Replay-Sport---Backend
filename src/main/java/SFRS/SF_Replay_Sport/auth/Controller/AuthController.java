package SFRS.SF_Replay_Sport.auth.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SFRS.SF_Replay_Sport.auth.Request.LoginRequest;
import SFRS.SF_Replay_Sport.auth.Request.RegisterRequest;
import SFRS.SF_Replay_Sport.auth.Response.AuthResponse;
import SFRS.SF_Replay_Sport.auth.Service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    //Endpoint para iniciar sesion
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    //Endpoint para registrarse como user
    @PostMapping(value = "registerUser")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.registerUser(registerRequest));
    }

    //Endpoint para registrarse como admin 
    @PostMapping(value = "registerAdmin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.registerAdmin(registerRequest));
    }
}