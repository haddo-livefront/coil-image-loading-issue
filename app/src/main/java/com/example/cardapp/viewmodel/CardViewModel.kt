package com.example.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardapp.model.CardItem
import com.example.cardapp.repository.CardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {

    private val repository = CardRepository()

    private val _cards = MutableStateFlow<List<CardItem>>(emptyList())
    val cards: StateFlow<List<CardItem>> = _cards.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _selectedCard = MutableStateFlow<CardItem?>(null)
    val selectedCard: StateFlow<CardItem?> = _selectedCard.asStateFlow()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _cards.value = repository.getCards()
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadCardDetails(cardId: Int) {
        viewModelScope.launch {
            try {
                _selectedCard.value = when (cardId) {
                    119 -> {
                        CardItem(
                            id = 119,
                            title = "Hey there",
                            tags = listOf("nature", "sunset", "landscape", "photography"),
                            imageUrl = "https://picsum.photos/400/200?random=1",
                        )
                    }
                    120 -> {
                        CardItem(
                            id = 120,
                            title = "Hey there",
                            tags = listOf("nature", "sunset", "landscape", "photography"),
                            imageUrl = "https://picsum.photos/400/200?random=1",
                        )
                    }
                    121 -> {
                        CardItem(
                            id = 121,
                            title = "Hey there",
                            tags = listOf("nature", "sunset", "landscape", "photography"),
                            imageUrl = "https://picsum.photos/400/200?random=1",
                        )
                    }
                    122 -> {
                        CardItem(
                            id = 122,
                            title = "Hey there",
                            tags = listOf("nature", "sunset", "landscape", "photography"),
                            imageUrl = "https://picsum.photos/400/200?random=1",
                        )
                    }
                    else -> {
                        repository.getCardById(cardId)
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}