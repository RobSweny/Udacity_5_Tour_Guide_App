package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PubAndRestaurantHolder extends RecyclerView.ViewHolder {

    private final ImageView background_image;
    private final TextView place_textview;
    private final TextView location_textview;
    private final CardView custom_item;
    private final RelativeLayout relative_card_layout;

    private Place place;
    private Context context;

    public PubAndRestaurantHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;
        this.background_image = itemView.findViewById(R.id.background_image);
        this.place_textview = itemView.findViewById(R.id.place_textview);
        this.location_textview = itemView.findViewById(R.id.location_textview);
        this.custom_item = itemView.findViewById(R.id.custom_item);
        this.relative_card_layout = itemView.findViewById(R.id.relative_card_layout);
    }

    public void bindPlace(Place place) {
        this.place = place;
        this.location_textview.setText(place.placeName);
        this.place_textview.setText(place.placeLocation);
        this.background_image.setImageResource(place.placeImage);
    }
}
