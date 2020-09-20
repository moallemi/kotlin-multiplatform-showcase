package me.moallemi.kmpshowcase.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import me.moallemi.kmpshowcase.shared.domain.model.Identifiable

abstract class IdentifiableAdapter<Item : Identifiable, Binding : ViewBinding>(
    private val layoutResId: Int
) : ListAdapter<Item, IdentifiableAdapter.ItemViewHolder>(IdentifiableDiffCallback<Item>()) {

    abstract fun onBindData(itemView: View, model: Item, position: Int)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val dataBinding = LayoutInflater.from(parent.context).inflate(
            layoutResId,
            parent,
            false
        )
        return ItemViewHolder(dataBinding)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        onBindData(holder.itemView, getItem(position), position)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}