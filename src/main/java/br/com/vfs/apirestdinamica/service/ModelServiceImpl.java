package br.com.vfs.apirestdinamica.service;

import br.com.vfs.apirestdinamica.entity.ElementModel;
import br.com.vfs.apirestdinamica.exception.ModelException;
import br.com.vfs.apirestdinamica.repository.ElementModelRepository;
import br.com.vfs.apirestdinamica.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl {

    private ModelRepository modelRepository;
    private ElementModelRepository elementModelRepository;

    public List<ElementModel> getAllElementsForModel(String name) {
        modelRepository.findById(name).orElseThrow(() -> new ModelException());
        return elementModelRepository.findAllByModel(name);
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setElementModelRepository(ElementModelRepository elementModelRepository) {
        this.elementModelRepository = elementModelRepository;
    }
}
