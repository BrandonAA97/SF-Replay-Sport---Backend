// package SFRS.SF_Replay_Sport.configs;

// import lombok.Builder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfiguration  implements WebMvcConfigurer{
//     @Override
//     // protected void configure(HttpSecurity http) throws Exception{
       
//     // }
//     @Bean
//     public PasswordEncoder passwordEncoder(){ 
//         return new BCryptPasswordEncoder();
//     }
//     @Override 
//     public void addCorsMappings(CorsRegistry registry){
//         registry.addMapping("/**")
//                 .allowedOrigins("http://localhost:4200")
//                 .allowedMethods("\"GET\", \"POST\", \"PUT\", \"DELETE\"");
//     }
// }
