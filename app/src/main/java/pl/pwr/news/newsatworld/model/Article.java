package pl.pwr.news.newsatworld.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Created by Rafal Pieniążek on 2016-04-12.
 */
public class Article implements Serializable {

    private Long id;
    private String title;
    private String text;
    private String imageUrl;
    private String link;
    private Long addedDate;
    private List<Tag> tags;
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getAddedDate() {
        return new Date(addedDate);
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate.getTime();
    }
}
