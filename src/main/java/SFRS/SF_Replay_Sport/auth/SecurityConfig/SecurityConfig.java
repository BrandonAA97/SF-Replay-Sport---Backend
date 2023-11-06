package SFRS.SF_Replay_Sport.auth.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import SFRS.SF_Replay_Sport.auth.Jwt.JwtAuthenticationFilter;
import SFRS.SF_Replay_Sport.auth.User.Role;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtAuthenticationFilter JwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
        
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest ->
                authRequest
                    .requestMatchers("/auth/**").permitAll()//todos los request con ruta /auth/ son publicos
                    .requestMatchers("/auth/admin/*").hasAuthority("ADMINISTRADOR")//rutas para los admins
                    .requestMatchers("/auth/user/*").hasAnyAuthority("USER", "ADMINISTRADOR")
                    .requestMatchers("/test/*").permitAll()//pruebas en postman
                    .anyRequest().authenticated())
            .sessionManagement(sessionManager ->
                sessionManager
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) 
            .build();
    }
}
