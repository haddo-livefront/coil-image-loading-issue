package com.example.cardapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.cardapp.viewmodel.CardViewModel
import com.example.cardapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDetailScreen(
    cardId: Int,
    onBackClick: () -> Unit,
    viewModel: CardViewModel = viewModel()
) {
    val selectedCard by viewModel.selectedCard.collectAsState()

    LaunchedEffect(cardId) {
        viewModel.loadCardDetails(cardId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Card Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        selectedCard?.let { card ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                val model = when (card.id) {
                    119 -> {
                        ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.sub_not_working_3)
                            .build()
                    }
                    120 -> {
                        ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.burger_not_work_2)
                            .build()
                    }
                    121 -> {
                        ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.random_pic_working_1)
                            .build()
                    }
                    122 -> {
                        ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.burger_not_working_1)
                            .build()
                    }
                    else -> {
                        ImageRequest.Builder(LocalContext.current)
                            .data(card.imageUrl)
                            .build()
                    }
                }
                AsyncImage(
                    model = model,
                    contentDescription = card.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = card.title,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Tags",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Text(
                                text = card.tags.joinToString(", "),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            }
        } ?: run {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}