package SFRS.SF_Replay_Sport.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Builder
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nombre; //Nombre del usuario

    @Column(length = 60, nullable = false)
    private String apellido; //Apellido del usuario

    @Column(length = 60, nullable = false, unique = true)
    private String correo; //Correo del Usuario. Es Unico
    
   
    

}
