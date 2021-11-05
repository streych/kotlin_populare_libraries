package com.example.k_populare_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.k_populare_libraries.data.ApiHolder
import com.example.k_populare_libraries.databinding.FragmentRepositoryInfoBinding
import com.example.k_populare_libraries.presenter.RepositoryInfoPresenter
import com.example.k_populare_libraries.repository.RetrofitGitRepoInfo
import com.example.k_populare_libraries.view.UsersViewI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class RepositoryInfoFragment : MvpAppCompatFragment(), UsersViewI {

    private var binding: FragmentRepositoryInfoBinding? = null

    val presenter: RepositoryInfoPresenter by moxyPresenter {
        RepositoryInfoPresenter(
            AndroidSchedulers.mainThread(),
            RetrofitGitRepoInfo(ApiHolder.api_repo_info)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRepositoryInfoBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun init() {
        binding?.nameRepository?.text = presenter.userInfoListPresenter.repoInfo.toString()

    }

    override fun updateList() {
        TODO("Not yet implemented")
    }

}