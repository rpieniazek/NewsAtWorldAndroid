package pl.pwr.news.newsatworld.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by rkpie on 06.05.2016.
 */
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String token;
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
