package SFRS.SF_Replay_Sport.service;

import org.springframework.stereotype.Service;

import SFRS.SF_Replay_Sport.models.Dtos.CategoriaRequest;
import SFRS.SF_Replay_Sport.models.entity.Categoria;
import SFRS.SF_Replay_Sport.repositories.CategoriaRepo;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class CategoriaService {
      private final CategoriaRepo categoriaRepo;

      public void addCategoria(CategoriaRequest categoriaRequest){
             Categoria categoria = Categoria.builder()
             .categoria_nombre(categoriaRequest.getCategoria_nombre())
            
             .build();

    categoriaRepo.save(categoria);

}
}
