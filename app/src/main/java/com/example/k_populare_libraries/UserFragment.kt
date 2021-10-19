package com.example.k_populare_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k_populare_libraries.adapter.UsersRVAdapter
import com.example.k_populare_libraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment

class UserFragment() : MvpAppCompatFragment() {

    private var binding: FragmentUserBinding? = null
    var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.login?.text = arguments?.getString("string")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}