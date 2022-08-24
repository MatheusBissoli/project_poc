package com.br.usemobile.poc_library.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.br.usemobile.poc_library.external.ChatManager
import com.br.usemobile.poc_library.external.UserInfo
import com.br.usemobile.poc_library.databinding.ActivityChatBinding

internal class ChatActivity : AppCompatActivity() {

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