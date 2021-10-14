package com.example.k_populare_libraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.k_populare_libraries.databinding.ActivityMainBinding
import com.example.k_populare_libraries.presenter.CounterType
import com.example.k_populare_libraries.presenter.MainPresenter
import com.example.k_populare_libraries.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerTap()
    }

    //отображение для экрана
    override fun setButtonText1(text: String) {
        binding.textMe1.text = text
    }

    override fun setButtonText2(text: String) {
        binding.textMe2.text = text
    }

    override fun setButtonText3(text: String) {
        binding.textMe3.text = text
    }

    fun listenerTap() {

        //обработка нажатий
        binding.apply {
            tapMe1.setOnClickListener {
                presenter.counterClick(CounterType.TAPME1)
            }
            tapMe2.setOnClickListener {
                presenter.counterClick(CounterType.TAPME2)
            }
            tapMe3.setOnClickListener {
                presenter.counterClick(CounterType.TAPME3)
            }
        }
    }


}