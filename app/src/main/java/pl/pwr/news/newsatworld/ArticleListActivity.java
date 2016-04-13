package pl.pwr.news.newsatworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pl.pwr.news.newsatworld.adapter.ArticleListAdapter;
import pl.pwr.news.newsatworld.model.Article;
import pl.pwr.news.newsatworld.presenter.ArticlePresenter;
import pl.pwr.news.newsatworld.view.ArticleListView;

public class ArticleListActivity extends AppCompatActivity implements ArticleListView {
    ArticlePresenter presenter;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        presenter = new ArticlePresenter(this);
        presenter.getArticleList();
        setUpToolbar();
        setUpFloatingActionButton();
    }

    @Override
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
        View recyclerView = findViewById(R.id.article_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setUpFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getArticleList();
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new ArticleListAdapter(articleList));
    }
}
