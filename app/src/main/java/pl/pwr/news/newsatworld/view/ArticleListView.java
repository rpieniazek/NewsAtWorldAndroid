package pl.pwr.news.newsatworld.view;

import java.util.List;

import pl.pwr.news.newsatworld.model.Article;
import pl.pwr.news.newsatworld.model.Category;

/**
 * Created by Rafal Pieniążek on 2016-04-13.
 */
public interface ArticleListView {

    void setArticleList(List<Article> articleList);
    void setCategoriesList(List<Category> categoriesList);

}
