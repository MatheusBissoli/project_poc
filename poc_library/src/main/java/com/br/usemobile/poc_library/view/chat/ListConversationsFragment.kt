package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.usemobile.poc_library.databinding.FragmentListConversationsBinding
import com.br.usemobile.poc_library.view.chat.adapter.ListConversationsAdapter
import com.br.usemobile.poc_library.view.chat.model.Conversation


internal class ListConversationsFragment : Fragment() {

    private lateinit var binding: FragmentListConversationsBinding

    private val listConversationAdapter: ListConversationsAdapter by lazy {
        ListConversationsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListConversationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
    }

    private fun setUpAdapter() {

        binding.recyclerViewConversation.apply {
            adapter = listConversationAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        listConversationAdapter.addItems(generateList())
        listConversationAdapter.setOnClick {
            findNavController().navigate(ListConversationsFragmentDirections.actionListConversationsFragmentToChatFragment())
        }
    }


    private fun generateList(): List<Conversation> {
        return listOf(
            Conversation(
                id = "1",
                senderName = "Name",
                lastMessage = "Last ",
                timeLastMessage = "14:55"
            ),
            Conversation(
                id = "1",
                senderName = "Name",
                lastMessage = "Last ",
                timeLastMessage = "14:55"
            ),
            Conversation(
                id = "1",
                senderName = "Name",
                lastMessage = "Last ",
                timeLastMessage = "14:55"
            ),
            Conversation(
                id = "1",
                senderName = "Name",
                lastMessage = "Last ",
                timeLastMessage = "14:55"
            ),
        )
    }
}