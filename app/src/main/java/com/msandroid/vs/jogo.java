package com.msandroid.vs;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class jogo extends AppCompatActivity {


    final Handler myhandler = new Handler();
    private ImageView vs, player1, player2, JP1, JP2, JP11, JP22, TM;
    private ProgressBar bar, bar2;
    private ImageButton butao;
    private TextView Coins, Bet, Fight;
    private SeekBar sk1, sk2;

    private void Tround(String mensagem) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.toast_custum));

        TextView text = (TextView) layout.findViewById(R.id.texttoast);
        text.setText(mensagem);


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.TOP, 0, 270);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


    }

    public void blinkTextView() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;    //in milissegunds
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception ignored) {
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView Fight = (TextView) findViewById(R.id.Fight);
                        if (Fight.getVisibility() == View.VISIBLE) {
                            Fight.setVisibility(View.INVISIBLE);
                        } else {
                            Fight.setVisibility(View.VISIBLE);
                        }
                        blinkTextView();
                    }
                });
            }
        }).start();
    }

    private void Bar() {

        int barvarlor = bar.getProgress();

        int valor2 = barvarlor + 50;

        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.bar);
        mProgressBar.setMax(150);

        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", barvarlor, valor2);
        progressAnimator.setDuration(1000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }

    private void Bar2() {

        int bar2Valor = bar2.getProgress();

        int valor2 = bar2Valor + 50;

        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.bar2);
        mProgressBar.setMax(150);
        mProgressBar.setRotation(180);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", bar2Valor, valor2);
        progressAnimator.setDuration(1000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }

    private void LoopMoedas() {


        final Random rand = new Random();

        final int[] Pics = {R.drawable.zero_a, R.drawable.um_a, R.drawable.dois_a, R.drawable.tres_a};
        final int[] Pics2 = {R.drawable.zero_v, R.drawable.um_v, R.drawable.dois_v, R.drawable.tres_v, R.drawable.quatro_v, R.drawable.cinco_v, R.drawable.seis_v };
        final int[] Pics3 = {R.drawable.zero_r, R.drawable.um_r, R.drawable.dois_r, R.drawable.tres_r, R.drawable.quatro_r, R.drawable.cinco_r, R.drawable.seis_r };

        myhandler.postDelayed(new Runnable() {
            public void run() {
                int randomNum = rand.nextInt(4);
                JP22.setImageResource(Pics[randomNum]);
                int randomNum2 = rand.nextInt(7);
                JP11.setImageResource(Pics2[randomNum2]);
                int randomNum3 = rand.nextInt(7);
                TM.setImageResource(Pics3[randomNum3]);
                myhandler.postDelayed(this, 50);
            }
        }, 200);

    }

    private void SeekBars() {

        sk1 = (SeekBar) findViewById(R.id.Sk1);
        sk1.setMax(3);
        sk1.setProgress(0);

        sk2 = (SeekBar) findViewById(R.id.Sk2);
        sk2.setMax(6);
        sk2.setProgress(0);
        sk2.setEnabled(false);

        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TM.setImageResource(0);
                Coins.setText("Select Your Coins = " + sk1.getProgress());

                if (sk1.getProgress() > 0 || sk1.getProgress() < 4) {
                    sk2.setProgress(sk1.getProgress());
                }
                sk2.setEnabled(true);
                LoopMoedas();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                TM.setImageResource(0);
                Coins.setText("Select Your Coins = " + sk1.getProgress());

                if (sk1.getProgress() > 0 || sk1.getProgress() < 4) {
                    sk2.setProgress(sk1.getProgress());
                }

                sk2.setEnabled(true);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TM.setImageResource(0);

                sk1.getProgress();
                if (sk1.getProgress() == 0) {
                    JP1.setImageResource(R.drawable.zero_a);
                } else if (sk1.getProgress() == 1) {
                    JP1.setImageResource(R.drawable.um_a);
                } else if (sk1.getProgress() == 2) {
                    JP1.setImageResource(R.drawable.dois_a);
                } else if (sk1.getProgress() == 3) {
                    JP1.setImageResource(R.drawable.tres_a);
                }

                sk2.getProgress();
                if (sk2.getProgress() == 0) {
                    JP2.setImageResource(R.drawable.zero_v);
                } else if (sk2.getProgress() == 1) {
                    JP2.setImageResource(R.drawable.um_v);
                } else if (sk2.getProgress() == 2) {
                    JP2.setImageResource(R.drawable.dois_v);
                } else if (sk2.getProgress() == 3) {
                    JP2.setImageResource(R.drawable.tres_v);
                }else if (sk2.getProgress() == 4) {
                    JP2.setImageResource(R.drawable.quatro_v);
                }else if (sk2.getProgress() == 5) {
                    JP2.setImageResource(R.drawable.cinco_v);
                }else if (sk2.getProgress() == 6) {
                    JP2.setImageResource(R.drawable.seis_v);
                }
            }
        });

        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                TM.setImageResource(0);
                butao.setEnabled(false);
                Fight.setVisibility(View.INVISIBLE);

                Bet.setText("Select Your Bet = " + sk2.getProgress());

                if (sk2.getProgress() < sk1.getProgress()) {
                    sk1.setProgress(sk2.getProgress());
                    butao.setEnabled(false);
                    Fight.setVisibility(View.INVISIBLE);
                } else if (sk2.getProgress() > 3 && sk1.getProgress() < 1) {
                    sk1.setProgress(1);
                } else if (sk2.getProgress() == 5 && sk1.getProgress() != 3) {
                    sk1.setProgress(2);
                    butao.setEnabled(true);
                    Fight.setVisibility(View.VISIBLE);
                } else if (sk2.getProgress() == 6) {
                    sk1.setProgress(3);
                    butao.setEnabled(true);
                    Fight.setVisibility(View.VISIBLE);
                }
                butao.setEnabled(true);
                Fight.setVisibility(View.VISIBLE);
                LoopMoedas();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                sk1.getProgress();
                if (sk1.getProgress() == 0) {
                    JP1.setImageResource(R.drawable.zero_a);
                } else if (sk1.getProgress() == 1) {
                    JP1.setImageResource(R.drawable.um_a);
                } else if (sk1.getProgress() == 2) {
                    JP1.setImageResource(R.drawable.dois_a);
                } else if (sk1.getProgress() == 3) {
                    JP1.setImageResource(R.drawable.tres_a);
                }

                sk2.getProgress();
                if (sk2.getProgress() == 0) {
                    JP2.setImageResource(R.drawable.zero_v);
                } else if (sk2.getProgress() == 1) {
                    JP2.setImageResource(R.drawable.um_v);
                } else if (sk2.getProgress() == 2) {
                    JP2.setImageResource(R.drawable.dois_v);
                } else if (sk2.getProgress() == 3) {
                    JP2.setImageResource(R.drawable.tres_v);
                }else if (sk2.getProgress() == 4) {
                    JP2.setImageResource(R.drawable.quatro_v);
                }else if (sk2.getProgress() == 5) {
                    JP2.setImageResource(R.drawable.cinco_v);
                }else if (sk2.getProgress() == 6) {
                    JP2.setImageResource(R.drawable.seis_v);
                }
            }

        });
    }

    public void Tipoletra(TextView NP) {

        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Imagica.ttf");

    }

    private ImageView SelectPlayer2(ImageView player2) {

        Random rand = new Random();

        int p2 = rand.nextInt(8);

        switch (p2) {
            case 0:
                jogo.this.player2.setImageResource(R.drawable.happy_robot);
                Tround("VS");
                Tround("Happy Robot");
                break;
            case 1:
                jogo.this.player2.setImageResource(R.drawable.girl_android);
                Tround("VS");
                Tround("Girl Android");
                break;
            case 2:
                jogo.this.player2.setImageResource(R.drawable.atomic_robot);
                Tround("VS");
                Tround("Atomic Robot");
                break;
            case 3:
                jogo.this.player2.setImageResource(R.drawable.little_robot);
                Tround("VS");
                Tround("Little Robot");
                break;
            case 4:
                jogo.this.player2.setImageResource(R.drawable.flying_robot);
                Tround("VS");
                Tround("Flyin Robot");
                break;
            case 5:
                jogo.this.player2.setImageResource(R.drawable.ironclad_robot);
                Tround("VS");
                Tround("Iron Clad");
                break;
            case 6:
                jogo.this.player2.setImageResource(R.drawable.insect_robot);
                Tround("VS");
                Tround("Insect Robot");
                break;
            case 7:
                jogo.this.player2.setImageResource(R.drawable.scorpio_robot);
                Tround("VS");
                Tround("Scorpio");
                break;
        }
        return player2;

    }

    private void Splayer(final ImageView player1) {


        final Dialog teste = new Dialog(this);
        teste.setTitle(R.string.Select);
        teste.setContentView(R.layout.activity_splayer);
        teste.show();

        ImageButton SE = (ImageButton) teste.findViewById(R.id.SE);
        ImageButton SD = (ImageButton) teste.findViewById(R.id.SD);
        final TextView NP = (TextView) teste.findViewById(R.id.NPlayer);
        final ImageButton SP = (ImageButton) teste.findViewById(R.id.SP);


        SP.setImageResource(R.drawable.happy_robot);
        NP.setText("Happy Robot");


        final int[] i = {0};


        SE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i[0]--;

                if (i[0] == 0) {
                    SP.setImageResource(R.drawable.happy_robot);
                    NP.setText("Happy Robot");
                } else if (i[0] == 1) {
                    SP.setImageResource(R.drawable.girl_android);
                    NP.setText("Girl Android");
                } else if (i[0] == 2) {
                    SP.setImageResource(R.drawable.atomic_robot);
                    NP.setText("Atomic Robot");
                } else if (i[0] == 3) {
                    SP.setImageResource(R.drawable.little_robot);
                    NP.setText("Little Robot");
                } else if (i[0] == 4) {
                    SP.setImageResource(R.drawable.flying_robot);
                    NP.setText("Flying Robot");
                } else if (i[0] == 5) {
                    SP.setImageResource(R.drawable.ironclad_robot);
                    NP.setText("Iron Clab");
                } else if (i[0] == 6) {
                    SP.setImageResource(R.drawable.insect_robot);
                    NP.setText("Insect Robot");
                } else if (i[0] == 7 || i[0] < 0) {
                    SP.setImageResource(R.drawable.scorpio_robot);
                    NP.setText("Scorpio Robot");
                    i[0] = 7;
                } else {
                    i[0] = 10;
                }

                Log.d("Mylog", String.valueOf(i[0]));
            }
        });

        SD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i[0]++;

                if (i[0] == 0) {
                    SP.setImageResource(R.drawable.happy_robot);
                    NP.setText("Happy Robot");
                } else if (i[0] == 1) {
                    SP.setImageResource(R.drawable.girl_android);
                    NP.setText("Girl Android");
                } else if (i[0] == 2) {
                    SP.setImageResource(R.drawable.atomic_robot);
                    NP.setText("Atomic Robot");
                } else if (i[0] == 3) {
                    SP.setImageResource(R.drawable.little_robot);
                    NP.setText("Little Robot");
                } else if (i[0] == 4) {
                    SP.setImageResource(R.drawable.flying_robot);
                    NP.setText("Flying Robot");
                } else if (i[0] == 5) {
                    SP.setImageResource(R.drawable.ironclad_robot);
                    NP.setText("Iron Clab");
                } else if (i[0] == 6) {
                    SP.setImageResource(R.drawable.insect_robot);
                    NP.setText("Insect Robot");
                } else if (i[0] == 7 || i[0] > 7) {
                    SP.setImageResource(R.drawable.scorpio_robot);
                    NP.setText("Scorpio Robot");
                    i[0] = -1;
                } else {
                    i[0] = -11;
                }
                Log.d("Mylog", String.valueOf(i[0]));
            }
        });


        SP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogo.this.player1.setImageDrawable(SP.getDrawable());
                jogo.this.Tround((String) NP.getText());
                SelectPlayer2(player2);
                teste.cancel();
                LoopMoedas();
            }
        });
    }

    private void Final() {

        bar.getProgress();
        bar2.getProgress();

        if (bar.getProgress() == 150 || bar2.getProgress() == 150) {

            Dialog Dfinal = new Dialog(jogo.this);
            Dfinal.setTitle(" Game Over ");
            Dfinal.setContentView(R.layout.custom_toast);
            Dfinal.show();
        }

    }

    private void Verifica() {

        myhandler.removeCallbacksAndMessages(null);

        butao.setEnabled(false);
        Fight.setVisibility(View.INVISIBLE);

        Random Rand = new Random();

        int MA = Rand.nextInt(4);

        switch (MA) {
            case 0:
                jogo.this.JP22.setImageResource(R.drawable.zero_a);
                break;
            case 1:
                jogo.this.JP22.setImageResource(R.drawable.um_a);
                break;
            case 2:
                jogo.this.JP22.setImageResource(R.drawable.dois_a);
                break;
            case 3:
                jogo.this.JP22.setImageResource(R.drawable.tres_a);
                break;
        }

        int MJ = sk1.getProgress();
        int ABet = MA + Rand.nextInt(4);

        switch (ABet) {
            case 0:
                jogo.this.JP11.setImageResource(R.drawable.zero_v);
                break;
            case 1:
                jogo.this.JP11.setImageResource(R.drawable.um_v);
                break;
            case 2:
                jogo.this.JP11.setImageResource(R.drawable.dois_v);
                break;
            case 3:
                jogo.this.JP11.setImageResource(R.drawable.tres_v);
                break;
            case 4:
                jogo.this.JP11.setImageResource(R.drawable.quatro_v);
                break;
            case 5:
                jogo.this.JP11.setImageResource(R.drawable.cinco_v);
                break;
            case 6:
                jogo.this.JP11.setImageResource(R.drawable.seis_v);
                break;
        }



        int HBet = sk2.getProgress();
        int totalmoedas = MA + MJ;

        switch (totalmoedas) {
            case 0:
                jogo.this.TM.setImageResource(R.drawable.zero_r);
                break;
            case 1:
                jogo.this.TM.setImageResource(R.drawable.um_r);
                break;
            case 2:
                jogo.this.TM.setImageResource(R.drawable.dois_r);
                break;
            case 3:
                jogo.this.TM.setImageResource(R.drawable.tres_r);
                break;
            case 4:
                jogo.this.TM.setImageResource(R.drawable.quatro_r);
                break;
            case 5:
                jogo.this.TM.setImageResource(R.drawable.cinco_r);
                break;
            case 6:
                jogo.this.TM.setImageResource(R.drawable.seis_r);
                break;
        }


        if (HBet == totalmoedas) {
            Tround("You Win !!!!");
            Bar2();
            Final();
        } else if (ABet == totalmoedas) {
            Tround("You Lose !!!!");
            Bar();
            Final();
        } else {
            Tround("OH!!! Ninguem Ganhou");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        vs = (ImageView) findViewById(R.id.vs);
        player1 = (ImageView) findViewById(R.id.Player1);
        player2 = (ImageView) findViewById(R.id.Player2);
        JP1 = (ImageView) findViewById(R.id.JP1);
        JP2 = (ImageView) findViewById(R.id.JP2);
        JP11 = (ImageView) findViewById(R.id.JP11);
        JP22 = (ImageView) findViewById(R.id.JP22);
        TM = (ImageView) findViewById(R.id.TotalMoedas);
        Coins = (TextView) findViewById(R.id.Coins);
        Bet = (TextView) findViewById(R.id.Bet);
        Fight = (TextView) findViewById(R.id.Fight);
        butao = (ImageButton) findViewById(R.id.butao);
        bar = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);

        butao.setEnabled(false);
        Tipoletra(Fight);
        Fight.setVisibility(View.INVISIBLE);

        Splayer(player1);

        SeekBars();


        butao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Verifica();
            }
        });

    }
}

