package com.example.cardapp.repository

import com.example.cardapp.model.CardItem
import kotlinx.coroutines.delay

class CardRepository {

    private val sampleCards = listOf(
        CardItem(
            id = 1,
            title = "Beautiful Sunset",
            tags = listOf("nature", "sunset", "landscape", "photography"),
            imageUrl = "https://picsum.photos/400/200?random=1"
        ),
        CardItem(
            id = 2,
            title = "Mountain Adventure",
            tags = listOf("mountain", "hiking", "adventure", "outdoor"),
            imageUrl = "https://picsum.photos/400/200?random=2"
        ),
        CardItem(
            id = 3,
            title = "Ocean Waves",
            tags = listOf("ocean", "waves", "beach", "water"),
            imageUrl = "https://picsum.photos/400/200?random=3"
        ),
        CardItem(
            id = 4,
            title = "City Lights",
            tags = listOf("city", "lights", "urban", "night"),
            imageUrl = "https://picsum.photos/400/200?random=4"
        ),
        CardItem(
            id = 5,
            title = "Forest Path",
            tags = listOf("forest", "path", "trees", "nature"),
            imageUrl = "https://picsum.photos/400/200?random=5"
        ),
        CardItem(
            id = 6,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://picsum.photos/400/200?random=6"
        ),
        CardItem(
            id = 7,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/burger-1.webp"
        ),
        CardItem(
            id = 8,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/chicken-sandwich-1.webp"
        ),
        /*CardItem(
            id = 9,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/burger-2.webp"
        ),
        CardItem(
            id = 11,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/sub-2.webp"
        ),
        CardItem(
            id = 12,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/sandwich-1.webp"
        ),
        CardItem(
            id = 13,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/burger-3.webp"
        ),
        CardItem(
            id = 14,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/pulled-pork-1.webp"
        ),
        CardItem(
            id = 15,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/burger-4.webp"
        ),
        CardItem(
            id = 16,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/sub-1.webp"
        ),
        CardItem(
            id = 17,
            title = "Desert Landscape",
            tags = listOf("desert", "sand", "landscape", "dry"),
            imageUrl = "https://livefront-challenge-3fc04079eb61.herokuapp.com/img/buns-1.webp"
        )*/
    )

    suspend fun getCards(): List<CardItem> {
        delay(500) // Simulate network delay
        return sampleCards
    }

    suspend fun getCardById(id: Int): CardItem? {
        delay(300) // Simulate network delay
        return sampleCards.find { it.id == id }
    }
}