package com.programmer.newsandmore.Fragment.WorldFragment.Egypt.BottomNavigation.Health;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.programmer.newsandmore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

    private Context con;
    private ArrayList<HealthItem> healthList;

    public HealthAdapter (Context context, ArrayList<HealthItem> healthItemList) {
        con = context;
        healthList = healthItemList;
    }

    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item,parent,false);
        return new HealthViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, int position) {

        HealthItem currentItem = healthList.get(position);

        String imageUrl = currentItem.getHealthImageUrl();
        String title = currentItem.getHealthTitle();
        String desc = currentItem.getHealthDesc();
        String url = currentItem.getHealthUrl();
        String published = currentItem.getHealthpublished();

        holder.healthTextViewTitle.setText(title);
        holder.healthTextViewDesc.setText(desc);
        holder.healthTextViewUrl.setText(url);
        holder.healthTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.healthImageView);
    }

    @Override
    public int getItemCount() {
        return healthList.size();
    }


    public class HealthViewHolder extends RecyclerView.ViewHolder {

        public ImageView healthImageView;
        public TextView healthTextViewTitle;
        public TextView healthTextViewDesc;
        public TextView healthTextViewUrl;
        public TextView healthTextViewPublished;

        public HealthViewHolder(@NonNull View itemView) {
            super(itemView);

            healthImageView = itemView.findViewById(R.id.image_view);
            healthTextViewTitle = itemView.findViewById(R.id.text_view_title);
            healthTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            healthTextViewUrl = itemView.findViewById(R.id.text_view_url);
            healthTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
