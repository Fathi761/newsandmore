package com.programmer.newsandmore.Fragment.WorldFragment.Egypt;

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

public class EgyptAdapter extends RecyclerView.Adapter<EgyptAdapter.EgyptViewHolder> {

    private Context con;
    private ArrayList<EgyptItem> egyptList;

    public  EgyptAdapter(Context context, ArrayList<EgyptItem> egyptItemList){
        con = context;
        egyptList = egyptItemList;
    }

    @NonNull
    @Override
    public EgyptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new EgyptViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EgyptViewHolder holder, int position) {

        EgyptItem currentItem = egyptList.get(position);

        String imageUrl = currentItem.getEgyptImageUrl();
        String title = currentItem.getEgyptTitle();
        String desc = currentItem.getEgyptDesc();
        String url = currentItem.getEgyptUrl();
        String published = currentItem.getEgyptPublished();

        holder.egyptTextViewTitle.setText(title);
        holder.egyptTextViewDesc.setText(desc);
        holder.egyptTextViewUrl.setText(url);
        holder.egyptTextViewPublished.setText(published);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.egyptImageView);
    }

    @Override
    public int getItemCount() {
        return egyptList.size();
    }


    public class EgyptViewHolder extends RecyclerView.ViewHolder {
        public ImageView egyptImageView;
        public TextView egyptTextViewTitle;
        public TextView egyptTextViewDesc;
        public TextView egyptTextViewUrl;
        public TextView egyptTextViewPublished;

        public EgyptViewHolder(@NonNull View itemView) {
            super(itemView);

            egyptImageView = itemView.findViewById(R.id.image_view);
            egyptTextViewTitle = itemView.findViewById(R.id.text_view_title);
            egyptTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            egyptTextViewUrl = itemView.findViewById(R.id.text_view_url);
            egyptTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
