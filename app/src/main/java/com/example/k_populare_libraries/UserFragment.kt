package com.example.k_populare_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.databinding.FragmentUserBinding
import com.example.k_populare_libraries.view.UserViewI
import moxy.MvpAppCompatFragment

class UserFragment() : MvpAppCompatFragment(), UserViewI {

    companion object {
        const val BUNDLE_EXTRA = "user"
        fun newInstance(bundle: Bundle): UserFragment {
            val fragment = UserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var binding: FragmentUserBinding? = null
    private lateinit var userBundle: GithubUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        binding = it

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: GithubUser()
        binding?.login?.text = userBundle.login
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}