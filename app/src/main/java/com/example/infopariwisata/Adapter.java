package com.example.infopariwisata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<InfoPariwisata> wisataList;
    private Context context;

    public Adapter(List<InfoPariwisata> wisataList, Context context) {
        this.wisataList = wisataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        InfoPariwisata currentPlace = wisataList.get(position);
        holder.nama.setText(currentPlace.getName());
        holder.lokasi.setText(currentPlace.getLocation());
        holder.gambar.setImageResource(currentPlace.getImageResource());
        holder.rating.setText(String.valueOf(currentPlace.getRating()));
        holder.cardView.setOnClickListener(v -> {

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("placename", currentPlace.getName());
            intent.putExtra("placelocation", currentPlace.getLocation());
            intent.putExtra("imagedetails", currentPlace.getImageResource());
            intent.putExtra("placedetails", currentPlace.getDetails());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, lokasi, rating;
        ImageView gambar, ratingicon;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.placename);
            lokasi = itemView.findViewById(R.id.placelocation);
            gambar = itemView.findViewById(R.id.imagedetails);
            rating = itemView.findViewById(R.id.placerating);
            ratingicon = itemView.findViewById(R.id.iconrating);  // Jika menggunakan ikon bintang
            cardView = itemView.findViewById(R.id.cardView);  // Inisialisasi CardView
        }
    }
}