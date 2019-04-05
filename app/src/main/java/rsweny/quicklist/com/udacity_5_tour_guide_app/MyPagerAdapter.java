package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();
            case 4:
                return new Tab5();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return MainActivity.Home;
            case 1:
                return MainActivity.Pubs;
            case 2:
                return MainActivity.Food;
            case 3:
                return MainActivity.Parks;
            case 4:
                return MainActivity.Shops;
            default:
                return null;
        }
    }


}