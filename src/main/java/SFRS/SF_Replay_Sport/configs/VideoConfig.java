package SFRS.SF_Replay_Sport.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class VideoConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //nombre de la carpeta donde van a estar los videos
        registry.addResourceHandler("/videos/**")
        //Direccion absoluta de donde se van a guardar los videos
                .addResourceLocations("file:///C:/Users/lucas/OneDrive/Desktop/programacion/SF-ReplaySport-con-spingboot/videos/");
                //.addResourceLocations("file:///C:/Users/Albornoz.DESKTOP-TE9QN2H/OneDrive/Desktop/Facu/TUP-2-año/proyecto-final-Full-Stack/videos/");
    }
     
}
