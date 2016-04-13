package pl.pwr.news.newsatworld.model;

import java.io.Serializable;

/**
 * Created by Rafal Pieniążek on 2016-04-13.
 */
public class Tag implements Serializable {

    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
