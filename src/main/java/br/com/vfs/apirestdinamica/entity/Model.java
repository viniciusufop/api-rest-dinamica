package br.com.vfs.apirestdinamica.entity;

import br.com.vfs.apirestdinamica.dto.Field;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Model {

    @Id
    private String name;
    private List<Field> fields;

    public Model() {
    }

    public Model(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }
}
