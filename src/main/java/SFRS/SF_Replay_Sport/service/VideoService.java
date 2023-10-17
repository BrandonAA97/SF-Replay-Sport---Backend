package SFRS.SF_Replay_Sport.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import SFRS.SF_Replay_Sport.models.Dtos.VideoDto;
import SFRS.SF_Replay_Sport.models.Dtos.VideoRequest;
import SFRS.SF_Replay_Sport.models.entity.Video;
import SFRS.SF_Replay_Sport.repositories.VideoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoService {
    private final VideoRepo videoRepo;

    public void addVideo(VideoRequest videoRequest){
            Video video = Video.builder()
            .titulo(videoRequest.getTitulo())
            .url(videoRequest.getUrl())
            .categoria(videoRequest.getCategoria())
            .image(videoRequest.getImage())
            .subtitulo(videoRequest.getSubtitulo())
            .build();
        videoRepo.save(video);

        log.info("Video agregado capo:{}", video);
    }
    public List<VideoDto> getAllVideos(){
        List<Video> videos = videoRepo.findAll();
        return videos.stream().map(this::mapToVideoDto).toList();
    }

    public ResponseEntity <Video> findVideoById(Long id){
        Video video = videoRepo.findById(id).get();
        return ResponseEntity.ok(video);
   }

   public ResponseEntity<String> obtenerUrlVideo(@PathVariable Long id) {
    String videoUrl = "/videos/" + id; 
    return ResponseEntity.ok(videoUrl);
   }
    private VideoDto mapToVideoDto(Video video){
        return VideoDto.builder()
        .id(video.getId())
        .titulo(video.getTitulo())
        .subtitulo(video.getSubtitulo())
        .url(video.getUrl())
        .image(video.getImage())
        .categoria(video.getCategoria())
        .build();
    }
}
