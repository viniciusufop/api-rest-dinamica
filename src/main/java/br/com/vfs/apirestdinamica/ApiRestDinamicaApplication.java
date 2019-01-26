package br.com.vfs.apirestdinamica;

import br.com.vfs.apirestdinamica.dto.Field;
import br.com.vfs.apirestdinamica.dto.FieldType;
import br.com.vfs.apirestdinamica.entity.ElementModel;
import br.com.vfs.apirestdinamica.entity.Model;
import br.com.vfs.apirestdinamica.repository.ElementModelRepository;
import br.com.vfs.apirestdinamica.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiRestDinamicaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestDinamicaApplication.class, args);
	}

	@Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ElementModelRepository elementModelRepository;

    @Override
    public void run(String... args) throws Exception {
        criandoModeloCar();
        criandoModeloHouse();
    }

    private void criandoModeloCar() {
        Model model = new Model("car", //
                Arrays.asList( //
                        new Field("cor", FieldType.STRING), //
                        new Field("velocidade maxima", FieldType.NUMERIC), //
                        new Field("off-round", FieldType.BOOLEAN)));
        modelRepository.save(model);

        ElementModel duster = new ElementModel(1l,"car", //
                Arrays.asList( //
                        new Field("cor", "cinza", FieldType.STRING), //
                        new Field("velocidade maxima", "200", FieldType.NUMERIC), //
                        new Field("off-round", "true", FieldType.BOOLEAN)));
        elementModelRepository.save(duster);
        ElementModel bravo = new ElementModel(2l,"car", //
                Arrays.asList( //
                        new Field("cor", "branco", FieldType.STRING), //
                        new Field("velocidade maxima", "250", FieldType.NUMERIC), //
                        new Field("off-round", "false", FieldType.BOOLEAN)));
        elementModelRepository.save(bravo);
    }

    private void criandoModeloHouse() {
        Model model = new Model("house", //
                Arrays.asList( //
                        new Field("cor", FieldType.STRING), //
                        new Field("quantidade quartos", FieldType.NUMERIC), //
                        new Field("possui piscina", FieldType.NUMERIC)));
        modelRepository.save(model);

        ElementModel casaPraia = new ElementModel(3l,"house", //
                Arrays.asList( //
                        new Field("cor", "amarela", FieldType.STRING), //
                        new Field("quantidade quartos", "2", FieldType.NUMERIC), //
                        new Field("possui piscina", "true", FieldType.NUMERIC)));
        elementModelRepository.save(casaPraia);
        ElementModel casaUberlandia = new ElementModel(4l,"house", //
                Arrays.asList( //
                        new Field("cor", "branca", FieldType.STRING), //
                        new Field("quantidade quartos", "3", FieldType.NUMERIC), //
                        new Field("possui piscina", "false", FieldType.NUMERIC)));
        elementModelRepository.save(casaUberlandia);
    }
}

