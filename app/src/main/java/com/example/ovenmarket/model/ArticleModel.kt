package com.example.ovenmarket.model

data class ArticleModel(
    val sellerId: String,
    val title: String,
    val createdAt: Long,
    val price: String,
    val imageURL: String
) {
    constructor(): this("", "", 0, "", "")
}
