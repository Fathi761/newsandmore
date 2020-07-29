package com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Technology;

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

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.TechnologyViewHolder> {

    private Context con;
    private ArrayList<TechnologyItem> technologyList;

    public TechnologyAdapter(Context context, ArrayList<TechnologyItem> technologyItemList) {
        this.con = context;
        this.technologyList = technologyItemList;
    }

    @NonNull
    @Override
    public TechnologyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item,parent,false);
        return new TechnologyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TechnologyViewHolder holder, int position) {

        TechnologyItem currentItem = technologyList.get(position);

        String imageUrl = currentItem.getTechnologyImageUrl();
        String title = currentItem.getTechnologyTitle();
        String desc = currentItem.getTechnologyDesc();
        String url = currentItem.getTechnologyUrl();
        String published = currentItem.getTechnologyPublished();

        holder.technologyTextViewTitle.setText(title);
        holder.technologyTextViewDesc.setText(desc);
        holder.technologyTextViewUrl.setText(url);
        holder.technologyTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.technologyImageView);
    }

    @Override
    public int getItemCount() {
        return technologyList.size();
    }


    public class TechnologyViewHolder extends RecyclerView.ViewHolder {

        public ImageView technologyImageView;
        public TextView technologyTextViewTitle;
        public TextView technologyTextViewDesc;
        public TextView technologyTextViewUrl;
        public TextView technologyTextViewPublished;

        public TechnologyViewHolder(@NonNull View itemView) {
            super(itemView);

            technologyImageView = itemView.findViewById(R.id.image_view);
            technologyTextViewTitle = itemView.findViewById(R.id.text_view_title);
            technologyTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            technologyTextViewUrl = itemView.findViewById(R.id.text_view_url);
            technologyTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
