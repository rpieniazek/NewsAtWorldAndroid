package pl.pwr.news.newsatworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import pl.pwr.news.newsatworld.adapter.ArticleListAdapter;
import pl.pwr.news.newsatworld.dummy.DummyContent;
import pl.pwr.news.newsatworld.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleListActivity extends AppCompatActivity {

    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        setUpToolbar();
        setUpFloatingActionButton();
        mockArticleData();

        View recyclerView = findViewById(R.id.article_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setUpFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    private void mockArticleData() {
        articleList = new ArrayList<>();
        Article article = new Article();
        article.setId(1L);
        article.setTitle("Title1");
        article.setText("LoremJEDENIpsumDolorem");

        articleList.add(article);

        article.setId(2L);
        article.setTitle("Title2");
        article.setText("LoremDWAIpsumDolorem");

        articleList.add(article);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new ArticleListAdapter(articleList));
    }


}
