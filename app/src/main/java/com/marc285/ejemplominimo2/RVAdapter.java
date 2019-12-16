package com.marc285.ejemplominimo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marc285.ejemplominimo2.models.Element;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {

    private List<Element> museumelements; //DATA
    private Context context; //In order to open a Picasso image

    public RVAdapter(List<Element> elements) {
        this.museumelements = elements;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new RVViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        holder.museumText.setText(museumelements.get(position).getAdrecaNom());
        //Museum image (in URL format) is loaded by means of Picasso
        Picasso.with(context).load(museumelements.get(position).getImatge().get(0)).into(holder.museumImage);
    }

    @Override
    public int getItemCount() {
        return museumelements.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {

        //Views of each RecyclerView item
        ImageView museumImage;
        TextView museumText;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);

            museumImage = itemView.findViewById(R.id.museumImageView);
            museumText = itemView.findViewById(R.id.museumTextView);
        }
    }
}
