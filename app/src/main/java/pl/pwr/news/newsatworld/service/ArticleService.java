package pl.pwr.news.newsatworld.service;

import pl.pwr.news.newsatworld.request.ArticleRequest;
import pl.pwr.news.newsatworld.response.GetArticleResponse;
import retrofit.Call;
import retrofit.Callback;

/**
 * Created by Rafal Pieniążek on 2016-04-12.
 */
public class ArticleService extends BaseService {

    private ArticleRequest request;

    public ArticleService() {
        super();
        request = retrofit.create(ArticleRequest.class);
    }

    public void getPopularArticleList(Callback<GetArticleResponse> callback){
        Call<GetArticleResponse> listCall = request.listPopularArticles(20);
        listCall.enqueue(callback);
    }

    public void getArticleListByCategory(Long categoryId, Callback<GetArticleResponse> callback){
        Call<GetArticleResponse> listCall = request.listArticlesByCategory(categoryId);
        listCall.enqueue(callback);
    }

}
