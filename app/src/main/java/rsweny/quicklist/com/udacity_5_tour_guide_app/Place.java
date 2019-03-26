package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.widget.ImageView;

public class Place {

    public String placeName;
    public String placeLocation;
    public int placeImage;

    public Place(String placeName, String placeLocation, int placeImage) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public int getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(int placeImage) {
        this.placeImage = placeImage;
    }
}