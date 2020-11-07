package dev.hirooka.infra.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Link {

    private String href;

    @XmlAttribute
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
