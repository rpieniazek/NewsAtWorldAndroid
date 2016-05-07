package pl.pwr.news.newsatworld.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.pwr.news.newsatworld.R;
import pl.pwr.news.newsatworld.model.Article;
import pl.pwr.news.newsatworld.presenter.ArticlePresenter;
import pl.pwr.news.newsatworld.view.ArticleDetailView;

/**
 * An activity representing a single Article detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ArticleListActivity}.
 */
public class ArticleDetailActivity extends AppCompatActivity implements ArticleDetailView {

    public static final String ARG_ITEM_ID = "ArticleDetailFragment.ARG_ITEM_ID";

    private Article article;
    private ArticlePresenter presenter;

    @Bind(R.id.like)
    Button likeButton;

    @Bind(R.id.dislike)
    Button dislikeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        allowNetworkOnUIThread();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        presenter = new ArticlePresenter();
        getArticleFromIntent();
        addLikeDislikeOnClickListeners();
        setupGotoArticleButton();
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ARG_ITEM_ID,
                    getIntent().getStringExtra(ARG_ITEM_ID));
            setupCollapsingToolbar();
            TextView articleText = (TextView) findViewById(R.id.article_detail);
            articleText.setText(article.getText());
        }
    }

    private void allowNetworkOnUIThread() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void addLikeDislikeOnClickListeners() {
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.likeArticle(article.getId());
                showOpinionSentToast();
                hideButtons();
            }


        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.dislikeArticle(article.getId());
                showOpinionSentToast();
                hideButtons();
            }
        });
    }

    private void hideButtons() {
        likeButton.setVisibility(View.GONE);
        dislikeButton.setVisibility(View.GONE);
    }

    private void showOpinionSentToast() {
        Toast.makeText(this, "Opinion sent", Toast.LENGTH_SHORT).show();
    }

    private void getArticleFromIntent() {
        Intent intent = getIntent();
        article = (Article) intent.getSerializableExtra(ARG_ITEM_ID);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ArticleListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupCollapsingToolbar() {
        final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(article.getTitle());
            Picasso.with(this).load(article.getImageUrl()).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    appBarLayout.setBackground(new BitmapDrawable(bitmap));
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
        }
    }

    private void setupGotoArticleButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.goto_article);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = article.getLink();
                    System.out.println(url);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }
    }

}
