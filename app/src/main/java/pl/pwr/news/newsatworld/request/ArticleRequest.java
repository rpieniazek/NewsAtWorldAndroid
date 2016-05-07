package pl.pwr.news.newsatworld.request;

import pl.pwr.news.newsatworld.response.GetArticleResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Rafal Pieniążek on 2016-04-13.
 */
public interface ArticleRequest {

    @GET("/api/article/popular")
    Call<GetArticleResponse> listPopularArticles(@Query("pageSize") int pageSize);

    @GET("/api/category/articles/{categoryId}")
    Call<GetArticleResponse> listArticlesByCategory(@Path("categoryId") Long categoryId);

    @GET("/api/user/favourite")
    Call<GetArticleResponse> listArticlesForUser(@Query("token") String token);
}
