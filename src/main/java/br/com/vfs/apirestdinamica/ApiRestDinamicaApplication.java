package br.com.vfs.apirestdinamica;

import br.com.vfs.apirestdinamica.entity.Model;
import br.com.vfs.apirestdinamica.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestDinamicaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestDinamicaApplication.class, args);
	}

	@Autowired
    private ModelRepository modelRepository;

    @Override
    public void run(String... args) throws Exception {
        Model model1 = new Model("car");
        Model model2 = new Model("house");
        modelRepository.save(model1);
        modelRepository.save(model2);
    }
}

