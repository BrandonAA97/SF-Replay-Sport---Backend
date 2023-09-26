package SFRS.SF_Replay_Sport.models.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
@Builder
public class Categoria {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 45, nullable = false)
    private String categoria_nombre; //Nombre de la categoria
    
    
    // @OneToMany(targetEntity = Video.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // private List<Video> videos;

    

}
