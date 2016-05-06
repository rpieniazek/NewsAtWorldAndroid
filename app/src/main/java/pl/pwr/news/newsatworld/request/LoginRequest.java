package pl.pwr.news.newsatworld.request;

import pl.pwr.news.newsatworld.response.LoginResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by rkpie on 06.05.2016.
 */
public interface LoginRequest {

    @GET("/api/login")
    Call<LoginResponse> login(@Query("email") String email,
                              @Query("password")String password);
}
