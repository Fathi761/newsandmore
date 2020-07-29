package com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Sport;

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

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {

    private Context con;
    private ArrayList<SportItem> sportList;

    public SportAdapter (Context context , ArrayList<SportItem> sportItemArrayList) {
        con = context;
        sportList = sportItemArrayList;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new SportViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {

        SportItem currentItem = sportList.get(position);

        String imageUrl = currentItem.getSportImageUrl();
        String title = currentItem.getSportTitle();
        String desc = currentItem.getSportDesc();
        String url = currentItem.getSportUrl();
        String published = currentItem.getSportPublished();

        holder.sportTextViewTitle.setText(title);
        holder.sportTextViewDesc.setText(desc);
        holder.sportTextViewUrl.setText(url);
        holder.sportTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.sportImageView);

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder {

        public ImageView sportImageView;
        public TextView sportTextViewTitle;
        public TextView sportTextViewDesc;
        public TextView sportTextViewUrl;
        public TextView sportTextViewPublished;


        public SportViewHolder(@NonNull View itemView) {
            super(itemView);

            sportImageView = itemView.findViewById(R.id.image_view);
            sportTextViewTitle = itemView.findViewById(R.id.text_view_title);
            sportTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            sportTextViewUrl = itemView.findViewById(R.id.text_view_url);
            sportTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }


}
