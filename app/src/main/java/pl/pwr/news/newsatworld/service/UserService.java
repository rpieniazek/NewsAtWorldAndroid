package pl.pwr.news.newsatworld.service;

import pl.pwr.news.newsatworld.request.RegisterRequestBody;
import pl.pwr.news.newsatworld.request.UserRequest;
import pl.pwr.news.newsatworld.response.LoginResponse;
import pl.pwr.news.newsatworld.response.RegisterResponse;
import retrofit.Call;
import retrofit.Callback;

/**
 * Created by rkpie on 06.05.2016.
 */
public class UserService extends BaseService {

    private UserRequest userRequest;

    public UserService() {
        super();
        userRequest = retrofit.create(UserRequest.class);
    }

    public void loginUser(String email, String password, Callback<LoginResponse> callback) {

        Call<LoginResponse> login = userRequest.login(email, password);
        login.enqueue(callback);
    }


    public void registerUser(RegisterRequestBody registerRequestBody, Callback<RegisterResponse> callback) {
        Call<RegisterResponse> register = userRequest.register(
                registerRequestBody.getEmail(),
                registerRequestBody.getPassword(),
                registerRequestBody.getFirstName(),
                registerRequestBody.getLastname());
        register.enqueue(callback);
    }

}
