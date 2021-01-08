package pl.mobile.divinumofficium;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;

import pl.mobile.divinumofficium.officium.MainBreviarium;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<ViewCardModel> modelArrayList;
    private ViewCardAdapter viewCardAdapter;
    private WormDotsIndicator wormDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        loadCards();
    }

    private void loadCards() {
         modelArrayList = new ArrayList<>();

         modelArrayList.add(new ViewCardModel(
                 "Office",
                 R.drawable.first_card
         ));

         modelArrayList.add(new ViewCardModel(
                 "Vulgata",
                 R.drawable.second_card
         ));

         modelArrayList.add(new ViewCardModel(
                 "Preces",
                 R.drawable.third_card
         ));

         viewCardAdapter = new ViewCardAdapter(this, modelArrayList);
         viewPager.setAdapter(viewCardAdapter);
         viewPager.setPadding(100,0,100,0);
         viewPager.setPageMargin(30);

         wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
         wormDotsIndicator.setViewPager(viewPager);
    }
}