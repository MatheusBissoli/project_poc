package com.br.usemobile.poc_library

import java.io.Serializable

data class CustomScreen(
    val title: String = "ChatTest",
    val color: Int = R.color.black,
    val buttonText: String = "Open BottomSheet"
): Serializable