package com.example.k_populare_libraries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_populare_libraries.databinding.ItemRecyclerRepoUserBinding
import com.example.k_populare_libraries.view.UserInfoItemViewI
import com.example.k_populare_libraries.view.UserInfoListPresenterI

class UserInfoRVAdapter(val presenter: UserInfoListPresenterI): RecyclerView.Adapter<UserInfoRVAdapter.ViewHolder>() {

    inner class ViewHolder(val vb: ItemRecyclerRepoUserBinding): RecyclerView.ViewHolder(vb.root), UserInfoItemViewI {

        override fun setNameRepo(text: String) = with(vb) {
            tvRepos.text = text
        }

        override var pos = -1

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRecyclerRepoUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position

            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        })
    }

    override fun getItemCount() = presenter.getCount()
}