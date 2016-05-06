package pl.pwr.news.newsatworld.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.pwr.news.newsatworld.model.Category;
import pl.pwr.news.newsatworld.request.CategoryRequest;
import pl.pwr.news.newsatworld.response.CategoryResponse;
import retrofit.Call;

/**
 * Created by rkpie on 06.05.2016.
 */
public class CategoryService extends BaseService {

    CategoryRequest request;
    public CategoryService(){
        super();
        request = retrofit.create(CategoryRequest.class);
    }

    public List<Category> getCategoriesList(){
        Call<CategoryResponse> call = request.getCategoriesList();
        List<Category> results = null;

        try {
            results = call.execute().body().value;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
