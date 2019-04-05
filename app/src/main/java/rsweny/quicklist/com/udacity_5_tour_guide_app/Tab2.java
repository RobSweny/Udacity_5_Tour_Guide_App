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
        placesList.add(new Place(getString(R.string.doheny_and_nesbitt_placename), getString(R.string.doheny_and_nesbitt_locationname), 0, getString(R.string.doheny_and_nesbitt_description)));
        placesList.add(new Place(getString(R.string.hargadon_bros_placename), getString(R.string.hargadon_bros_locationname), 1, getString(R.string.hargadon_bros_description)));
        placesList.add(new Place(getString(R.string.john_benny_moriarty_placename), getString(R.string.john_benny_moriarty_locationname), 2, getString(R.string.john_benny_moriarty_description)));
        placesList.add(new Place(getString(R.string.murphys_pub_placename), getString(R.string.murphys_pub_locationname), 3, getString(R.string.murphys_pub_description)));
        placesList.add(new Place(getString(R.string.molly_mallone_placename), getString(R.string.molly_mallone_locationname), 4, getString(R.string.molly_mallone_description)));
        placesList.add(new Place(getString(R.string.mcsorleys_old_ale_house_placename), getString(R.string.mcsorleys_old_ale_house_locationname), 5, getString(R.string.mcsorleys_old_ale_house_description)));
        placesList.add(new Place(getString(R.string.the_marylebone_placename), getString(R.string.the_marylebone_locationname), 6, getString(R.string.the_marylebone_description)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootViewB = inflater.inflate(R.layout.fragment_tab3, container, false);
        rootView = rootViewB;
        return rootViewB;
    }
}