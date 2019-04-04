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


public class Tab2 extends Fragment {

    public View rootView;
    private PubAdapter mAdapter;
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

        loadPubs();

        mAdapter = new PubAdapter(getContext(), placesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        place_list_recyclerview.setLayoutManager(mLayoutManager);
        place_list_recyclerview.setAdapter(mAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        place_list_recyclerview.setItemAnimator(itemAnimator);

    }

    // Loads pubs
    private void loadPubs() {
        placesList.add(new Place("After Earth", "2013", 0, "This is the description"));
        placesList.add(new Place("Baby Driver", "2017", 1, "This is the description"));
        placesList.add(new Place("After Earth", "2013", 2, "This is the description"));
        placesList.add(new Place("Baby Driver", "2017", 3, "This is the description"));
        placesList.add(new Place("After Earth", "2013", 4, "This is the description"));
        placesList.add(new Place("Baby Driver", "2017", 5, "This is the description"));
        placesList.add(new Place("Baby Driver", "2017", 6, "This is the description"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootViewB = inflater.inflate(R.layout.fragment_tab3, container, false);
        rootView = rootViewB;
        return rootViewB;
    }
}