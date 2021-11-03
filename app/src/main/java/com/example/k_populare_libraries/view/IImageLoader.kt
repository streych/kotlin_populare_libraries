package com.example.k_populare_libraries.view

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}