package es.agustruiz.deadpoolcomics.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private final Context mContext;
    private List<ComicPresentation> mComicList;
    private final LayoutInflater mLayoutInflater;
    private OnComicClickListener mOnComicClickListener;


    public interface OnComicClickListener {
        void onComicItemClicked(ComicPresentation comicModelPresentation);
    }

    @Override
    public int getItemCount() {
        return (mComicList != null ? mComicList.size() : 0);
    }

    public ComicAdapter(Context context, Collection<ComicPresentation> collection) {
        mContext = context;
        mComicList = (List<ComicPresentation>) collection;
        mLayoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.comic_row_list, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        final ComicPresentation comicPresentation = mComicList.get(position);
        holder.tvTitle.setText(comicPresentation.getTitle());
        //TODO Set thumbnail
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnComicClickListener != null) {
                    mOnComicClickListener.onComicItemClicked(comicPresentation);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setComicCollection(Collection<ComicPresentation> comicCollection){
        validateComicCollection(comicCollection);
        mComicList = (List<ComicPresentation>) comicCollection;
        this.notifyDataSetChanged();
    }

    public void setOnComicClickListener(OnComicClickListener onComicClickListener){
        mOnComicClickListener = onComicClickListener;
    }


    private void validateComicCollection(Collection<ComicPresentation> comicCollection) {
        if (comicCollection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
    }

    static class ComicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView tvTitle;

        @BindView(R.id.thumbnail)
        ImageView ivThumbnail;

        public ComicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
