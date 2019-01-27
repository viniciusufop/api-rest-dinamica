package br.com.vfs.apirestdinamica.service;

import br.com.vfs.apirestdinamica.config.ErrorMessage;
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
    private ErrorMessage errorMessage;
    public List<ElementModel> getAllElementsForModel(String name) {
        isModelValid(name);
        return elementModelRepository.findAllByModel(name);
    }

    public ElementModel getElementForModelByID(String name, Long id) {
        isModelValid(name);
        return elementModelRepository.findByIdAndModel(id, name).orElseThrow(() -> new ModelException((errorMessage.getElementNotFound())));
    }

    private void isModelValid(String model) {
        modelRepository.findById(model).orElseThrow(() -> new ModelException(errorMessage.getModelNotFound()));
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setElementModelRepository(ElementModelRepository elementModelRepository) {
        this.elementModelRepository = elementModelRepository;
    }
    @Autowired
    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
