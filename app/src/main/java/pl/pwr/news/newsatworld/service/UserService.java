package pl.pwr.news.newsatworld.service;

import pl.pwr.news.newsatworld.request.LoginRequest;
import pl.pwr.news.newsatworld.response.LoginResponse;
import retrofit.Call;
import retrofit.Callback;

/**
 * Created by rkpie on 06.05.2016.
 */
public class UserService extends BaseService{

    private LoginRequest loginRequest;

    public UserService() {
        super();
        loginRequest = retrofit.create(LoginRequest.class);
    }

    public void loginUser(String email,String password,Callback<LoginResponse> callback){

        Call<LoginResponse> login = loginRequest.login(email,password);
        login.enqueue(callback);
    }


    public void registerUser(){

    }

}
