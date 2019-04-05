package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class Tab1 extends Fragment {

    public TextView dublin_textview;
    public Button proceed_button;
    public View rootView;
    private long pressTime = -1l;
    private long releaseTime = 1l;
    private long duration = -1l;
    public ViewPager viewPager;
    private TabLayout tablayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dublin_textview = getView().findViewById(R.id.dublin_textview);
        proceed_button = getView().findViewById(R.id.proceed_button);
        viewPager = getView().findViewById(R.id.pager);
        RotateAnimation rotate = (RotateAnimation) AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        dublin_textview.setAnimation(rotate);
        tablayout = getView().findViewById(R.id.tablayout);

        proceed_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.animate().scaleXBy(0.5f).setDuration(1000).start();
                        v.animate().scaleYBy(0.5f).setDuration(1000).start();

                        pressTime = System.currentTimeMillis();
                        if (releaseTime != -1l) duration = pressTime - releaseTime;
                        break;

                    case MotionEvent.ACTION_UP:
                        releaseTime = System.currentTimeMillis();
                        duration = System.currentTimeMillis() - pressTime;
                        if (duration > 1000) {
                            int page = 1;
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.putExtra(getString(R.string.tab), page);// One is your argument
                            startActivity(intent);
                        }

                        v.animate().cancel();
                        v.animate().scaleX(1f).setDuration(500).start();
                        v.animate().scaleY(1f).setDuration(500).start();
                        break;
                } // End switch
                return true;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootViewB = inflater.inflate(R.layout.fragment_tab1, container, false);
        rootView = rootViewB;
        return rootViewB;
    }
}