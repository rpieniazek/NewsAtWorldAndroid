package pl.pwr.news.newsatworld.request;

import lombok.Getter;

public class RegisterRequestBody {

    String email;
    String password;
    String firstName;
    String lastname;

    public RegisterRequestBody(String email, String password, String firstName, String lastname) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }
}
