package br.com.vfs.apirestdinamica.service;

import br.com.vfs.apirestdinamica.config.ErrorMessage;
import br.com.vfs.apirestdinamica.dto.Field;
import br.com.vfs.apirestdinamica.entity.ElementModel;
import br.com.vfs.apirestdinamica.entity.Model;
import br.com.vfs.apirestdinamica.exception.ModelException;
import br.com.vfs.apirestdinamica.repository.ElementModelRepository;
import br.com.vfs.apirestdinamica.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl {

    private ModelRepository modelRepository;
    private ErrorMessage errorMessage;

    public Model isModelValid(String model) {
        return modelRepository.findById(model).orElseThrow(() -> new ModelException(errorMessage.getModelNotFound()));
    }


    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelByName(String name) {
        return isModelValid(name);
    }
}
