package br.com.invillia.magesOfMidgard.model;

import br.com.invillia.magesOfMidgard.model.enums.Element;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/** Classe destinada para mapear um mago **/
public class Mage {

    private Long id;

    @NotBlank /** Notação que valida se a string não esta nem nula, e nem vazia: "" **/
    private String name;

    private Element element;

    @Min(1) /** Define um tamanho minimo para idade, impedindo que sejam negativas **/
    @Max(100) /**  Define um tamanho máximo para idade **/
    private Integer age;

    /** **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
