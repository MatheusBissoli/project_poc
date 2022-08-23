package com.br.usemobile.poc_library.view.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.poc_library.common.CustomChat
import com.br.usemobile.poc_library.common.UserInfo
import com.br.usemobile.poc_library.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    lateinit var customLayout: CustomChat
    lateinit var userInfo: UserInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentScreen()
    }

    private fun getIntentScreen() {
        customLayout = intent.getSerializableExtra("Custom") as CustomChat
        userInfo = intent.getSerializableExtra("UserInfo") as UserInfo

    }

}