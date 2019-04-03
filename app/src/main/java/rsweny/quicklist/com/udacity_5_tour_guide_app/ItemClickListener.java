package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.view.View;

public interface ItemClickListener {
    void onClick(View view, int position, boolean isLongClick);
}