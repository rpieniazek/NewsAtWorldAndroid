package pl.pwr.news.newsatworld.request;

import pl.pwr.news.newsatworld.response.CategoryResponse;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by rkpie on 06.05.2016.
 */
public interface CategoryRequest {

    @GET("/api/category")
    Call<CategoryResponse> getCategoriesList();
}
