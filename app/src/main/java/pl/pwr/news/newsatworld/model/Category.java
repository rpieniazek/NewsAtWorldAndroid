package pl.pwr.news.newsatworld.model;

import java.io.Serializable;

/**
 * Created by Rafal Pieniążek on 2016-04-13.
 */
public class Category implements Serializable {


    private Long id;
    private String imageUrl;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
