package dev.hirooka.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    @XmlElement(name = "entry")
    private List<Entry> feed;
    @XmlElement(name = "link")
    private List<PageLink> link;

    public Feed() {
    }


    public Feed(List<Entry> feed) {
        this.feed = feed;
    }


    public List<Entry> getFeed() {
        return feed;
    }

    public void setFeed(List<Entry> feed) {
        this.feed = feed;
    }


    @JsonIgnore
    public List<PageLink> getLink() {
        return link;
    }

    public void setLink(List<PageLink> link) {
        this.link = link;
    }
}
