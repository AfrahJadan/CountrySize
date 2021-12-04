package com.example.android.countriesphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.countriesphotos.databinding.GridViewItemBinding
import com.example.android.countriesphotos.network.CountriesImage

class PhotoGridAdapter : ListAdapter<CountriesImage,
        PhotoGridAdapter.ContryPhotoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.ContryPhotoViewHolder {
        return ContryPhotoViewHolder(
            GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.ContryPhotoViewHolder, position: Int) {
        val contrypho = getItem(position)
        holder.bind(contrypho)
    }
    class ContryPhotoViewHolder(private var binding:
                                GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(conntryPhotolist : CountriesImage) {
            binding.image = conntryPhotolist
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<CountriesImage>() {
        override fun areContentsTheSame(oldItem: CountriesImage, newItem: CountriesImage): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areItemsTheSame(oldItem: CountriesImage, newItem: CountriesImage): Boolean {
            return oldItem.flag == newItem.flag
        }


    }
}