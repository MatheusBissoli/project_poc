package com.br.usemobile.poc_library.view.chat.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.br.usemobile.poc_library.external.ChatManager
import com.br.usemobile.poc_library.databinding.ItemChatSenderBinding
import com.br.usemobile.poc_library.databinding.ItemChatUserBinding
import com.br.usemobile.poc_library.view.chat.model.ItemChat


internal sealed class ChatViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    class ItemChatUserViewHolder(
        private val itemBinding: ItemChatUserBinding,
        private val context: Context
    ) :
        ChatViewHolder(itemBinding) {

        fun bind(dataModel: ItemChat.User) {
            itemBinding.apply {
                textViewMessageUser.text = dataModel.message
                textViewTimeMessageUser.text = dataModel.time
                constraintLayoutMessage.backgroundTintList = ContextCompat.getColorStateList(
                    context,
                    ChatManager.getManager().colorPrimary
                )

            }
        }
    }

    class ItemChatSenderViewHolder(
        private val itemBinding: ItemChatSenderBinding,
        private val context: Context
    ) :
        ChatViewHolder(itemBinding) {

        fun bind(dataModel: ItemChat.Sender) {
            itemBinding.apply {
                textViewMessageSender.text = dataModel.message
                textViewTimeMessageSender.text = dataModel.time
                constraintLayoutMessage.backgroundTintList = ContextCompat.getColorStateList(
                    context,
                    ChatManager.getManager().colorPrimary
                )

            }
        }
    }

}
