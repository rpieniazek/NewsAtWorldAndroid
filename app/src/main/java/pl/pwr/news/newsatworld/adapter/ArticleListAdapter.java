package pl.pwr.news.newsatworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.pwr.news.newsatworld.ArticleDetailActivity;
import pl.pwr.news.newsatworld.ArticleDetailFragment;
import pl.pwr.news.newsatworld.R;
import pl.pwr.news.newsatworld.model.Article;

/**
 * Created by Rafal Pieniążek on 2016-04-12.
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private final List<Article> articleList;

    public ArticleListAdapter(List<Article> article) {
        this.articleList = article;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.article = articleList.get(position);
        holder.title.setText(articleList.get(position).getTitle());

        holder.articleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startDetailActivity(v, holder);
            }
        });
    }

    private void startDetailActivity(View v, ViewHolder holder) {
        Context context = v.getContext();
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        intent.putExtra(ArticleDetailFragment.ARG_ITEM_ID, holder.article);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View articleView;
        public final TextView title;
        public Article article;

        public ViewHolder(View view) {
            super(view);
            articleView = view;
            title = (TextView) view.findViewById(R.id.article_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + title.getText() + "'";
        }
    }
}
