package com.example.k_populare_libraries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_populare_libraries.databinding.ItemRecyclerviewBinding
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserListPresenterI

class UsersRVAdapter(val presenter: UserListPresenterI) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemViewI {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }


}