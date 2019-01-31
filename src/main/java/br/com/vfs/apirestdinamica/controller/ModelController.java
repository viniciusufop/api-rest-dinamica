package br.com.vfs.apirestdinamica.controller;

import br.com.vfs.apirestdinamica.entity.Model;
import br.com.vfs.apirestdinamica.service.ElementModelServiceImpl;
import br.com.vfs.apirestdinamica.service.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    private ModelServiceImpl modelService;


    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllElementsFromModel() {
        List<Model> models = modelService.getAllModels();
        return ResponseEntity.ok().body(models);
    }

    @GetMapping(value="/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getModelByName(@PathVariable(name = "name") final String name) {
        Model model = modelService.getModelByName(name);
        return ResponseEntity.ok().body(model);
    }

    @Autowired
    public void setModelService(ModelServiceImpl modelService) {
        this.modelService = modelService;
    }
}