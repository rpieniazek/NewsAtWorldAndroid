package pl.pwr.news.newsatworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import pl.pwr.news.newsatworld.adapter.ArticleListAdapter;
import pl.pwr.news.newsatworld.model.Article;
import pl.pwr.news.newsatworld.model.Category;
import pl.pwr.news.newsatworld.model.User;
import pl.pwr.news.newsatworld.presenter.ArticlePresenter;
import pl.pwr.news.newsatworld.service.CategoryService;
import pl.pwr.news.newsatworld.view.ArticleListView;

public class ArticleListActivity extends ActionBarActivity implements ArticleListView {

    public static String USER = "ArticleListActivity.User";

    private ArticlePresenter presenter;
    private List<Article> articleList;
    List<Category> categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        presenter = new ArticlePresenter(this);
        presenter.getArticleList();
        User user = getUserFromIntent();
        setUpToolbar();
    }

    private User getUserFromIntent() {
        Intent intent = getIntent();
        return (User) intent.getSerializableExtra(USER);
    }

    @Override
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
        View recyclerView = findViewById(R.id.article_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    @Override
    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }


    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.article_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_filter) {

            CharSequence categories[] = obtainCategoriesCharSequences();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pick a category");

            builder.setItems(categories, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // the user clicked on categories [which]
                }
            });
            builder.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private CharSequence[] obtainCategoriesCharSequences() {

        CategoryService categoryService = new CategoryService();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<Category> categoriesList = categoryService.getCategoriesList();
        CharSequence results[] = new CharSequence[categoriesList.size()];
        for(int i = 0;i<results.length;i++){
            results[i] = categoriesList.get(i).getName();
        }
        return results;
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new ArticleListAdapter(articleList));
    }
}
