package com.example.k_populare_libraries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.databinding.ItemRecyclerviewBinding
import com.example.k_populare_libraries.repository.GithubUsersRepo
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserListPresenterI
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class UsersRVAdapter(val presenter: UserListPresenterI) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply {
            pos = position

            itemView.setOnClickListener {

                presenter.itemClickListener?.invoke(this)
            }

        })

    inner class ViewHolder(val vb: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemViewI {

        override var pos = -1
        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }


}