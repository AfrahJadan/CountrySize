package com.example.android.countriesphotos.overview

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder

import coil.request.ImageRequest
import com.example.android.countriesphotos.network.CountriesImage

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imageLoader = ImageLoader.Builder(imgView.context)
            .componentRegistry { add(SvgDecoder(imgView.context)) }
            .build()
        val request = ImageRequest.Builder(imgView.context)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)

        }
    }



@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<CountriesImage>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}