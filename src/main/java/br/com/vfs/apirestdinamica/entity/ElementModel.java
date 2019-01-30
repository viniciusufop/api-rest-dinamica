package br.com.vfs.apirestdinamica.entity;

import br.com.vfs.apirestdinamica.dto.Field;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class ElementModel implements Serializable {

    @Id
    private String elementModelId;
    private Long id;
    private String model;
    private List<Field> fields;

    public ElementModel() {
    }

    public ElementModel(Long id, String model, List<Field> fields) {
        this.model = model;
        this.fields = fields;
        this.id = id;
        this.elementModelId = String.format("%s-%d", model, id);
    }

    public String getElementModelId() {
        return elementModelId;
    }

    public void setElementModelId(String elementModelId) {
        this.elementModelId = elementModelId;
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
