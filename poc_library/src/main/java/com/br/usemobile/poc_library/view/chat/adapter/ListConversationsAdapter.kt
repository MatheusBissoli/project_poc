package com.br.usemobile.poc_library.view.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.usemobile.poc_library.databinding.ItemConversationAdapterBinding
import com.br.usemobile.poc_library.view.chat.model.Conversation

internal class ListConversationsAdapter : RecyclerView.Adapter<ListConversationsAdapter.ItemsViewHolder>() {

    private var list: MutableList<Conversation> = mutableListOf()
    private lateinit var onClick: (String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val itemBinding =
            ItemConversationAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemsViewHolder(itemBinding, onClick)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addItems(list: List<Conversation>) {
        val startIndex = this.list.size
        this.list.addAll(list)
        notifyItemRangeInserted(startIndex, list.size)
    }

    fun clear() {
        this.list.clear()
        notifyDataSetChanged()
    }

    fun setOnClick(function: (String) -> Unit) {
        onClick = function
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    class ItemsViewHolder(
        private val itemBinding: ItemConversationAdapterBinding,
        private val onClick: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Conversation) {
            itemBinding.apply {
                textViewSender.text = item.senderName
                textViewLastMessage.text = item.lastMessage
                textViewTimeLastMessage.text = item.timeLastMessage

            }
            itemBinding.item.setOnClickListener {
                onClick.invoke(item.id)
            }
        }
    }
}