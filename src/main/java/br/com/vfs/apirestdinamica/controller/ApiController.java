package br.com.vfs.apirestdinamica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ApiController {

    @GetMapping("/{model}")
    public ResponseEntity getAllElementsFromModel(@PathVariable(name = "model") final String model) {

        return ResponseEntity.ok().body(model);
    }

    @GetMapping("/{model}/{id}")
    public ResponseEntity getElementFromModelById(@PathVariable(name = "model") final String model,
                                                  @PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok().body(model + " " + id.toString());
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
}