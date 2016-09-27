package com.example.marcosa.myapplication;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imginicio);
        //display the logo during 5 secondes,
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                //set the new Content of your activity
                Inicio.this.setContentView(R.layout.activity_inicio);
                Tipoletra();
                //blinkTextView2();
                blinkTextView();

            }
        }.start();


    }

    public void Tipoletra(){

        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Imagica.ttf");

        TextView Play = (TextView) findViewById(R.id.Play);

        Play.setTypeface(TipoLetra);
    }

    public void blinkTextView(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;    //in milissegunds
                //noinspection EmptyCatchBlock,EmptyCatchBlock,EmptyCatchBlock,EmptyCatchBlock,EmptyCatchBlock
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView tvBlink = (TextView) findViewById(R.id.Play);
                        if(tvBlink .getVisibility() == View.VISIBLE){
                            tvBlink .setVisibility(View.INVISIBLE);
                        }else{
                            tvBlink .setVisibility(View.VISIBLE);
                        }
                        blinkTextView();
                    }
                });
            }
        }).start();
    }


    public void Jogo(View v){

        Intent myIntent = new Intent(this, jogo.class);

        startActivity(myIntent);
    }
}
