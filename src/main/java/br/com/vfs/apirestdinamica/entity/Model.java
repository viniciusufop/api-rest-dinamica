package br.com.vfs.apirestdinamica.entity;

import br.com.vfs.apirestdinamica.dto.Field;
import br.com.vfs.apirestdinamica.exception.ModelException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements Serializable {

    @Id
    private String name;
    private List<Field> fields;

    public Model() {
    }

    public Model(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Field> returnFields(String struct) {

        try {
            //convert estrutura em map
            Map result = new ObjectMapper().readValue(struct , HashMap.class);
            fields.forEach(field -> {
                Object value = result.get(field.getName());
                if(value == null){
                    throw new ModelException("FIELD NAO INFORMADO");
                }
                //TODO validar se o valor eh do tipo, e lancar excecao em caso de erro
                field.setValue(value.toString());
            });
        } catch (IOException e) {
            throw new ModelException(e);
        }
        return fields;
    }
}
