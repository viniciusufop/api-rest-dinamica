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
    private ElementModelRepository elementModelRepository;
    private ErrorMessage errorMessage;
    public List<ElementModel> getAllElementsFromModel(String name) {
        isModelValid(name);
        return elementModelRepository.findAllByModel(name);
    }

    public ElementModel getElementFromModelByID(String name, Long id) {
        isModelValid(name);
        return getElement(name, id);
    }

    public void removeElementFromModelByID(String name, Long id) {
        isModelValid(name);
        elementModelRepository.delete(getElement(name, id));
    }

    private Model isModelValid(String model) {
        return modelRepository.findById(model).orElseThrow(() -> new ModelException(errorMessage.getModelNotFound()));
    }

    private ElementModel getElement(String name, Long id) {
        return elementModelRepository.findByIdAndModel(id, name).orElseThrow(() -> new ModelException((errorMessage.getElementNotFound())));
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

    public ElementModel createElementFromModelByID(String name, String structElement) {
        Model model = isModelValid(name);
        List<Field> fields = model.returnFields(structElement);

        Long id = 0l;
        Optional<ElementModel> elementModel = elementModelRepository.findTopByModelOrderByIdDesc(name);
        if(elementModel.isPresent()){
            id = elementModel.get().getId();
        }
        return elementModelRepository.save(new ElementModel(++id, name, fields));
    }
}
