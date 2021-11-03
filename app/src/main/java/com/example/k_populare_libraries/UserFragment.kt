package com.example.k_populare_libraries

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.databinding.FragmentUserBinding
import com.example.k_populare_libraries.model.GlideImageLoader
import moxy.MvpAppCompatFragment
import java.net.URI

class UserFragment() : MvpAppCompatFragment() {

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

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: GithubUser()
        binding?.login?.text = userBundle.login
        binding?.ivAvatar?.let {
            Glide.with(this)
                .load(userBundle.avatarUrl)
                .into(it)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}