package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.usemobile.poc_library.common.ChatViewModelFactory
import com.br.usemobile.poc_library.data.service.chat.ChatRealTimeDatabaseImp
import com.br.usemobile.poc_library.databinding.FragmentListConversationsBinding
import com.br.usemobile.poc_library.view.chat.adapter.ListConversationsAdapter
import com.br.usemobile.poc_library.view.chat.model.Conversation


internal class ListConversationsFragment : Fragment() {

    private lateinit var binding: FragmentListConversationsBinding

    private val listConversationAdapter: ListConversationsAdapter by lazy {
        ListConversationsAdapter()
    }

    private val viewModel: ChatViewModel by lazy {
        val chat = ChatRealTimeDatabaseImp()
        val factory = ChatViewModelFactory(chat)
        ViewModelProvider(requireActivity(), factory)[ChatViewModel::class.java]
    }

    private val args: ListConversationsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListConversationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getContato(args.uid)
    }

    private fun setUpObservers() {
        viewModel.contato.observe(viewLifecycleOwner) { contato ->
            setUpAdapter(contato)
        }
    }

    private fun setUpAdapter(contato: String) {
        val conv = Conversation(
            id = "1",
            senderName = contato,
            lastMessage = "",
            timeLastMessage = ""
        )
        binding.recyclerViewConversation.apply {
            adapter = listConversationAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        listConversationAdapter.addItems(
            listOf(conv)
        )
        listConversationAdapter.setOnClick {
            findNavController().navigate(ListConversationsFragmentDirections.actionListConversationsFragmentToChatFragment(
                it,
                args.uid
            ))
        }
    }

//
//    private fun generateList(): List<Conversation> {
//        return listOf(
//            Conversation(
//                id = "1",
//                senderName = "Name",
//                lastMessage = "Last ",
//                timeLastMessage = "14:55"
//            ),
//            Conversation(
//                id = "1",
//                senderName = "Name",
//                lastMessage = "Last ",
//                timeLastMessage = "14:55"
//            ),
//            Conversation(
//                id = "1",
//                senderName = "Name",
//                lastMessage = "Last ",
//                timeLastMessage = "14:55"
//            ),
//            Conversation(
//                id = "1",
//                senderName = "Name",
//                lastMessage = "Last ",
//                timeLastMessage = "14:55"
//            ),
//        )
//    }
}