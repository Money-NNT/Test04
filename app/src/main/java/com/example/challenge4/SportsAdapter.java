package com.example.challenge4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportsViewHolder> {

    private Context context;
    private List<Sport> sportsList;

    public SportsAdapter(Context context, List<Sport> sportsList) {
        this.context = context;
        this.sportsList = sportsList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sport, parent, false);
        return new SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        Sport sport = sportsList.get(position);
        holder.sportName.setText(sport.getName());
        holder.sportImage.setImageResource(sport.getImageResource());
    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }

    public class SportsViewHolder extends RecyclerView.ViewHolder {
        ImageView sportImage;
        TextView sportName;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImage = itemView.findViewById(R.id.sportImage);
            sportName = itemView.findViewById(R.id.sportName);
        }
    }
}