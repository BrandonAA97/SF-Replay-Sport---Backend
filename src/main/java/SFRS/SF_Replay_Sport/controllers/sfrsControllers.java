package SFRS.SF_Replay_Sport.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.format.InputAccessor;

import SFRS.SF_Replay_Sport.models.Dtos.UsuarioDto;
import SFRS.SF_Replay_Sport.models.Dtos.UsuarioRequest;
import SFRS.SF_Replay_Sport.models.Dtos.VideoDto;
import SFRS.SF_Replay_Sport.models.Dtos.VideoRequest;
import SFRS.SF_Replay_Sport.models.entity.Usuario;
import SFRS.SF_Replay_Sport.models.entity.Video;
import SFRS.SF_Replay_Sport.service.UsuarioService;
import SFRS.SF_Replay_Sport.service.VideoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // para poder manejar solicitudes HTTP 
@RequestMapping("/api/v1")
@CrossOrigin (origins = "http://localhost:4200")
public class sfrsControllers {


    
    private final VideoService videoService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVideo(@RequestBody VideoRequest videoRequest){
        this.videoService.addVideo(videoRequest);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<VideoDto> getAllVideos(){
        return this.videoService.getAllVideos();
    }

    private final UsuarioService usuarioService;
    @PostMapping("/addUs")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUsuario(@RequestBody UsuarioRequest usuarioRequest){
        this.usuarioService.addUsuario(usuarioRequest);
    }
    @GetMapping("/allUs")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> getAllUsuarios(){
        return this.usuarioService.getAllUser();
    }
    @GetMapping("/find/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario findByUserId(@PathVariable Long id){
          return this.usuarioService.findUserById(id).getBody();
    }

    
    @DeleteMapping("/delete/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        this.usuarioService.deleteByUserId(id);
    }
    
    @GetMapping("/find/videos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Video findVideoById(@PathVariable Long id){
         return this.videoService.findVideoById(id).getBody();
} 
//     @GetMapping("/find/videosUrl/{id}")
//     @ResponseStatus(HttpStatus.OK)
//     public String findUrlById(@PathVariable Long id){
//         Video video = this.videoService.findVideoById(id).getBody();
//         String url = "https://localhost:8080/" + video.getUrl();
//         return url;
// } 

    // @GetMapping("/videos/{nombreDelVideo}")
    // public void getVideo(@PathVariable String nombreDelVideo, HttpServletResponse response)throws IOException{
    //      File videoFile = new File("file:///Users/lucas/OneDrive/Desktop/programacion/SF-ReplaySport-con-spingboot/videos/" + nombreDelVideo);

    //      InputStream is = new FileInputStream(videoFile);
    //      IOUtils.copy(is, response.getOutputStream());
    //      response.flushBuffer();
    // }
}

