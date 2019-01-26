package br.com.vfs.apirestdinamica.repository;

import br.com.vfs.apirestdinamica.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepository extends MongoRepository<Model, String> {

}
