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
    // current place: 1 = pub, 2 = restaurant
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

        position = getIntent().getIntExtra("position", position);
        current_place = getIntent().getIntExtra("current_place", current_place);

        // 1 = pub, 2 = restaurant
        if (current_place == 1) {
            place = getIntent().getStringExtra("pubs");
            loadPubs();
        } else {
            place = getIntent().getStringExtra("restaurants");
            loadRestaurants();
        } // Check which activity to go back too

        // Load up contents of selected item
        setDescription();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // First call startActivityForResult
                // 1 = pub, 2 = restaurant
                if (current_place == 1) {
                    page = 1;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("TAB", page);
                    startActivity(intent);
                } else if (current_place == 2) {
                    page = 2;
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("TAB", page);
                    startActivity(intent);
                }
            }
        });
    } // End onCreate

    // Load up contents of selected item
    private void setDescription() {
        place_name_textview.setText(placesList.get(position).getPlaceName());
        location_name_textview.setText(placesList.get(position).getPlaceLocation());

        // 1 = pub, 2 = restaurant
        if (current_place == 1) {
            top_image_imageview.setImageResource(pubImages[position]);
        } else {
            top_image_imageview.setImageResource(restaurantImages[position]);
        } // Check which activity to go back too

        description_textview.setText(placesList.get(position).getPlaceDescription());
    }

    // Loads restaurants
    private void loadRestaurants() {
        placesList.add(new Place("Banyi Japanese", "Bedford Row.", 0, "Traditional decor and menu, with an extensive range of sushi, plus European desserts and sake."));
        placesList.add(new Place("Elephant & Castle", "Temple Bar.", 1, "American-style comfort such as chicken wings and burgers with breakfast and brunch menus."));
        placesList.add(new Place("Mexico to Rome", "Essex St.", 2, "Colourful restaurant and bar with modern decor and a menu of classic Mexican and Italian dishes."));
        placesList.add(new Place("Sole", "William St.", 3, "Dining in SOLE is about the full customer experience, from the moment you are greeted, eating the best seafood in Dublin, or enjoying a drink from our extensive bar and wine menu."));
        placesList.add(new Place("The Chameleon", "Fownes Street Lower.", 4, "Carved wooden tables, golden statues and fabric draped rooms give opulent feel to Indonesian menu."));
        placesList.add(new Place("Pachinos", "Suffolk St.", 5, "Pachino's aim is to provide a delicious and mouthwatering menu accessible to all. "));
        placesList.add(new Place("Millstone", "Dame St.", 6, "Upmarket restaurant with original features and a menu of refined Irish and European dishes."));
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

}
