package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PubAndRestaurantHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    private final ImageView background_image;
    private final TextView place_textview;
    private final TextView location_textview;

    private Place place;
    private Context context;

    public PubAndRestaurantHolder(Context context, View itemView) {

        super(itemView);

        // 1. Set the context
        this.context = context;

        // 2. Set up the UI widgets of the holder
        this.background_image = itemView.findViewById(R.id.background_image);
        this.place_textview = itemView.findViewById(R.id.place_textview);
        this.location_textview = itemView.findViewById(R.id.location_textview);

        // 3. Set the "onClick" listener of the holder
        itemView.setOnClickListener(this);
    }

    public void bindPlace(Place place) {

        // 4. Bind the data to the ViewHolder
        this.place = place;
        this.location_textview.setText(place.placeName);
        this.place_textview.setText(place.placeLocation);
        this.background_image.setImageResource(place.placeImage);
    }

    @Override
    public void onClick(View v) {
        // 5. Handle the onClick event for the ViewHolder
        if (this.place != null) {
            Toast.makeText(this.context, "Clicked on " + this.place.placeName, Toast.LENGTH_SHORT ).show();
        }
    }
}
