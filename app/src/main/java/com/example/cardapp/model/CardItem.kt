package com.example.cardapp.model

data class CardItem(
    val id: Int,
    val title: String,
    val tags: List<String>,
    val imageUrl: String
)