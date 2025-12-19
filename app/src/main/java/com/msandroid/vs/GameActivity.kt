package com.msandroid.vs

import android.animation.ObjectAnimator
import android.app.Dialog
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView
import java.util.*

class GameActivity : AppCompatActivity() {

    private lateinit var player1: ImageView
    private lateinit var player2: ImageView
    private lateinit var jp1: ImageView
    private lateinit var jp2: ImageView
    private lateinit var jp11: ImageView
    private lateinit var jp22: ImageView
    private lateinit var tm: ImageView
    private lateinit var jogador: ImageView
    private lateinit var coins: TextView
    private lateinit var bet: TextView
    private lateinit var fight: TextView
    private lateinit var moedasBet: TextView
    private lateinit var moedas: TextView
    private lateinit var tt: TextView
    private lateinit var tt2: TextView
    private lateinit var tv: TextView
    private lateinit var sf: TextView
    private lateinit var bar: ProgressBar
    private lateinit var bar2: ProgressBar
    private lateinit var butao: ImageButton
    private lateinit var butaoOK: Button
    private lateinit var wtf: Drawable
    private lateinit var sk1: SeekBar
    private lateinit var sk2: SeekBar
    private lateinit var gif: GifImageView
    private lateinit var ataques: GifImageView

    private var tentativas = 0
    private var vh = 0
    private var va = 0
    private var statusFinal = 0

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        initViews()
        setupTypographies()
        setupSeekBars()
        splayer()
    }

    private fun initViews() {
        player1 = findViewById(R.id.Player1)
        player2 = findViewById(R.id.Player2)
        jp1 = findViewById(R.id.JP1)
        jp2 = findViewById(R.id.JP2)
        jp11 = findViewById(R.id.JP11)
        jp22 = findViewById(R.id.JP22)
        tm = findViewById(R.id.TotalMoedas)
        moedas = findViewById(R.id.Moedas)
        moedasBet = findViewById(R.id.MoedasBet)
        coins = findViewById(R.id.Coins)
        bet = findViewById(R.id.Bet)
        fight = findViewById(R.id.Fight)
        butao = findViewById(R.id.butao)
        bar = findViewById(R.id.bar)
        bar2 = findViewById(R.id.bar2)
        gif = findViewById(R.id.Gif)
        ataques = findViewById(R.id.Ataques)

        butao.isEnabled = false
        fight.visibility = View.INVISIBLE
    }

    private fun setupTypographies() {
        val tipoLetra = Typeface.createFromAsset(assets, "Imagica.ttf")
        fight.typeface = tipoLetra
        coins.typeface = tipoLetra
        bet.typeface = tipoLetra
        moedasBet.typeface = tipoLetra
        moedas.typeface = tipoLetra
    }

    private fun selectPlayer2() {
        val rand = Random()

        val fundos = listOf(
            R.drawable.arenafogo, R.drawable.arenalouca, R.drawable.arenatailandia,
            R.drawable.arenaagua, R.drawable.arenabar, R.drawable.arenacampo,
            R.drawable.arenadeserto, R.drawable.arenajapao
        )

        gif.setBackgroundResource(fundos[rand.nextInt(fundos.size)])

        when (rand.nextInt(8)) {
            0 -> {
                player2.setImageResource(R.drawable.happy_robot)
                tround(R.string.app_name)
                tround(R.string.HR)
            }
            1 -> {
                player2.setImageResource(R.drawable.girl_android)
                tround(R.string.app_name)
                tround(R.string.GR)
            }
            2 -> {
                player2.setImageResource(R.drawable.atomic_robot)
                tround(R.string.app_name)
                tround(R.string.AR)
            }
            3 -> {
                player2.setImageResource(R.drawable.little_robot)
                tround(R.string.app_name)
                tround(R.string.LR)
            }
            4 -> {
                player2.setImageResource(R.drawable.flying_robot)
                tround(R.string.app_name)
                tround(R.string.FR)
            }
            5 -> {
                player2.setImageResource(R.drawable.ironclad_robot)
                tround(R.string.app_name)
                tround(R.string.IC)
            }
            6 -> {
                player2.setImageResource(R.drawable.insect_robot)
                tround(R.string.app_name)
                tround(R.string.IR)
            }
            7 -> {
                player2.setImageResource(R.drawable.scorpio_robot)
                tround(R.string.app_name)
                tround(R.string.SR)
            }
        }
    }

    private fun splayer() {
        val escolheJogador = Dialog(this).apply {
            setTitle(R.string.Select)
            setContentView(R.layout.activity_splayer)
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            show()
        }

        val tipoLetra = Typeface.createFromAsset(assets, "Imagica.ttf")

        val se = escolheJogador.findViewById<ImageButton>(R.id.SE)
        val sd = escolheJogador.findViewById<ImageButton>(R.id.SD)
        val np = escolheJogador.findViewById<TextView>(R.id.NPlayer)
        val selectP = escolheJogador.findViewById<TextView>(R.id.SelectP)
        val sp = escolheJogador.findViewById<ImageButton>(R.id.SP)

        np.typeface = tipoLetra
        selectP.typeface = tipoLetra
        sp.setImageResource(R.drawable.happy_robot)
        np.setText(R.string.HR)

        var currentIndex = 0

        se.setOnClickListener {
            currentIndex--

            when {
                currentIndex == 0 -> {
                    sp.setImageResource(R.drawable.happy_robot)
                    np.setText(R.string.HR)
                }
                currentIndex == 1 -> {
                    sp.setImageResource(R.drawable.girl_android)
                    np.setText(R.string.GR)
                }
                currentIndex == 2 -> {
                    sp.setImageResource(R.drawable.atomic_robot)
                    np.setText(R.string.AR)
                }
                currentIndex == 3 -> {
                    sp.setImageResource(R.drawable.little_robot)
                    np.setText(R.string.LR)
                }
                currentIndex == 4 -> {
                    sp.setImageResource(R.drawable.flying_robot)
                    np.setText(R.string.FR)
                }
                currentIndex == 5 -> {
                    sp.setImageResource(R.drawable.ironclad_robot)
                    np.setText(R.string.IC)
                }
                currentIndex == 6 -> {
                    sp.setImageResource(R.drawable.insect_robot)
                    np.setText(R.string.IR)
                }
                currentIndex == 7 || currentIndex < 0 -> {
                    sp.setImageResource(R.drawable.scorpio_robot)
                    np.setText(R.string.SR)
                    currentIndex = 7
                }
                else -> currentIndex = 10
            }
        }

        sd.setOnClickListener {
            currentIndex++

            when {
                currentIndex == 0 || currentIndex == 8 -> {
                    sp.setImageResource(R.drawable.happy_robot)
                    np.setText(R.string.HR)
                    currentIndex = 1
                }
                currentIndex == 1 -> {
                    sp.setImageResource(R.drawable.girl_android)
                    np.setText(R.string.GR)
                }
                currentIndex == 2 -> {
                    sp.setImageResource(R.drawable.atomic_robot)
                    np.setText(R.string.AR)
                }
                currentIndex == 3 -> {
                    sp.setImageResource(R.drawable.little_robot)
                    np.setText(R.string.LR)
                }
                currentIndex == 4 -> {
                    sp.setImageResource(R.drawable.flying_robot)
                    np.setText(R.string.FR)
                }
                currentIndex == 5 -> {
                    sp.setImageResource(R.drawable.ironclad_robot)
                    np.setText(R.string.IR)
                }
                currentIndex == 6 -> {
                    sp.setImageResource(R.drawable.insect_robot)
                    np.setText(R.string.IR)
                }
                currentIndex == 7 -> {
                    sp.setImageResource(R.drawable.scorpio_robot)
                    np.setText(R.string.SR)
                    currentIndex = -1
                }
                else -> currentIndex = -11
            }
        }

        sp.setOnClickListener {
            player1.setImageDrawable(sp.drawable)
            wtf = sp.drawable
            tround2(np.text.toString())
            selectPlayer2()
            escolheJogador.dismiss()
            loopMoedas()
        }
    }

    private fun tround(mensagem: Int) {
        showCustomToast(getString(mensagem))
    }

    private fun tround2(mensagem: String) {
        showCustomToast(mensagem)
    }

    private fun showCustomToast(mensagem: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast,
            findViewById<ViewGroup>(R.id.toast_custum))

        val text = layout.findViewById<TextView>(R.id.texttoast)
        text.text = mensagem

        Toast(applicationContext).apply {
            setGravity(Gravity.CENTER_VERTICAL or Gravity.TOP, 0, 270)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }

    private fun bar() {
        val barValor = bar.progress
        val valor2 = barValor + 50

        bar.max = 150

        ObjectAnimator.ofInt(bar, "progress", barValor, valor2).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            start()
        }
    }

    private fun bar2() {
        val bar2Valor = bar2.progress
        val valor2 = bar2Valor + 50

        bar2.max = 150
        bar2.rotation = 180f

        ObjectAnimator.ofInt(bar2, "progress", bar2Valor, valor2).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            start()
        }
    }

    private fun loopMoedas() {
        val rand = Random()

        val pics = listOf(
            R.drawable.zero_a, R.drawable.um_a, R.drawable.dois_a, R.drawable.tres_a
        )

        val pics2 = listOf(
            R.drawable.zero_v, R.drawable.um_v, R.drawable.dois_v, R.drawable.tres_v,
            R.drawable.quatro_v, R.drawable.cinco_v, R.drawable.seis_v
        )

        val pics3 = listOf(
            R.drawable.zero_r, R.drawable.um_r, R.drawable.dois_r, R.drawable.tres_r,
            R.drawable.quatro_r, R.drawable.cinco_r, R.drawable.seis_r
        )

        val runnable = object : Runnable {
            override fun run() {
                jp22.setImageResource(pics[rand.nextInt(pics.size)])
                jp11.setImageResource(pics2[rand.nextInt(pics2.size)])
                tm.setImageResource(pics3[rand.nextInt(pics3.size)])
                handler.postDelayed(this, 50)
            }
        }

        handler.postDelayed(runnable, 200)
    }

    private fun setupSeekBars() {
        sk1 = findViewById(R.id.Sk1)
        sk2 = findViewById(R.id.Sk2)

        sk1.max = 3
        sk1.progress = 0

        sk2.max = 6
        sk2.progress = 0
        sk2.isEnabled = false

        sk1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tm.setImageResource(0)
                ataques.setImageResource(0)
                moedas.text = " = $progress"

                if (progress in 0..3) {
                    sk2.progress = progress
                }
                sk2.isEnabled = true
                loopMoedas()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                tm.setImageResource(0)
                ataques.setImageResource(0)
                moedas.text = " = ${sk1.progress}"

                if (sk1.progress in 0..3) {
                    sk2.progress = sk1.progress
                }
                sk2.isEnabled = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                tm.setImageResource(0)
                ataques.setImageResource(0)

                updateImageBasedOnProgress(jp1, sk1.progress, jp1Images)
                updateImageBasedOnProgress(jp2, sk2.progress, jp2Images)
            }
        })

        sk2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tm.setImageResource(0)
                ataques.setImageResource(0)
                butao.isEnabled = false
                fight.visibility = View.INVISIBLE
                moedasBet.text = " = $progress"

                when {
                    progress < sk1.progress -> {
                        sk1.progress = progress
                        butao.isEnabled = false
                        fight.visibility = View.INVISIBLE
                    }
                    progress > 3 && sk1.progress < 1 -> sk1.progress = 1
                    progress == 5 && sk1.progress != 3 -> sk1.progress = 2
                    progress == 6 -> sk1.progress = 3
                }

                butao.isEnabled = true
                fight.visibility = View.VISIBLE
                loopMoedas()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                updateImageBasedOnProgress(jp1, sk1.progress, jp1Images)
                updateImageBasedOnProgress(jp2, sk2.progress, jp2Images)
            }
        })

        butao.setOnClickListener {
            verifica()
        }
    }

    private val jp1Images = mapOf(
        0 to R.drawable.zero_a,
        1 to R.drawable.um_a,
        2 to R.drawable.dois_a,
        3 to R.drawable.tres_a
    )

    private val jp2Images = mapOf(
        0 to R.drawable.zero_v,
        1 to R.drawable.um_v,
        2 to R.drawable.dois_v,
        3 to R.drawable.tres_v,
        4 to R.drawable.quatro_v,
        5 to R.drawable.cinco_v,
        6 to R.drawable.seis_v
    )

    private fun updateImageBasedOnProgress(imageView: ImageView, progress: Int, imageMap: Map<Int, Int>) {
        imageMap[progress]?.let { imageView.setImageResource(it) }
    }

    private fun verifica() {
        handler.removeCallbacksAndMessages(null)
        butao.isEnabled = false
        fight.visibility = View.INVISIBLE

        val rand = Random()
        val mj = sk1.progress
        val hBet = sk2.progress
        val ma = rand.nextInt(4)

        // Atualizar imagem JP22
        val maImages = listOf(
            R.drawable.zero_a, R.drawable.um_a, R.drawable.dois_a, R.drawable.tres_a
        )
        jp22.setImageResource(maImages[ma])

        val totalMoedas = ma + mj

        // Atualizar imagem TM
        val totalImages = listOf(
            R.drawable.zero_v, R.drawable.um_v, R.drawable.dois_v, R.drawable.tres_v,
            R.drawable.quatro_v, R.drawable.cinco_v, R.drawable.seis_v
        )
        tm.setImageResource(totalImages.getOrElse(totalMoedas) { R.drawable.zero_v })

        var aBet = ma + rand.nextInt(4)
        while (aBet == hBet) {
            Toast.makeText(baseContext, "Aposto Igual !!!", Toast.LENGTH_LONG).show()
            aBet = ma + rand.nextInt(4)
        }

        // Atualizar imagem JP11
        jp11.setImageResource(totalImages.getOrElse(aBet) { R.drawable.zero_v })

        val vAtaques = listOf(
            R.drawable.ataqueexplosao, R.drawable.tornado, R.drawable.torvoada2
        )

        val vAtaques2 = listOf(
            R.drawable.fogoexplosao, R.drawable.ataquechama
        )

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.move_2)
        val anim2 = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_down)

        when {
            hBet == totalMoedas -> {
                tround(R.string.YW)
                bar2()
                ataques.setImageResource(vAtaques[rand.nextInt(vAtaques.size)])
                ataques.startAnimation(anim)
                tentativas++
                vh++
            }
            aBet == totalMoedas -> {
                tround(R.string.YL)
                bar()
                ataques.setImageResource(vAtaques2[rand.nextInt(vAtaques2.size)])
                ataques.startAnimation(anim2)
                tentativas++
                va++
            }
            else -> {
                tround(R.string.NW)
                tentativas++
            }
        }

        when {
            va == 3 -> {
                statusFinal = R.string.LOSE
                final()
            }
            vh == 3 -> {
                statusFinal = R.string.ToWin
                final()
            }
        }
    }

    private fun final() {
        val att = getString(R.string.Att)

        val dfinal = Dialog(this).apply {
            setTitle(R.string.GO)
            setContentView(R.layout.custom_toast2)
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            show()
        }

        jogador = dfinal.findViewById(R.id.Jogador)
        tt = dfinal.findViewById(R.id.GameOver)
        tt2 = dfinal.findViewById(R.id.TT2)
        tv = dfinal.findViewById(R.id.TV)
        sf = dfinal.findViewById(R.id.SF)
        butaoOK = dfinal.findViewById(R.id.OK)

        tt.setText(R.string.GO)
        tt2.setText(R.string.TT2)
        tv.text = "$tentativas $att"
        sf.setText(statusFinal)
        jogador.setImageDrawable(wtf)

        butaoOK.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}