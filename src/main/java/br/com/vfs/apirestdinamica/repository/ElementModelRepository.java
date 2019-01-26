package br.com.vfs.apirestdinamica.repository;

import br.com.vfs.apirestdinamica.entity.ElementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ElementModelRepository extends MongoRepository<ElementModel, Long> {

    List<ElementModel> findAllByModel(String model);
}
