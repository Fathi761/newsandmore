package com.programmer.newsandmore.Fragment.WorldFragment.UAE.BottomNavigation.Entertainment;

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

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.EntertainmentViewHolder> {

    private Context con;
    private ArrayList<EntertainmentItem> entertainmentList;

    public EntertainmentAdapter(Context context, ArrayList<EntertainmentItem> entertainmentItemList) {
        this.con = context;
        this.entertainmentList = entertainmentItemList;
    }

    @NonNull
    @Override
    public EntertainmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item,parent,false);
        return new EntertainmentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntertainmentViewHolder holder, int position) {

        EntertainmentItem currentItem = entertainmentList.get(position);

        String imageUrl = currentItem.getEntertainmentImageUrl();
        String title = currentItem.getEntertainmentTitle();
        String desc = currentItem.getEntertainmentDesc();
        String url = currentItem.getEntertainmentUrl();
        String published = currentItem.getEntertainmentpublished();

        holder.entertainmentTextViewTitle.setText(title);
        holder.entertainmentTextViewDesc.setText(desc);
        holder.entertainmentTextViewUrl.setText(url);
        holder.entertainmentTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.entertainmentImageView);

    }

    @Override
    public int getItemCount() {
        return entertainmentList.size() ;
    }

    public class EntertainmentViewHolder extends RecyclerView.ViewHolder {

        public ImageView entertainmentImageView;
        public TextView entertainmentTextViewTitle;
        public TextView entertainmentTextViewDesc;
        public TextView entertainmentTextViewUrl;
        public TextView entertainmentTextViewPublished;

        public EntertainmentViewHolder(@NonNull View itemView) {
            super(itemView);

            entertainmentImageView = itemView.findViewById(R.id.image_view);
            entertainmentTextViewTitle = itemView.findViewById(R.id.text_view_title);
            entertainmentTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            entertainmentTextViewUrl = itemView.findViewById(R.id.text_view_url);
            entertainmentTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
