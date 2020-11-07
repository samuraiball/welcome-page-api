package dev.hirooka.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    public Entry() {
    }

    public Entry(String title, String published, String summary, Link link, List<Category> category, String edited, Control control) {
        this.title = title;
        this.published = published;
        this.summary = summary;
        this.link = link;
        this.category = category;
        this.edited = edited;
        this.control = control;
    }

    private String title;

    private String published;

    private String summary;

    private Link link;

    private List<Category> category;

    @XmlElement(name = "edited", namespace = "http://www.w3.org/2007/app")
    private String edited;


    @XmlElement(name = "control", namespace = "http://www.w3.org/2007/app")
    @JsonIgnore
    private Control control;



    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("published")
    public String getFormatJSTDate() {
        ZonedDateTime date = ZonedDateTime.parse(published, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss");
        Date jstDate = Date.from(date.toInstant());
        return df.format(jstDate);
    }
}
