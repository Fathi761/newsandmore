package com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom;

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

public class UnitedKingdomAdapter extends RecyclerView.Adapter<UnitedKingdomAdapter.UnitedKingdomViewHolder> {

    private Context con;
    private ArrayList<UnitedkingdomItem> unitedKingdomList;

    public UnitedKingdomAdapter(Context context, ArrayList<UnitedkingdomItem> unitedKingdomItemList){
        con = context;
        unitedKingdomList = unitedKingdomItemList;
    }

    @NonNull
    @Override
    public UnitedKingdomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new UnitedKingdomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitedKingdomViewHolder holder, int position) {

        UnitedkingdomItem currentItem = unitedKingdomList.get(position);

        String imageUrl = currentItem.getUnitedKingdomImageUrl();
        String title = currentItem.getUnitedKingdomTitle();
        String desc = currentItem.getUnitedKingdomDesc();
        String url = currentItem.getUnitedKingdomUrl();
        String published = currentItem.getUnitedKingdomPublished();

        holder.unitedKingdomTextViewTitle.setText(title);
        holder.unitedKingdomTextViewDesc.setText(desc);
        holder.unitedKingdomTextViewUrl.setText(url);
        holder.unitedKingdomTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.unitedKingdomImageView);
    }

    @Override
    public int getItemCount() {
        return unitedKingdomList.size();
    }


    public class UnitedKingdomViewHolder extends RecyclerView.ViewHolder {
        public ImageView unitedKingdomImageView;
        public TextView unitedKingdomTextViewTitle;
        public TextView unitedKingdomTextViewDesc;
        public TextView unitedKingdomTextViewUrl;
        public TextView unitedKingdomTextViewPublished;

        public UnitedKingdomViewHolder(@NonNull View itemView) {
            super(itemView);

            unitedKingdomImageView = itemView.findViewById(R.id.image_view);
            unitedKingdomTextViewTitle = itemView.findViewById(R.id.text_view_title);
            unitedKingdomTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            unitedKingdomTextViewUrl = itemView.findViewById(R.id.text_view_url);
            unitedKingdomTextViewPublished = itemView.findViewById(R.id.text_view_published);

        }
    }
}
