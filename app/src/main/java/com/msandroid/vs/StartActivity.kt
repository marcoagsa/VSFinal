package com.msandroid.vs

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.msandroid.vs.databinding.ActivityInicioBinding
import com.msandroid.vs.databinding.ImginicioBinding

class StartActivity : AppCompatActivity() {

    // Usando View Binding (substitui findViewById)
    private lateinit var bindingInicio: ActivityInicioBinding
    private lateinit var bindingLogo: ImginicioBinding

    // Lazy loading das animações (são carregadas apenas quando necessárias)
    private val animZoomIn by lazy { AnimationUtils.loadAnimation(this, R.anim.zoom_in) }
    private val animBlink by lazy { AnimationUtils.loadAnimation(this, R.anim.blink) }
    private val animRotate by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate) }
    private val animBounce by lazy { AnimationUtils.loadAnimation(this, R.anim.bounce) }
    private val animSlideDown by lazy { AnimationUtils.loadAnimation(this, R.anim.slide_down) }
    private val animMove by lazy { AnimationUtils.loadAnimation(this, R.anim.move) }
    private val animMove2 by lazy { AnimationUtils.loadAnimation(this, R.anim.move_2) }
    private val animSeq by lazy { AnimationUtils.loadAnimation(this, R.anim.seq_anim) }

    private val tipoLetra by lazy {
        Typeface.createFromAsset(assets, "Imagica.ttf")
    }

    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura primeira tela com logo
        bindingLogo = ImginicioBinding.inflate(layoutInflater)
        setContentView(bindingLogo.root)

        setupAnimations()
        setupCountDownTimer()
    }

    private fun setupAnimations() {
        bindingLogo.apply {
            Logo.startAnimation(animZoomIn)
            HR.startAnimation(animRotate)
            GR.startAnimation(animBounce)
            AR.startAnimation(animSlideDown)
            FR.startAnimation(animRotate)
            IRR.startAnimation(animMove)
            IR.startAnimation(animMove2)
            SR.startAnimation(animSeq)
        }
    }

    private fun setupCountDownTimer() {
        countDownTimer = object : CountDownTimer(7000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Pode adicionar progresso se quiser
            }

            override fun onFinish() {
                // Mudar para tela principal
                showMainScreen()
            }
        }.start()
    }

    private fun showMainScreen() {
        bindingInicio = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(bindingInicio.root)

        setupTypography()
        setupClickListeners()
    }

    private fun setupTypography() {
        bindingInicio.Play.typeface = tipoLetra
        bindingInicio.Play.startAnimation(animBlink)
    }

    private fun setupClickListeners() {
        bindingInicio.Play.setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        // Adicionar animação de transição se desejar
        // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancelar timer para evitar memory leaks
        countDownTimer?.cancel()
        countDownTimer = null
    }
}