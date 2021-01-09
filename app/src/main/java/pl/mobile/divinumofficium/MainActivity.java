package pl.mobile.divinumofficium;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import pl.mobile.divinumofficium.officium.MainBreviarium;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<ViewCardModel> modelArrayList;
    private ViewCardAdapter viewCardAdapter;
    private WormDotsIndicator wormDotsIndicator;
    String[] quotesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        loadCards();

        
//        Random text
        TextView textViewQuoutes = findViewById(R.id.text_quotes);

        quotesArray = getResources().getStringArray(R.array.main_act_quutes);


//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                Random random = new Random();
//                final int rand = random.nextInt(quotesArray.length);
//                textViewQuoutes.setText(quotesArray[rand]);
//            }
//        };
//
//        timer.scheduleAtFixedRate(timerTask, new Date(), 5000);
//
//        ERROR
//        Only the original thread that created a view hierarchy can touch its views



//        Handler handler = new Handler();
//        Random random = new Random();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Integer i = random.nextInt(quotesArray.length + 1);
//                textViewQuoutes.setText(quotesArray[i]);
//
//                handler.postDelayed(this, 5000);
//            }
//        };


    }

    private void loadCards() {
         modelArrayList = new ArrayList<>();

         modelArrayList.add(new ViewCardModel(
                 R.string.mainAct_Officium,
                 R.drawable.first_card
         ));

         modelArrayList.add(new ViewCardModel(
                 R.string.mainAct_Vulgata,
                 R.drawable.second_card
         ));

         modelArrayList.add(new ViewCardModel(
                 R.string.mainAct_Preces,
                 R.drawable.third_card
         ));

         viewCardAdapter = new ViewCardAdapter(this, modelArrayList);
         viewPager.setAdapter(viewCardAdapter);
         viewPager.setPadding(130,0,130,0);
         viewPager.setPageMargin(30);

         wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
         wormDotsIndicator.setViewPager(viewPager);
    }
}