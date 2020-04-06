package com.example.getlocation.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.getlocation.R;
import com.example.getlocation.data.models.api.Item_;

import java.util.List;

public class ExploreListAdapter extends ArrayAdapter<Item_> {

    private LayoutInflater mLayoutInflater;

    private static class ViewHolder{
        ImageView ivLogo;
        TextView tvName;
        TextView tvPrevu;
        TextView tvRast;
        ImageView ivImage;
//        TextView tvName;
//        TextView tvPoint;
//        TextView tvGenre;
//        TextView tvDistance;
//        TextView tvComment;
    }

    public ExploreListAdapter(Context context, int layout, List<Item_> objects){
        super(context, layout, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item_ item_ = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            // Lookup view for data population
//            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_item_name);
//            viewHolder.tvPoint = (TextView) convertView.findViewById(R.id.tv_list_point);
//            viewHolder.tvGenre = (TextView) convertView.findViewById(R.id.tv_item_genre);
//            viewHolder.tvDistance = (TextView) convertView.findViewById(R.id.tv_item_distance);
//            viewHolder.tvComment = (TextView) convertView.findViewById(R.id.tv_item_comment);
            viewHolder.ivLogo = (ImageView) convertView.findViewById(R.id.ivLogo);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.etName);
            viewHolder.tvPrevu = (TextView) convertView.findViewById(R.id.etPrevu);
            viewHolder.tvRast = (TextView) convertView.findViewById(R.id.tvDistanceData);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Get each data from "item_"
        String name = item_.getVenue().getName();
        String city = item_.getVenue().getLocation().getAddress();
        String genre = item_.getVenue().getCategories().get(0).getName();
        int distance = item_.getVenue().getLocation().getDistance();
        if(item_.getVenue().getPhotos().getGroups().size() > 0) {
            String image = item_.getVenue().getPhotos().getGroups().get(0).toString();
            Toast.makeText(getContext(), image, Toast.LENGTH_LONG).show();
           // viewHolder.tvComment.setText(image);
        }

        if(item_.getVenue().getCategories().size() > 0){
            String prefixSufix = "";
            prefixSufix += item_.getVenue().getCategories().get(0).getIcon().getPrefix() + "64";
            prefixSufix += item_.getVenue().getCategories().get(0).getIcon().getSuffix();
            String url = prefixSufix.replace("ss3.4sqi.net", "foursquare.com");
            String url1 = url.replace("_v2", "");
            Glide.with(convertView).load(url1).into(viewHolder.ivLogo);
        } else {
            viewHolder.ivLogo.setImageResource(R.drawable.ic_launcher_foreground);
        }

        if(item_.getVenue().getPhotos().getCount() > 0){
            String prefix = item_.getVenue().getPhotos().getGroups().get(0).toString();

        }



       // String comment = item_.getTips().get(0).getText();

        // Populate the data from the data object via the viewHolder object
        // into the template view.
//
//        viewHolder.tvName.setText(name);
//        viewHolder.tvPoint.setText(String.valueOf(point));
//        viewHolder.tvGenre.setText(genre);
//        viewHolder.tvDistance.setText(String.valueOf(distance));
        viewHolder.tvName.setText(name);
        viewHolder.tvPrevu.setText(city);
        viewHolder.tvRast.setText(String.valueOf(distance) + "M");
        // Return the completed view to render on screen
        return convertView;
    }

}
