package br.com.vfs.apirestdinamica.controller;

import br.com.vfs.apirestdinamica.entity.ElementModel;
import br.com.vfs.apirestdinamica.service.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ApiController {

    private ModelServiceImpl modelService;

    @GetMapping(value = "/{model}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllElementsFromModel(@PathVariable(name = "model") final String model) {
        List<ElementModel> elementModels = modelService.getAllElementsForModel(model);
        return ResponseEntity.ok().body(elementModels);
    }

    @GetMapping("/{model}/{id}")
    public ResponseEntity getElementFromModelById(@PathVariable(name = "model") final String model,
                                                  @PathVariable(name = "id") final Long id) {
        ElementModel elementModel = modelService.getElementForModelByID(model, id);
        return ResponseEntity.ok().body(elementModel);
    }

    @PostMapping("/{model}")
    public ResponseEntity createNewElementFromModel(@PathVariable(name = "model") final String model,
                                                    @RequestBody final String structElement) throws URISyntaxException {
        return ResponseEntity.created(new URI("12")).body(model + " " + structElement);
    }

    @PutMapping("/{model}/{id}")
    public ResponseEntity alterElementFromModelByID(@PathVariable(name = "model") final String model,
                                                    @PathVariable(name = "id") final Integer id,
                                                    @RequestBody final String structElement) throws URISyntaxException {
        return ResponseEntity.created(new URI("12")).body(model + " " + structElement);
    }

    @DeleteMapping("/{model}/{id}")
    public ResponseEntity removeElementFromModelByID(@PathVariable(name = "model") final String model,
                                                     @PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok().body(model + " " + id.toString());
    }

    @Autowired
    public void setModelService(ModelServiceImpl modelService) {
        this.modelService = modelService;
    }
}