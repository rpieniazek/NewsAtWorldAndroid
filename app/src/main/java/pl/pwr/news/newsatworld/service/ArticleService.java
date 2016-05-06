package pl.pwr.news.newsatworld.service;

import pl.pwr.news.newsatworld.request.ArticleRequest;
import pl.pwr.news.newsatworld.response.GetArticleResponse;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Rafal Pieniążek on 2016-04-12.
 */
public class ArticleService extends BaseService {

    private ArticleRequest request;

    public ArticleService() {
        super();
        request = retrofit.create(ArticleRequest.class);
    }

    public void getArticleList(Callback<GetArticleResponse> callback){
        Call<GetArticleResponse> listCall = request.listArticles(20);
        listCall.enqueue(callback);
    }

}
