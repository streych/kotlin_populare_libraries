package com.example.k_populare_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k_populare_libraries.data.GitUserInfo
import com.example.k_populare_libraries.databinding.FragmentRepositoryInfoBinding
import moxy.MvpAppCompatFragment


class RepositoryInfoFragment : MvpAppCompatFragment() {

    private var binding: FragmentRepositoryInfoBinding? = null
    lateinit var riBundle: GitUserInfo

    companion object {
        const val BUNDLE_EXTRA_FORKS = "forks"
        fun newInstance(bundle_forks: Bundle): RepositoryInfoFragment {
            val fragment = RepositoryInfoFragment()
            fragment.arguments = bundle_forks
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRepositoryInfoBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        riBundle = arguments?.getParcelable(BUNDLE_EXTRA_FORKS) ?: GitUserInfo()
        binding?.nameRepository?.text = riBundle.forks.toString()
    }


}