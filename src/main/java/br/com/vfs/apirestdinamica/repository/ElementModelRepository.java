package br.com.vfs.apirestdinamica.repository;

import br.com.vfs.apirestdinamica.entity.ElementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ElementModelRepository extends MongoRepository<ElementModel, Long> {

    List<ElementModel> findAllByModel(String model);

    Optional<ElementModel> findByIdAndModel(Long id, String model);
}
