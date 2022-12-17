package com.example.ovenmarket.model

data class ChatItem(
    val profileImageUrl: String,
    val senderId: String?,
    val time: String,
    val message: String
) {
    constructor(): this("", "", ""," ")
}
