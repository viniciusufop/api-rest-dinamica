package br.com.vfs.apirestdinamica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class ErrorMessage {

    @Value("${model.not.found}")
    private String modelNotFound;

    @Value("${element.not.found}")
    private String elementNotFound;

    public String getModelNotFound() {
        return modelNotFound;
    }

    public String getElementNotFound() {
        return elementNotFound;
    }
}
