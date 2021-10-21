package com.example.k_populare_libraries

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k_populare_libraries.adapter.UsersRVAdapter
import com.example.k_populare_libraries.app.App
import com.example.k_populare_libraries.databinding.FragmentUsersBinding
import com.example.k_populare_libraries.presenter.UsersPresenter
import com.example.k_populare_libraries.repository.GithubUsersRepo
import com.example.k_populare_libraries.screens.AndroidScreens
import com.example.k_populare_libraries.screens.BackButtonListenerI
import com.example.k_populare_libraries.view.UsersViewI
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersViewI, BackButtonListenerI {

    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router, AndroidScreens())
    }

    var adapter: UsersRVAdapter? = null
    private var binding: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.userListPresenter)
        binding?.rvUsers?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}