package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.br.usemobile.poc_library.common.ChatManager
import com.br.usemobile.poc_library.common.ChatManagerInterface
import com.br.usemobile.poc_library.common.UserInfo
import com.br.usemobile.poc_library.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    lateinit var userInfo: UserInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpLayout()
        getIntentScreen()
        ChatManager.getManager().notifyInit()
    }

    private fun getIntentScreen() {
        userInfo = intent.getSerializableExtra("UserInfo") as UserInfo
    }

    private fun setUpLayout(){
        binding.apply {
            appBarLayout.backgroundTintList = ContextCompat.getColorStateList(this@ChatActivity, ChatManager.getManager().colorPrimary)
        }
    }

}