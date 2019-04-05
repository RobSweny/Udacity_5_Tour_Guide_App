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


public class Tab4 extends Fragment {

    public View rootView;
    private ParksAdapter mAdapter;
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

        loadParks();

        mAdapter = new ParksAdapter(getContext(), placesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        place_list_recyclerview.setLayoutManager(mLayoutManager);
        place_list_recyclerview.setAdapter(mAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        place_list_recyclerview.setItemAnimator(itemAnimator);
    }

    // Loads restaurants
    private void loadParks() {
        placesList.add(new Place(getString(R.string.st_annes_park_placename), getString(R.string.st_annes_park_locationname), 0, getString(R.string.st_annes_park_description)));
        placesList.add(new Place(getString(R.string.stephens_green_placename), getString(R.string.stephens_green_locationname), 1, getString(R.string.stephens_green_description)));
        placesList.add(new Place(getString(R.string.cabinteely_park_placename), getString(R.string.cabinteely_park_locationname), 2, getString(R.string.cabinteely_park_description)));
        placesList.add(new Place(getString(R.string.phoenix_park_placename), getString(R.string.phoenix_park_locationname), 3, getString(R.string.phoenix_park_description)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab4, container, false);
    }
}