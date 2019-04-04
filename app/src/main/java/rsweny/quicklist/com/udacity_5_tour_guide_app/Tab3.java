package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.content.Context;
import android.net.Uri;
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


public class Tab3 extends Fragment {

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

    private void loadRestaurants() {
        placesList.add(new Place("Banyi Japanese", "Bedford Row.", 0, "Traditional decor and menu, with an extensive range of sushi, plus European desserts and sake."));
        placesList.add(new Place("Elephant & Castle", "Temple Bar.", 1, "American-style comfort such as chicken wings and burgers with breakfast and brunch menus."));
        placesList.add(new Place("Mexico to Rome", "Essex St.", 2, "Colourful restaurant and bar with modern decor and a menu of classic Mexican and Italian dishes."));
        placesList.add(new Place("Sole", "William St.", 3, "Dining in SOLE is about the full customer experience, from the moment you are greeted, eating the best seafood in Dublin, or enjoying a drink from our extensive bar and wine menu."));
        placesList.add(new Place("The Chameleon", "Fownes Street Lower.", 4, "Carved wooden tables, golden statues and fabric draped rooms give opulent feel to Indonesian menu."));
        placesList.add(new Place("Pachinos", "Suffolk St.", 5, "Pachino's aim is to provide a delicious and mouthwatering menu accessible to all. "));
        placesList.add(new Place("Millstone", "Dame St.", 6, "Upmarket restaurant with original features and a menu of refined Irish and European dishes."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }
}