package dev.hirooka.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Category {

    private String term;

    public String getTerm() {
        return term;
    }

    @XmlAttribute
    public void setTerm(String term) {
        this.term = term;
    }

}
