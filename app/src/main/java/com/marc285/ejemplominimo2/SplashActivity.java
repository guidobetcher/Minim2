package com.marc285.ejemplominimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

        //Load 'Diputacio de Barcelona' logo (https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg)
        Picasso.with(this).load("https://www.vectorlogo.es/wp-content/uploads/2014/12/logo-vector-diputacion-barcelona-horizontal.jpg").noFade().into(diputacioBCNlogoImageView);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean registred = sharedPref.getBoolean("registered", false);

        setContentView(R.layout.activity_splash);

        splashProgress = findViewById(R.id.splashProgressBar);
        diputacioBCNlogoImageView = findViewById(R.id.dibalogoImageView);

        Class dest;
        if(!registred){
            dest = LoginActivity.class;
        } else{
            dest = ListActivity.class;
        }

        Intent intent = new Intent(this, dest);
        startActivity(intent);
        finish();

    }
}
