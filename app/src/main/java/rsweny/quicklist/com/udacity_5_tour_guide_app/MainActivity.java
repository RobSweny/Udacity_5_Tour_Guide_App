package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbar_textview;
    private ViewPager viewPager;

    public static final String Home = "Home";
    public static final String Pubs = "Pubs";
    public static final String Food = "Food";
    public static final String Parks = "Parks";
    public static final String Shops = "Shops";
    public static final String pubs = "pubs";
    public static final String shops = "shops";
    public static final String parks = "parks";
    public static final String position = "position";
    public static final String current_place = "current_place";
    public static final String restaurants = "restaurants";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting viewpager
        ViewPager viewPager = findViewById(R.id.pager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tablayout = findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewPager);

        // Passing the user to the second tab from the proceed button
        int defaultValue = 0;
        int page = getIntent().getIntExtra(getString(R.string.tab), defaultValue);
        viewPager.setCurrentItem(page);
    }
}
