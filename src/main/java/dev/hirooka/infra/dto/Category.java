package dev.hirooka.infra.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Category {


    public Category() {
    }

    public Category(String term) {
        this.term = term;
    }

    private String term;


    public String getTerm() {
        return term;
    }

    @XmlAttribute
    public void setTerm(String term) {
        this.term = term;
    }
}
