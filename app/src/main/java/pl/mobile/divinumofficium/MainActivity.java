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
import com.tomer.fadingtextview.FadingTextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import pl.mobile.divinumofficium.officium.MainBreviarium;

import static java.util.concurrent.TimeUnit.SECONDS;

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

        quotesArray = getResources().getStringArray(R.array.main_act_quotes);
        FadingTextView ftv = (FadingTextView) findViewById(R.id.text_quotes);
        ftv.setTexts(quotesArray);
        ftv.setTimeout(10, SECONDS);


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

         modelArrayList.add(new ViewCardModel(
                 R.string.calendar_title,
                 R.drawable.fourth_card
         ));

         viewCardAdapter = new ViewCardAdapter(this, modelArrayList);
         viewPager.setAdapter(viewCardAdapter);
         viewPager.setPadding(130,0,130,0);
         viewPager.setPageMargin(30);

         wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
         wormDotsIndicator.setViewPager(viewPager);
    }
}