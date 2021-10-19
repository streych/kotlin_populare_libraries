package com.example.k_populare_libraries

import android.os.Bundle
import com.example.k_populare_libraries.app.App
import com.example.k_populare_libraries.databinding.ActivityMainBinding
import com.example.k_populare_libraries.presenter.MainPresenter
import com.example.k_populare_libraries.screens.AndroidScreens
import com.example.k_populare_libraries.screens.BackButtonListenerI
import com.example.k_populare_libraries.view.MainViewI
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainViewI {

    val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListenerI && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}