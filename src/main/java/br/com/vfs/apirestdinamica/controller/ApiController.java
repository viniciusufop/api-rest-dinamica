package br.com.vfs.apirestdinamica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ApiController {

    @GetMapping("/{model}")
    public ResponseEntity getAllElementsFromModel(@PathVariable(name = "model") final String model) {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{model}/{id}")
     public ResponseEntity getElementByIdFromModel(@PathVariable(name = "model") final String model) {

        return ResponseEntity.ok().build();
     }

}
