package pl.pwr.news.newsatworld.presenter;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import pl.pwr.news.newsatworld.model.Article;
import pl.pwr.news.newsatworld.response.GetArticleResponse;
import pl.pwr.news.newsatworld.service.ArticleService;
import pl.pwr.news.newsatworld.view.ArticleListView;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Rafal Pieniążek on 2016-04-13.
 */
public class ArticlePresenter implements Callback<GetArticleResponse> {

    ArticleService articleService;
    Context context;
    ArticleListView articleListView;


    public ArticlePresenter(Context context) {
        this.context = context;
        articleService = new ArticleService();
        this.articleListView = (ArticleListView) context;
    }

    public void getPopularArticleList() {
        articleService.getPopularArticleList(this);
    }

    public void getArticleListByCategory(Long categoryId) {
        articleService.getArticleListByCategory(categoryId,this);
    }



    @Override
    public void onResponse(Response<GetArticleResponse> response, Retrofit retrofit) {
        articleListView.setArticleList(response.body().value);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(context, "Cannot load data,an error occured", Toast.LENGTH_SHORT).show();
        articleListView.setArticleList(new ArrayList<Article>());

    }


}
