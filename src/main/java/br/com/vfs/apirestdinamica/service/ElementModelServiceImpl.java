package br.com.vfs.apirestdinamica.service;

import br.com.vfs.apirestdinamica.config.ErrorMessage;
import br.com.vfs.apirestdinamica.dto.Field;
import br.com.vfs.apirestdinamica.entity.ElementModel;
import br.com.vfs.apirestdinamica.entity.Model;
import br.com.vfs.apirestdinamica.exception.ModelException;
import br.com.vfs.apirestdinamica.repository.ElementModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementModelServiceImpl {

    private ModelServiceImpl modelService;
    private ElementModelRepository elementModelRepository;
    private ErrorMessage errorMessage;
    public List<ElementModel> getAllElementsFromModel(String name) {
        modelService.isModelValid(name);
        return elementModelRepository.findAllByModel(name);
    }

    public ElementModel getElementFromModelByID(String name, Long id) {
        modelService.isModelValid(name);
        return getElement(name, id);
    }

    public void removeElementFromModelByID(String name, Long id) {
        modelService.isModelValid(name);
        elementModelRepository.delete(getElement(name, id));
    }

    public ElementModel createElementFromModelByID(String name, String structElement) {
        List<Field> fields = getFields(name, structElement);
        Long id = 0L;
        Optional<ElementModel> elementModel = elementModelRepository.findTopByModelOrderByIdDesc(name);
        if(elementModel.isPresent()){
            id = elementModel.get().getId();
        }
        return elementModelRepository.save(new ElementModel(++id, name, fields));
    }

    public ElementModel alterElementFromModelByID(String name, Long id, String structElement) {
        List<Field> fields = getFields(name, structElement);
        ElementModel elementModel = getElement(name, id);
        elementModel.setFields(fields);
        elementModelRepository.save(elementModel);
        return elementModel;
    }

    private ElementModel getElement(String name, Long id) {
        return elementModelRepository.findByIdAndModel(id, name).orElseThrow(() -> new ModelException((errorMessage.getElementNotFound())));
    }

    private List<Field> getFields(String name, String structElement) {
        Model model = modelService.isModelValid(name);
        return model.returnFields(structElement);
    }

    @Autowired
    public void setModelService(ModelServiceImpl modelService) {
        this.modelService = modelService;
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
