package dev.hirooka.infra.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class PageLink {

    private String href;
    private String rel;


    @XmlAttribute
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @XmlAttribute
    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
