package SFRS.SF_Replay_Sport.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init() throws IOException;

    String store(MultipartFile file) throws IOException;

    Resource loadAsResource(String filename) throws IOException;
}
