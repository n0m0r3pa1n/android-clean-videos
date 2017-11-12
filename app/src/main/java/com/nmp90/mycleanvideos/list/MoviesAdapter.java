package com.nmp90.mycleanvideos.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nmp90.mycleanvideos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private final MovieClickListener clickListener;
    private List<UiMovie> movies = new ArrayList<>();

    public MoviesAdapter(MovieClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.title.setOnClickListener(view1 -> {
            if (viewHolder.getAdapterPosition() == RecyclerView.NO_POSITION) {
                return;
            }

            UiMovie selectedMovie = movies.get(viewHolder.getAdapterPosition());
            clickListener.onMovieClick(selectedMovie);
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UiMovie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<UiMovie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    interface MovieClickListener {
        void onMovieClick(UiMovie movie);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
