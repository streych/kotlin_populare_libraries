package com.example.k_populare_libraries

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.k_populare_libraries.adapter.UserInfoRVAdapter
import com.example.k_populare_libraries.app.App
import com.example.k_populare_libraries.data.ApiHolder
import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.databinding.FragmentUserBinding
import com.example.k_populare_libraries.presenter.UserPresenter
import com.example.k_populare_libraries.presenter.UsersPresenter
import com.example.k_populare_libraries.repository.RetrofitGitUserInfo
import com.example.k_populare_libraries.repository.RetrofitGithubUsersRepo
import com.example.k_populare_libraries.screens.AndroidScreens
import com.example.k_populare_libraries.view.UsersViewI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment() : MvpAppCompatFragment(), UsersViewI {

    companion object {
        const val BUNDLE_EXTRA = "user"

        fun newInstance(bundle: Bundle): UserFragment {
            val fragment = UserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            AndroidSchedulers.mainThread(),
            RetrofitGitUserInfo(ApiHolder.api_user_info),
            App.instance.router, AndroidScreens()
        )
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

    override fun init() {
        binding?.rvUserRepos?.layoutManager = LinearLayoutManager(context)
        adapterInfo = UserInfoRVAdapter(presenter.userInfoListPresenter)
        binding?.rvUserRepos?.adapter = adapterInfo
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapterInfo?.notifyDataSetChanged()
    }

}