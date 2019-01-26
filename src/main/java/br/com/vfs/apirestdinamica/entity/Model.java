package br.com.vfs.apirestdinamica.entity;

import org.springframework.data.annotation.Id;

public class Model {

    @Id
    private String name;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
    }
}
