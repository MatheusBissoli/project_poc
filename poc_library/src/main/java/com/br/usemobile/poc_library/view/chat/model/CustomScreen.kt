package com.br.usemobile.poc_library.view.chat.model

import com.br.usemobile.poc_library.R
import java.io.Serializable

internal data class CustomScreen(
    val title: String = "ChatTest",
    val color: Int = R.color.black,
    val buttonText: String = "Open BottomSheet"
): Serializable