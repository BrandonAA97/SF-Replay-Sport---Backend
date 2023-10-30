package SFRS.SF_Replay_Sport.service;
 
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageService implements StorageService{

   //destino de videos e imagenes
    private String videosLocation = "C:\\Users\\lucas\\OneDrive\\Desktop\\programacion\\SF-ReplaySport-con-spingboot\\videos";
    private String imgsLocation = "C:\\Users\\lucas\\OneDrive\\Desktop\\programacion\\SF-ReplaySport-con-spingboot\\imagenes";
    //variable para los destinos en el if
    private String Location="";
    
    @Override
    public void init() throws IOException {
        throw new UnsupportedOperationException("");
    }
 
    @Override
    public String store(MultipartFile file) throws IOException{
        if (file.getContentType().equals("video/mp4")) {
            Location=videosLocation;
            System.out.println("El archivo es un MP4");
        
        } else if (file.getContentType().startsWith("image/")) {
            Location=imgsLocation;
            System.out.println("El archivo es una imagen");
        
        } else {
            
            System.out.println("El archivo no es un MP4 ni una imagen");
        }

        Path path = Paths.get(Location, file.getOriginalFilename());
        Files.copy(file.getInputStream(), path);
 
        return path.toString();
    }

    @Override
    public Resource loadAsResource(String filename) throws IOException{
        
     Path path = Paths.get(Location, filename);
     Resource resource = new UrlResource(path.toUri());

    if(resource.exists() && resource.isReadable()){
        return resource;
    }else{
        throw new RuntimeException("failed to load file");
    }

}

    
}
