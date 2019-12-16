package com.marc285.ejemplominimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar splashProgress;
    private ImageView diputacioBCNlogoImageView;
    //Context context; //In order to open the new Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashProgress = findViewById(R.id.splashProgressBar);
        diputacioBCNlogoImageView = findViewById(R.id.dibalogoImageView);

        //Load 'Diputacio de Barcelona' logo (https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg)
        Picasso.with(this).load("https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg").noFade().into(diputacioBCNlogoImageView);

        //We will open the new Activity when 'loading time' is finished
        Random r = new Random();
        int loadtime = (r.nextInt(11 - 6) + 6); //Bounded load time (prudential time to let Picasso load pictures) between 6 and 10 seconds

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Open the ListActivity
                Intent intent = new Intent (getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        }, 1000*loadtime);

    }
}
