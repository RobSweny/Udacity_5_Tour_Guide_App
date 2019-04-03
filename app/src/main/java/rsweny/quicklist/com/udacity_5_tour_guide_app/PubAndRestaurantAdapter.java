package rsweny.quicklist.com.udacity_5_tour_guide_app;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PubAndRestaurantAdapter extends RecyclerView.Adapter<PubAndRestaurantAdapter.MyViewHolder> {


    private List<Place> places;
    private Context context;
    private RecyclerView place_list_recyclerview;

    private Integer[] placeImages = {
            R.drawable.pub_1,
            R.drawable.pub_2,
            R.drawable.pub_3,
            R.drawable.pub_4,
            R.drawable.pub_5,
            R.drawable.pub_6,
            R.drawable.pub_7
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView place_textview, location_textview, item_description;
        public ImageView background_image;
        public CardView custom_item;
        private ItemClickListener clickListener;
        public RelativeLayout relative_card_layout;


        public MyViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);

            place_textview = view.findViewById(R.id.place_textview);
            location_textview = view.findViewById(R.id.location_textview);
            location_textview = view.findViewById(R.id.location_textview);
            background_image = view.findViewById(R.id.background_image);
            custom_item = view.findViewById(R.id.custom_item);
            relative_card_layout = view.findViewById(R.id.relative_card_layout);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }
    }

    public PubAndRestaurantAdapter(Context context, List<Place> places) {
        this.places = places;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Place place = places.get(position);

        holder.place_textview.setText(place.placeName);
        holder.location_textview.setText(place.placeLocation);
        holder.background_image.setImageResource(placeImages[position]);
        animate(holder);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(context, "Position: " + String.valueOf(place.placeName), Toast.LENGTH_SHORT).show();
                holder.relative_card_layout.getLayoutParams().height += 180;
            }
        });
    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
