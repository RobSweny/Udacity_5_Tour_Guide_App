package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Tab5 extends Fragment {

    public View rootView;
    private RestaurantAdapter mAdapter;
    private ListView listingsView;
    private List<Place> places;
    private List<Place> placesList = new ArrayList<>();
    private RecyclerView place_list_recyclerview;
    private ImageView background_image;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initializing views
        place_list_recyclerview = getView().findViewById(R.id.place_list_recyclerview);
        background_image = getView().findViewById(R.id.background_image);

        loadRestaurants();

        mAdapter = new RestaurantAdapter(getContext(), placesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        place_list_recyclerview.setLayoutManager(mLayoutManager);
        place_list_recyclerview.setAdapter(mAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        place_list_recyclerview.setItemAnimator(itemAnimator);
    }

    // Loads restaurants
    private void loadRestaurants() {
        placesList.add(new Place(getString(R.string.banyi_japanese_placename), getString(R.string.banyi_japanese_locationname), 0, getString(R.string.banyi_japanese_description)));
        placesList.add(new Place(getString(R.string.elephant_and_castle_placename), getString(R.string.elephant_and_castle_locationname), 1, getString(R.string.elephant_and_castle_description)));
        placesList.add(new Place(getString(R.string.mexico_to_rome_placename), getString(R.string.mexico_to_rome_locationname), 2, getString(R.string.location_description)));
        placesList.add(new Place(getString(R.string.sole_placename), getString(R.string.sole_locationname), 3, getString(R.string.sole_description)));
        placesList.add(new Place(getString(R.string.the_chameleon_placename), getString(R.string.the_chameleon_locationname), 4, getString(R.string.the_chameleon_description)));
        placesList.add(new Place(getString(R.string.pachinos_placename), getString(R.string.pachinos_locationname), 5, getString(R.string.pachinos_description)));
        placesList.add(new Place(getString(R.string.millstone_placename), getString(R.string.millstone_locationname), 6, getString(R.string.millstone_description)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab5, container, false);
    }
}