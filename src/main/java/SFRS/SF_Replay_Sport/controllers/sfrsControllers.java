package SFRS.SF_Replay_Sport.controllers;


import java.util.List;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import SFRS.SF_Replay_Sport.models.Dtos.VideoDto;
import SFRS.SF_Replay_Sport.models.Dtos.VideoRequest;
import SFRS.SF_Replay_Sport.models.entity.Video;

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
    
    @GetMapping("/find/videos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Video findVideoById(@PathVariable Long id){
         return this.videoService.findVideoById(id).getBody();
    } 

    @GetMapping("/find/imagenes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Video findImagenById(@PathVariable Long id){
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
}

