package pl.mobile.divinumofficium;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import pl.mobile.divinumofficium.officium.MainBreviarium;
import pl.mobile.divinumofficium.preces.MainPreces;
import pl.mobile.divinumofficium.vulgata.MainVulgata;

import static androidx.core.content.ContextCompat.startActivity;

public class ViewCardAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<ViewCardModel> modelArrayList;

    public ViewCardAdapter(Context context, ArrayList<ViewCardModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cardview, container, false);

        ImageView imageCard = view.findViewById(R.id.imageCard);
        TextView titleCard = view.findViewById(R.id.cardTitle);

        ViewCardModel model = modelArrayList.get(position);
        final int title = model.getTitle();
        final int image = model.getImage();

        imageCard.setImageResource(image);
        titleCard.setText(title);

        view.setOnClickListener(v -> {

            if(model.getTitle() == R.string.mainAct_Officium) {
                Intent intent = new Intent(view.getContext(), MainBreviarium.class);
                view.getContext().startActivity(intent);

            } else if (model.getTitle() == R.string.mainAct_Vulgata) {
                Intent intent = new Intent(view.getContext(), MainVulgata.class);
                view.getContext().startActivity(intent);

            } else {
                Intent intent = new Intent(view.getContext(), MainPreces.class);
                view.getContext().startActivity(intent);
            }
        });

        container.addView(view, position);
        
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
