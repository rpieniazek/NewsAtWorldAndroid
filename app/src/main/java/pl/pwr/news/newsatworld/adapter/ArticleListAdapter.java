package pl.pwr.news.newsatworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pl.pwr.news.newsatworld.R;
import pl.pwr.news.newsatworld.activity.ArticleDetailActivity;
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
        holder.articleTitle.setText(articleList.get(position).getTitle());
        fillAddedDateField(holder, position);
        fillArticleThumbnail(holder, position);
        holder.articleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startDetailActivity(v, holder);
            }
        });
    }

    private void fillArticleThumbnail(ViewHolder holder, int position) {
        ImageView imageViewHolder = holder.articleThumbnail;
        Context context = imageViewHolder.getContext();

        Picasso.with(context)
                .load(articleList.get(position).getImageUrl())
                .into(imageViewHolder);
    }

    private void fillAddedDateField(ViewHolder holder, int position) {
        String preparedDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
            Date addedDate = articleList.get(position).getAddedDate();
            preparedDate = formatter.format(addedDate);
            holder.articleDateAdded.setText(preparedDate);
        }catch (NullPointerException exc){
            holder.articleDateAdded.setText(R.string.added_date_not_set);
        }
    }

    private void startDetailActivity(View v, ViewHolder holder) {
        Context context = v.getContext();
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        intent.putExtra(ArticleDetailActivity.ARG_ITEM_ID, holder.article);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View articleView;
        public final TextView articleTitle;
        public final TextView articleDateAdded;
        public final ImageView articleThumbnail;

        public Article article;

        public ViewHolder(View view) {
            super(view);
            articleView = view;
            articleTitle = (TextView) view.findViewById(R.id.article_title);
            articleDateAdded = (TextView) view.findViewById(R.id.article_added);
            articleThumbnail = (ImageView) view.findViewById(R.id.article_thumbnail);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + articleTitle.getText() + "'";
        }
    }
}
