package com.programmer.newsandmore.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.programmer.newsandmore.R;

public class RatingFragment extends Fragment {

    RatingBar rb;
    Button btn_rating;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rating, container, false);

        rb = v.findViewById(R.id.rb);
        btn_rating = v.findViewById(R.id.btn);

        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalStars = "Total Stars: " + rb.getNumStars();
                String rating = "Rating: " + rb.getRating();
            }
        });

        return v;
    }
}
