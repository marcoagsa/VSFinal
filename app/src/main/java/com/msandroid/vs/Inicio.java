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

public class Inicio extends AppCompatActivity {

    private Button butao;
    private ImageView Logo, HR, GR, AR, FR, IR, IRR, SR;
    private Animation anim, anim2, anim3, anim4, anim5, anim6, anim7, anim8, anim9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imginicio);


        Logo = findViewById( R.id.Logo );
        HR = findViewById( R.id.HR );
        GR = findViewById( R.id.GR );
        AR = findViewById( R.id.AR );
        FR = findViewById( R.id.FR );
        IR = findViewById( R.id.IR );
        IRR = findViewById( R.id.IRR );
        SR = findViewById( R.id.SR );

        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        anim4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        anim5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        anim6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        anim7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        anim8 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_2);
        anim9 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.seq_anim);

        Logo.setAnimation(anim);
        HR.setAnimation(anim3);
        GR.setAnimation(anim4);
        AR.setAnimation(anim5);
        FR.setAnimation(anim6);
        IRR.setAnimation(anim7);
        IR.setAnimation(anim8);
        SR.setAnimation(anim9);



        //display the logo during 5 secondes,

        new CountDownTimer(7000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                //set the new Content of your activity
                Inicio.this.setContentView(R.layout.activity_inicio);
                Tipoletra();
                TextView tvBlink = findViewById( R.id.Play );
                tvBlink.setAnimation(anim2);
            }
        }.start();

    }

    public void Tipoletra() {

        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Imagica.ttf");

        TextView Play = findViewById( R.id.Play );

        Play.setTypeface(TipoLetra);
    }

    public void Jogo(View v) {

        Intent myIntent = new Intent(Inicio.this, jogo.class);

        startActivity(myIntent);
    }

}