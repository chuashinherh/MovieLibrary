package com.example.movielibrary;

import static com.example.movielibrary.MainActivity.movieViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielibrary.provider.MovieData;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<MovieData> movieData = new ArrayList<>();

    public void setMovieData(List<MovieData> movieData) {
        this.movieData = movieData;
    }

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleText.setText(movieData.get(position).getTitle());
        holder.yearText.setText(movieData.get(position).getYear());
        holder.countryText.setText(movieData.get(position).getCountry());
        holder.genreText.setText(movieData.get(position).getGenre());
        holder.costText.setText(movieData.get(position).getCost());
        holder.keywordsText.setText(movieData.get(position).getKeywords());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(v.getContext(), "Movie No." + (position+1) +
//                        " with Title:" + holder.titleText.getText() + " is selected", Toast.LENGTH_SHORT);
//                toast.show();
                int year = Integer.parseInt(holder.yearText.getText().toString());
                movieViewModel.deleteMovieByYear(year);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View itemView;
        public TextView titleText;
        public TextView yearText;
        public TextView countryText;
        public TextView genreText;
        public TextView costText;
        public TextView keywordsText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.titleText = itemView.findViewById(R.id.titleText);
            this.yearText = itemView.findViewById(R.id.yearText);
            this.countryText = itemView.findViewById(R.id.countryText);
            this.genreText = itemView.findViewById(R.id.genreText);
            this.costText = itemView.findViewById(R.id.costText);
            this.keywordsText = itemView.findViewById(R.id.keywordsText);
        }
    }
}
