package com.br.usemobile.poc_library.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.usemobile.poc_library.databinding.ItemChatSenderBinding
import com.br.usemobile.poc_library.databinding.ItemChatUserBinding
import com.br.usemobile.poc_library.view.model.ItemChat


class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val adapterData = mutableListOf<ItemChat>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_USER -> {
                val itemBinding = ItemChatUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ChatViewHolder.ItemChatUserViewHolder(itemBinding)
            }
            TYPE_SENDER -> {
                val itemBinding = ItemChatSenderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ChatViewHolder.ItemChatSenderViewHolder(itemBinding)
            }

            else -> throw IllegalArgumentException("Invalid type")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is ChatViewHolder.ItemChatUserViewHolder -> {
                holder.bind(adapterData[position] as ItemChat.User)
            }
            is ChatViewHolder.ItemChatSenderViewHolder -> {
                holder.bind(adapterData[position] as ItemChat.Sender)
            }

        }
    }

    override fun getItemCount(): Int = adapterData.size

    override fun getItemViewType(position: Int): Int {
        return when (adapterData[position]) {
            is ItemChat.User -> TYPE_USER
            else -> TYPE_SENDER
        }
    }

    fun setData(data: List<ItemChat>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun add(message: ItemChat) {
        val startIndex = this.adapterData.size
        this.adapterData.add(startIndex, message)
        notifyItemRangeInserted(startIndex, adapterData.size)
    }

    fun clear() {
        this.adapterData.clear()
        notifyDataSetChanged()
    }

    companion object {
        private const val TYPE_USER = 0
        private const val TYPE_SENDER = 1

    }
}