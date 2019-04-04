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
        int page = getIntent().getIntExtra("TAB", defaultValue);
        viewPager.setCurrentItem(page);
    }
}
