package pl.pwr.news.newsatworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import pl.pwr.news.newsatworld.model.Article;

/**
 *
 * A fragment representing a single Article detail screen.
 * This fragment is either contained in a {@link ArticleListActivity}
 * in two-pane mode (on tablets) or a {@link ArticleDetailActivity}
 * on handsets.
 */
public class ArticleDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "ArticleDetailFragment.ARG_ITEM_ID";

    private Article article;
    private Activity activity;

    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            this.activity = getActivity();
            getArticleFromIntent();
            setupCollapsingToolbar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_detail, container, false);

        if (article != null) {
            ((TextView) rootView.findViewById(R.id.article_detail)).setText(article.getText());
        }

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setupGotoArticleButton();
        // trzeba sie dostac z fragmentu do layoutu calego activity
        //narazie tak niebardzo to dziala(nie dziala onclick)
    }

    private void setupGotoArticleButton() {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View activityLayout = layoutInflater.inflate(R.layout.activity_article_detail,null);
        FloatingActionButton fab = (FloatingActionButton)  activityLayout.findViewById(R.id.goto_article);
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

    private void setupCollapsingToolbar() {
        final CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(article.getTitle());
            Picasso.with(activity).load(article.getImageUrl()).into(new Target() {
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

    private void getArticleFromIntent() {
        Intent intent = activity.getIntent();
        article = (Article) intent.getSerializableExtra(ARG_ITEM_ID);
    }
}
