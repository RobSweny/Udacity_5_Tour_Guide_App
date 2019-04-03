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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Tab2 extends Fragment {

    public View rootView;
    private PubAndRestaurantAdapter mAdapter;
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

        loadPlaces();


        mAdapter = new PubAndRestaurantAdapter(getContext(),placesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        place_list_recyclerview.setLayoutManager(mLayoutManager);
        place_list_recyclerview.setAdapter(mAdapter);


        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        place_list_recyclerview.setItemAnimator(itemAnimator);

    }

    // Loads bakery data into List<Bakery>
    private void loadPlaces() {
        placesList.add(new Place("After Earth", "2013", 1));
        placesList.add(new Place("Baby Driver", "2017", 1));
        placesList.add(new Place("After Earth", "2013", 1));
        placesList.add(new Place("Baby Driver", "2017", 1));
        placesList.add(new Place("After Earth", "2013", 1));
        placesList.add(new Place("Baby Driver", "2017", 1));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootViewB = inflater.inflate(R.layout.fragment_tab2, container, false);
        ;
        rootView = rootViewB;
        return rootViewB;
    }
}