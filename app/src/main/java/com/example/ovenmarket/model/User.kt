package com.example.ovenmarket.model

data class User(
    val name: String,
    val email: String,
    val imageUrl: String
){
    constructor(): this("", "", "")
}
