package SFRS.SF_Replay_Sport.controllers.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class corseConfig implements WebMvcConfigurer{
    
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("https://localhost:4200")
        .allowedMethods("GET","POST","PUT","DELETE")
        .allowCredentials(true);
    }
}
