package br.com.vfs.apirestdinamica.entity;

import br.com.vfs.apirestdinamica.dto.Field;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class ElementModel implements Serializable {

    @Id
    private Long id;
    private String model;
    private List<Field> fields;

    public ElementModel(Long id, String model, List<Field> fields) {
        this.id = id;
        this.model = model;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
