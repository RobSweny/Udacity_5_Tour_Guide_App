package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class PubAndRestaurantAdapter extends RecyclerView.Adapter<PubAndRestaurantAdapter.MyViewHolder> {

    private List<Place> places;

    private Integer[]  placeImages = {
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background,
        R.drawable.dublin_street_tab1_background
    };


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView place_textview, location_textview;
        public ImageView background_image;

        public MyViewHolder(View view) {
            super(view);
            place_textview = view.findViewById(R.id.place_textview);
            location_textview = view.findViewById(R.id.location_textview);
            location_textview = view.findViewById(R.id.location_textview);
            background_image = view.findViewById(R.id.background_image);
        }
    }


    public PubAndRestaurantAdapter(List<Place> places) {
        this.places = places;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Place place = places.get(position);
        holder.place_textview.setText(place.placeName);
        holder.location_textview.setText(place.placeLocation);
        holder.background_image.setImageResource(placeImages[position]);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
