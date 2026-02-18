package com.bngs0.coutnerkotlin

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bngs0.coutnerkotlin.databinding.ActivityMainBinding
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var timer: CountDownTimer
    var leftTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        timer = object : CountDownTimer(10000,1000){
            override fun onFinish() {
                binding.leftText.text = "BOMBA PATLADI!"
            }

            override fun onTick(millisUntilFinished: Long) {
                    leftTime = millisUntilFinished/1000
                    binding.leftText.text = "BOMBANIN PATLAMASINA\nSON: ${millisUntilFinished/1000}"
            }
        }
        timer.start()


        binding.stopButton.setOnClickListener {
            timer.cancel()
            binding.leftText.text = "PATLAMAYA ${leftTime} SANİYE KALA BOMBA DURDURULDU!"

        }

    }
}