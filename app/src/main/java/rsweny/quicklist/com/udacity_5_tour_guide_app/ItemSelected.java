package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemSelected extends AppCompatActivity {
    // Declarations
    private Button back_button;
    private ImageView top_image_imageview;
    private TextView place_name_textview, location_name_textview, description_textview;

    // Variables
    // current place: 1 = pub, 2 = restaurant, 3 = parks, 4 = shops
    private int position, current_place, page;
    private String place;

    private List<Place> placesList = new ArrayList<>();

    private Integer[] pubImages = {
            R.drawable.pub_1,
            R.drawable.pub_2,
            R.drawable.pub_3,
            R.drawable.pub_4,
            R.drawable.pub_5,
            R.drawable.pub_6,
            R.drawable.pub_7
    };

    private Integer[] restaurantImages = {
            R.drawable.restaurant_1,
            R.drawable.restaurant_2,
            R.drawable.restaurant_3,
            R.drawable.restaurant_4,
            R.drawable.restaurant_5,
            R.drawable.restaurant_6,
            R.drawable.restaurant_7
    };

    private Integer[] parkImages = {
            R.drawable.st_annes_park,
            R.drawable.stephens_green,
            R.drawable.cabinteely_park,
            R.drawable.pheonix_park
    };

    private Integer[] shopImages = {
            R.drawable.st_annes_park,
            R.drawable.stephens_green,
            R.drawable.cabinteely_park,
            R.drawable.pheonix_park
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_selected);

        // Initialize
        back_button = findViewById(R.id.back_button);
        top_image_imageview = findViewById(R.id.top_image_imageview);
        place_name_textview = findViewById(R.id.place_name_textview);
        location_name_textview = findViewById(R.id.location_name_textview);
        description_textview = findViewById(R.id.description_textview);

        current_place = 0;
        position = 0;

        position = getIntent().getIntExtra(MainActivity.position, position);
        current_place = getIntent().getIntExtra(MainActivity.current_place, current_place);

        // 1 = pub, 2 = restaurant
        if (current_place == 1) {
            place = getIntent().getStringExtra(getString(R.string.pubs_get_intent));
            loadPubs();
        } else if (current_place == 2) {
            place = getIntent().getStringExtra(getString(R.string.restaurants_get_intent));
            loadRestaurants();
        } else if (current_place == 3) {
            place = getIntent().getStringExtra(getString(R.string.parks));
            loadParks();
        } else if (current_place == 4) {
            place = getIntent().getStringExtra(getString(R.string.shops));
            loadShops();
        } // Check which activity to go back too

        // Load up contents of selected item
        setDescription();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // First call startActivityForResult
                // current place: 1 = pub, 2 = restaurant, 3 = parks, 4 = shops
                if (current_place == 1) {
                    page = 1;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra(getString(R.string.tab), page);
                    startActivity(intent);
                } else if (current_place == 2) {
                    page = 2;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra(getString(R.string.tab), page);
                    startActivity(intent);
                } else if (current_place == 3) {
                    page = 3;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra(getString(R.string.tab), page);
                    startActivity(intent);
                } else if (current_place == 4) {
                    page = 4;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra(getString(R.string.tab), page);
                    startActivity(intent);
                }
            }
        });
    } // End onCreate

    // Load up contents of selected item
    private void setDescription() {
        place_name_textview.setText(placesList.get(position).getPlaceName());
        location_name_textview.setText(placesList.get(position).getPlaceLocation());

        // current place: 1 = pub, 2 = restaurant, 3 = parks, 4 = shops
        if (current_place == 1) {
            top_image_imageview.setImageResource(pubImages[position]);
        } else if (current_place == 2) {
            top_image_imageview.setImageResource(restaurantImages[position]);
        } else if (current_place == 3) {
            top_image_imageview.setImageResource(parkImages[position]);
        } else if (current_place == 4)  {
                    top_image_imageview.setImageResource(shopImages[position]);
        } // Check which activity to go back too

        description_textview.setText(placesList.get(position).getPlaceDescription());
    }

    // Loads parks
    private void loadParks() {
        placesList.add(new Place("a", "a", 0, "a"));
        placesList.add(new Place("a", "a", 1, "a"));
        placesList.add(new Place("a", "a", 2, "a"));
        placesList.add(new Place("a", "a", 3, "a"));
    }

    // Loads shops
    private void loadShops() {
        placesList.add(new Place("a", "a", 0, "a"));
        placesList.add(new Place("a", "a", 1, "a"));
        placesList.add(new Place("a", "a", 2, "a"));
        placesList.add(new Place("a", "a", 3, "a"));
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
}
