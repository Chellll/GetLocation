package com.example.getlocation.view.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.getlocation.R;
import com.example.getlocation.data.models.api.Explore;

public class ExploreAdapter {//extends RecyclerView.Adapter<ExploreAdapter.ExploreHolder> {

   // private List<Item_>

    public class ExploreHolder extends RecyclerView.ViewHolder{

        ImageView ivLogo;
        TextView etName;
        TextView etPrevu;
        TextView tvDistanceData;
        TextView tvPhotoKol;
        ImageView ivImage;
        Button btnKolImage;

        public ExploreHolder(View itemView){
            super(itemView);

            ivLogo = itemView.findViewById(R.id.ivLogo);
            etName = itemView.findViewById(R.id.etName);
            etPrevu = itemView.findViewById(R.id.etPrevu);
            tvDistanceData = itemView.findViewById(R.id.tvDistanceData);
            tvPhotoKol = itemView.findViewById(R.id.tvPhotoKol);
            ivImage = itemView.findViewById(R.id.ivImage);
            btnKolImage = itemView.findViewById(R.id.btnKolImage);

        }

        public void bind(Explore explore){

           // explore.getResponse().getGroups().get(0).getItems().get(0).

        }

    }



}
