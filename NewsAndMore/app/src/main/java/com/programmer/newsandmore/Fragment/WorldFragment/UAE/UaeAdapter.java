package com.programmer.newsandmore.Fragment.WorldFragment.UAE;

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

public class UaeAdapter extends RecyclerView.Adapter<UaeAdapter.UaeViewHolder> {
    private Context con;
    private ArrayList<UaeItem> uaeList;

    public UaeAdapter(Context context, ArrayList<UaeItem> uaeItemList){
        con = context;
        uaeList = uaeItemList;
    }

    @NonNull
    @Override
    public UaeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new UaeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UaeViewHolder holder, int position) {

        UaeItem currentItem = uaeList.get(position);

        String imageUrl = currentItem.getUaeImageUrl();
        String title = currentItem.getUaeTitle();
        String desc = currentItem.getUaeDesc();
        String url = currentItem.getUaeUrl();
        String published = currentItem.getUaePublished();

        holder.uaeTextViewTitle.setText(title);
        holder.uaeTextViewDesc.setText(desc);
        holder.uaeTextViewUrl.setText(url);
        holder.uaeTextViewPublished.setText(published);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.uaeImageView);
    }

    @Override
    public int getItemCount() {
        return uaeList.size();
    }


    public class UaeViewHolder extends RecyclerView.ViewHolder {
        public ImageView uaeImageView;
        public TextView uaeTextViewTitle;
        public TextView uaeTextViewDesc;
        public TextView uaeTextViewUrl;
        public TextView uaeTextViewPublished;

        public UaeViewHolder(@NonNull View itemView) {
            super(itemView);

            uaeImageView = itemView.findViewById(R.id.image_view);
            uaeTextViewTitle = itemView.findViewById(R.id.text_view_title);
            uaeTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            uaeTextViewUrl = itemView.findViewById(R.id.text_view_url);
            uaeTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
