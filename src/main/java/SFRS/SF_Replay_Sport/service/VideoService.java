package SFRS.SF_Replay_Sport.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
            .name(videoRequest.getName())
            .url(videoRequest.getUrl())
            .categoria_nombre(videoRequest.getCategoria_nombre())
            .build();
        videoRepo.save(video);

        log.info("Video agregado capo:{}", video);
    }
    public List<VideoDto> getAllVideos(){
        List<Video> videos = videoRepo.findAll();
        return videos.stream().map(this::mapToVideoDto).toList();
    }

    private VideoDto mapToVideoDto(Video video){
        return VideoDto.builder()
        .id(video.getId())
        .name(video.getName())
        .url(video.getUrl())
        .categoria_nombre(video.getCategoria_nombre())
        .build();
    }
}
