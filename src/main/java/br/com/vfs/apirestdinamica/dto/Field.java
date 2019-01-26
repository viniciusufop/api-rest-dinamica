package br.com.vfs.apirestdinamica.dto;

import java.io.Serializable;

public class Field implements Serializable {

    private String name;
    private String value;
    private FieldType type;

    public Field() {
    }

    public Field(String name, FieldType type) {
        this.name = name;
        this.type = type;
    }

    public Field(String name, String value, FieldType type) {
        this(name, type);
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }
}
