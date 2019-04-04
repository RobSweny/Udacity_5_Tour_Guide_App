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
        placesList.add(new Place("Doheny & Nesbitt", "Baggot Street Lower", 0, "This classic pub houses 2 fine old snugs (small rooms for women in days of old) and an Irish menu."));
        placesList.add(new Place("Hargadon Bros", "O'Connell St,", 1, "Lunch at Hargadon's is always buzzing. Dinner is more elaborate but still in the casual dining category and with good value thrown in."));
        placesList.add(new Place("John Benny Moriarty", "Strand St", 2, "Music and song native to our peninsula. The words and notes of our music passed from generation to generation, father to daughter, mother to son, and in our pub, we offer visitors a glimpse at our rich heritage."));
        placesList.add(new Place("Murphy's Pub", "Rathmines Rd Upper", 3, "Murphy's Pub with its traditional open fire provides a warm contemporary setting with the character of an Irish bar full of old world charm."));
        placesList.add(new Place("Molly Mallone's", "Temple Lane", 4, "Great relaxed atmosphere in the heart of Temple Bar., great food, friendly staff . brilliant music."));
        placesList.add(new Place("McSorleys Old Ale House", "Temple Bar", 5, "Old-time bar with Irish bartenders, 2 kinds of ale (light or dark) & sawdust on the floor."));
        placesList.add(new Place("The Marylebone", "Marylebone High St,", 6, "Modern pub with extensive cocktail menu using botanical infusions, also serving artisan coffees."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootViewB = inflater.inflate(R.layout.fragment_tab3, container, false);
        rootView = rootViewB;
        return rootViewB;
    }
}