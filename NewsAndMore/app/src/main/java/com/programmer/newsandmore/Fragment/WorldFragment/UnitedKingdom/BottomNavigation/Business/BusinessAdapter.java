package com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Business;

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

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder> {

    private Context con;
    private ArrayList<BusinessItem> businessList;

    public BusinessAdapter(Context con, ArrayList<BusinessItem> businessList) {
        this.con = con;
        this.businessList = businessList;
    }

    @NonNull
    @Override
    public BusinessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.world_item, parent, false);
        return new BusinessViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessViewHolder holder, int position) {

        BusinessItem currentItem = businessList.get(position);

        String imageUrl = currentItem.getBusinessImageUrl();
        String title = currentItem.getBusinessTitle();
        String desc = currentItem.getBusinessDesc();
        String url = currentItem.getBusinessUrl();
        String published = currentItem.getBusinessPublished();

        holder.businessTextViewTitle.setText(title);
        holder.businessTextViewDesc.setText(desc);
        holder.businessTextViewUrl.setText(url);
        holder.businessTextViewPublished.setText(published);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.businessImageView);

    }

    @Override
    public int getItemCount() {
        return businessList.size();
    }

    public class BusinessViewHolder extends RecyclerView.ViewHolder {
        public ImageView  businessImageView;
        public TextView businessTextViewTitle;
        public TextView businessTextViewDesc;
        public TextView businessTextViewUrl;
        public TextView businessTextViewPublished;


        public BusinessViewHolder(@NonNull View itemView) {
            super(itemView);

            businessImageView = itemView.findViewById(R.id.image_view);
            businessTextViewTitle = itemView.findViewById(R.id.text_view_title);
            businessTextViewDesc = itemView.findViewById(R.id.text_view_desc);
            businessTextViewUrl = itemView.findViewById(R.id.text_view_url);
            businessTextViewPublished = itemView.findViewById(R.id.text_view_published);

        }
    }
}
