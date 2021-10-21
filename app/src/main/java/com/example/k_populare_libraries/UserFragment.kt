package com.example.k_populare_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k_populare_libraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment

class UserFragment() : MvpAppCompatFragment() {

    private var binding: FragmentUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        binding = it

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.login?.text =
            "Типо надо получить логин, но три дня смотрб на новые ворота и не придумал как передать из UsersPresenter сюда логин"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}