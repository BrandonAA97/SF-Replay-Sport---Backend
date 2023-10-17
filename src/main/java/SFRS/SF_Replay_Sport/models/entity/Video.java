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
@Table(name = "videos")
@Builder
public class Video{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 255, nullable = false, unique = true)
    private String titulo;
    
    @Column(length = 255, nullable = false)
    private String subtitulo;

    @Column(length = 255, nullable = true)
    private String image;
    
    @Column(length = 45, nullable = false)
    private String categoria;//nombre de la categoria que pertenece
    
    @Column(length = 255)
    private String url;
}