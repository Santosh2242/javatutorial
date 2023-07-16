 package com.baiju.learnjavatutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

 public class MainActivity extends AppCompatActivity{

    CardView JavaTutorial, MockTest, MoreApps;
     private AdView mAdView , mAdsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JavaTutorial = findViewById(R.id.JavaTutorial);

                 JavaTutorial.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this, JavaTopics.class);
                         startActivity(intent);

                     }
                 });

        mAdsView = findViewById(R.id.adViews);
        AdRequest adRequests = new AdRequest.Builder().build();
        mAdsView.loadAd(adRequests);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
 }

