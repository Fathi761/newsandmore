package com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia;

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

public class SaudiArabiaAdapter extends RecyclerView.Adapter<SaudiArabiaAdapter.SaudiArabiaViewHolder> {
    private Context con;
    private ArrayList<SaudiItem> saList;

    public SaudiArabiaAdapter(Context context, ArrayList<SaudiItem> saItemList){
        con = context;
        saList = saItemList;
    }

    @NonNull
    @Override
    public SaudiArabiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new SaudiArabiaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SaudiArabiaViewHolder holder, int position) {

        SaudiItem currentItem = saList.get(position);

        String imageUrl = currentItem.getSaudiImageUrl();
        String title = currentItem.getSaudiTitle();
        String desc = currentItem.getSaudiDesc();
        String url = currentItem.getSaudiUrl();
        String published = currentItem.getSaudiPublished();

        holder.saTextViewTitle.setText(title);
        holder.saTextViewDesc.setText(desc);
        holder.saTextViewUrl.setText(url);
        holder.saTextViewPublished.setText(published);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.saImageView);
    }

    @Override
    public int getItemCount() {
        return saList.size();
    }


    public class SaudiArabiaViewHolder extends RecyclerView.ViewHolder {
        public ImageView saImageView;
        public TextView saTextViewTitle;
        public TextView saTextViewDesc;
        public TextView saTextViewUrl;
        public TextView saTextViewPublished;

        public SaudiArabiaViewHolder(@NonNull View itemView) {
            super(itemView);

            saImageView = itemView.findViewById(R.id.image_view);
            saTextViewTitle = itemView.findViewById(R.id.text_view_title);
            saTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            saTextViewUrl = itemView.findViewById(R.id.text_view_url);
            saTextViewPublished = itemView.findViewById(R.id.text_view_published);
        }
    }
}
