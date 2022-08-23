package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.usemobile.poc_library.databinding.FragmentChatBinding
import com.br.usemobile.poc_library.view.adapter.ChatAdapter
import com.br.usemobile.poc_library.view.model.ItemChat

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

    private val chatAdapter: ChatAdapter by lazy {
        ChatAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setUpListeners()
    }

    private fun setUpAdapter() {
        binding.recyclerViewConversation.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setUpListeners() {
        binding.apply {
            imageViewSend.setOnClickListener {
                sendMessage()
            }
        }
    }

    private fun sendMessage() {
        binding.apply {
            val message = createMessage(editTextMessage.text.toString())
            editTextMessage.text.clear()
            chatAdapter.add(message)
        }
    }

    private fun createMessage(message: String): ItemChat.User {
        return ItemChat.User(
            message = message,
            time = "10:44"
        )
    }

}