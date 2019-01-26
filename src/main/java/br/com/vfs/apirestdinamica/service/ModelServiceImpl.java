package br.com.vfs.apirestdinamica.service;

import br.com.vfs.apirestdinamica.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl {

    private ModelRepository modelRepository;

    public void getAllElementsForModel(String name) {
        modelRepository.findById(name).orElseThrow(() -> new RuntimeException());
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
