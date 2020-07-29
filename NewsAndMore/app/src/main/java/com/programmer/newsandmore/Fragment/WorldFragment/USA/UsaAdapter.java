package com.programmer.newsandmore.Fragment.WorldFragment.USA;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.programmer.newsandmore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UsaAdapter extends RecyclerView.Adapter<UsaAdapter.UsaViewHolder>{
    private Context con;
    private ArrayList<UsaItem> usaList;


    public UsaAdapter(Context context, ArrayList<UsaItem> usaItemList){
        con = context;
        usaList = usaItemList;
    }

    @NonNull
    @Override
    public UsaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new UsaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsaViewHolder holder, int position) {

        UsaItem currentItem = usaList.get(position);

        String imageUrl = currentItem.getUsaImageUrl();
        String title = currentItem.getUsaTitle();
        String desc = currentItem.getUsaDesc();
        String url = currentItem.getUsaUrl();
        String published = currentItem.getUsaPublished();

        holder.usaTextViewTitle.setText(title);
        holder.usaTextViewDesc.setText(desc);
        holder.usaTextViewUrl.setText(url);
        holder.usaTextViewPublished.setText(published);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.usaImageView);
    }

    @Override
    public int getItemCount() {
        return usaList.size();
    }



    public class UsaViewHolder extends RecyclerView.ViewHolder {
        public ImageView usaImageView;
        public TextView usaTextViewTitle;
        public TextView usaTextViewDesc;
        public TextView usaTextViewUrl;
        public TextView usaTextViewPublished;

        public UsaViewHolder(@NonNull View itemView) {
            super(itemView);

            usaImageView = itemView.findViewById(R.id.image_view);
            usaTextViewTitle = itemView.findViewById(R.id.text_view_title);
            usaTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            usaTextViewUrl = itemView.findViewById(R.id.text_view_url);
            usaTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
