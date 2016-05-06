package pl.pwr.news.newsatworld.service;

import pl.pwr.news.newsatworld.request.ArticleRequest;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by rkpie on 06.05.2016.
 */
public class BaseService {
    protected Retrofit retrofit;


    public BaseService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://37.187.52.160:9000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
