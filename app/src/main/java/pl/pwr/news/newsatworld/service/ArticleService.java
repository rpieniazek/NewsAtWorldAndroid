package pl.pwr.news.newsatworld.service;

import java.io.IOException;

import pl.pwr.news.newsatworld.request.ArticleRequest;
import pl.pwr.news.newsatworld.response.GetArticleResponse;
import pl.pwr.news.newsatworld.response.LikeDislikeArticleResponse;
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

    public void getArticlesForUser(String token,Callback<GetArticleResponse> callback) {
        Call<GetArticleResponse> listCall = request.listArticlesForUser(token);
        listCall.enqueue(callback);
    }

    public void likeArticle(Long id) {

        try {
            Call<LikeDislikeArticleResponse> call = request.likeArticle(id);
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dislikeArticle(Long id) {
        try {
            Call<LikeDislikeArticleResponse> call = request.dislikeArticle(id);
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
