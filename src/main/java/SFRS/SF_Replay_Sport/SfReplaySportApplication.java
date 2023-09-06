package SFRS.SF_Replay_Sport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SFRS.SF_Replay_Sport.models.entity.Categoria;
import SFRS.SF_Replay_Sport.repositories.CategoriaRepo;

@SpringBootApplication
public class SfReplaySportApplication{

	
	
			   public static void main(String[] args) {
		SpringApplication.run(SfReplaySportApplication.class, args);
		
		
	}

	@Bean
    public CommandLineRunner initData(CategoriaRepo categoriaRepo) {
        return args -> {
            // Crear registros iniciales aquí
            Categoria categoria1 = new Categoria(1L, "Futbol");
            categoriaRepo.save(categoria1);

			Categoria categoria2 = new Categoria(2L, "Basquet");
            categoriaRepo.save(categoria2);

			Categoria categoria3 = new Categoria(3L, "Voley");
            categoriaRepo.save(categoria3);



        };

}
}
