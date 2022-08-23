package com.br.usemobile.poc_library.view.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.br.usemobile.poc_library.databinding.ItemChatSenderBinding
import com.br.usemobile.poc_library.databinding.ItemChatUserBinding
import com.br.usemobile.poc_library.view.model.ItemChat


sealed class ChatViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    class ItemChatUserViewHolder(private val itemBinding: ItemChatUserBinding) :
        ChatViewHolder(itemBinding) {

        fun bind(dataModel: ItemChat.User) {
            itemBinding.apply {
                textViewMessageUser.text = dataModel.message
                textViewTimeMessageUser.text = dataModel.time
            }
        }
    }

    class ItemChatSenderViewHolder(private val itemBinding: ItemChatSenderBinding) :
        ChatViewHolder(itemBinding) {

        fun bind(dataModel: ItemChat.Sender) {
            itemBinding.apply {
                textViewMessageSender.text = dataModel.message
                textViewTimeMessageSender.text = dataModel.time
            }
        }
    }

}
