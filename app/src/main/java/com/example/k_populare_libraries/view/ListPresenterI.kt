package com.example.k_populare_libraries.view

interface ListPresenterI<V: ItemViewI> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

}
interface UserListPresenterI : ListPresenterI<UserItemViewI>

interface UserInfoListPresenterI : ListPresenterI<UserInfoItemViewI>