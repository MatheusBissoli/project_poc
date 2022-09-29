package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.usemobile.poc_library.common.ChatViewModelFactory
import com.br.usemobile.poc_library.data.service.chat.ChatRealTimeDatabaseImp
import com.br.usemobile.poc_library.databinding.FragmentChatBinding
import com.br.usemobile.poc_library.external.ChatManager
import com.br.usemobile.poc_library.view.chat.adapter.ChatAdapter
import com.br.usemobile.poc_library.view.chat.model.ItemChat

internal class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

    private val chatAdapter: ChatAdapter by lazy {
        ChatAdapter()
    }

    private val viewModel: ChatViewModel by lazy {
        val chat = ChatRealTimeDatabaseImp()
        val factory = ChatViewModelFactory(chat)
        ViewModelProvider(requireActivity(), factory)[ChatViewModel::class.java]
    }

    private val args: ChatFragmentArgs by navArgs()

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
        setUpLayout()
        setUpListeners()
        setUpObservers()
        viewModel.listenerChat(args.id, args.contato)

    }

    private fun setUpObservers() {

        viewModel.conversa.observe(viewLifecycleOwner) { list ->
            val aux = arrayListOf<ItemChat>()
            for(i in list){
                aux.add(ItemChat.User(
                    message = i,
                    time = ""
                ))
            }
           chatAdapter.setData(aux)
            ChatManager.getManager().notifyReceivedMessage()
        }

    }

    private fun setUpAdapter() {
        binding.recyclerViewConversation.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setUpLayout() {
        binding.apply {
            constraintLayoutEditText.backgroundTintList =
                ContextCompat.getColorStateList(
                    requireContext(),
                    ChatManager.getManager().colorPrimary
                )
            imageViewSend.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    ChatManager.getManager().iconSend
                )
            )
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
            val message = editTextMessage.text.toString()
            editTextMessage.text.clear()

            ChatManager.getManager().notifySendMessage()
            viewModel.sendMessage(args.id, message, args.contato)
            ChatManager.getManager().notifySendMessage()
        }
    }

    private fun createMessage(message: String): ItemChat.User {
        return ItemChat.User(
            message = message,
            time = "10:44"
        )
    }

    private fun generateMessageSender(): ItemChat.Sender {
        return ItemChat.Sender(
            message = "aaa",
            time = "11:00"
        )
    }

}