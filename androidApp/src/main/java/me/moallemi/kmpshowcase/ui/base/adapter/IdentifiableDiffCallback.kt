package me.moallemi.kmpshowcase.ui.base.adapter

import androidx.recyclerview.widget.DiffUtil
import me.moallemi.kmpshowcase.shared.domain.model.Identifiable

class IdentifiableDiffCallback<T : Identifiable> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.id === newItem.id

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}