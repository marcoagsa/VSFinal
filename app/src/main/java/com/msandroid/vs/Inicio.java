package com.msandroid.vs;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class Inicio extends AppCompatActivity {


    private Button butao;
    private ImageView Logo;
    private Animation anim, anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imginicio);


        Logo = (ImageView) findViewById(R.id.Logo);
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.conjunto_anim);
        anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        Logo.setAnimation(anim);


        //display the logo during 5 secondes,

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                //set the new Content of your activity
                Inicio.this.setContentView(R.layout.activity_inicio);
                Tipoletra();
                TextView tvBlink = (TextView) findViewById(R.id.Play);
                tvBlink.setAnimation(anim2);
            }
        }.start();

    }


    public void Tipoletra() {

        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Imagica.ttf");

        TextView Play = (TextView) findViewById(R.id.Play);

        Play.setTypeface(TipoLetra);
    }



    public void Jogo(View v) {

        Intent myIntent = new Intent(Inicio.this, jogo.class);

        startActivity(myIntent);
    }

}