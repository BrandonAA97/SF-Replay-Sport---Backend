package SFRS.SF_Replay_Sport.models.Dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoDto {
    
    private Long id;
    private String name;
    private String nombre_categoria;
    private String url;
}
