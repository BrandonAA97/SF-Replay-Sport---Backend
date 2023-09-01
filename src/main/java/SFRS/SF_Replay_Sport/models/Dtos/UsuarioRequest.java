package SFRS.SF_Replay_Sport.models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {
    
    private String nombre;
    private String apellido;
    private String correo;
}
