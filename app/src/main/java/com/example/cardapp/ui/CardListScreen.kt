package com.example.cardapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.cardapp.model.CardItem
import com.example.cardapp.viewmodel.CardViewModel
import com.example.cardapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardListScreen(
    onCardClick: (Int) -> Unit,
    viewModel: CardViewModel = viewModel()
) {
    val cards by viewModel.cards.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Card List") }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                cards.isEmpty() -> {
                    Text(
                        text = "No cards available",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(cards) { card ->
                            CardItem(
                                card = card,
                                onCardClick = { onCardClick(card.id) }
                            )
                        }

                        item {
                            CardItem2(
                                card = CardItem(
                                    id = 119,
                                    title = "Hey there",
                                    tags = listOf("nature", "sunset", "landscape", "photography"),
                                    imageUrl = "https://picsum.photos/400/200?random=1",
                                ),
                                onCardClick = { onCardClick(119) },
                                drawableResId = R.drawable.sub_not_working_3
                            )
                        }

                        item {
                            CardItem2(
                                card = CardItem(
                                    id = 120,
                                    title = "Hey there",
                                    tags = listOf("nature", "sunset", "landscape", "photography"),
                                    imageUrl = "https://picsum.photos/400/200?random=1",
                                ),
                                onCardClick = { onCardClick(120) },
                                drawableResId = R.drawable.burger_not_work_2
                            )
                        }

                        item {
                            CardItem2(
                                card = CardItem(
                                    id = 121,
                                    title = "Hey there",
                                    tags = listOf("nature", "sunset", "landscape", "photography"),
                                    imageUrl = "https://picsum.photos/400/200?random=1",
                                ),
                                onCardClick = { onCardClick(121) },
                                drawableResId = R.drawable.random_pic_working_1
                            )
                        }

                        item {
                            CardItem2(
                                card = CardItem(
                                    id = 122,
                                    title = "Hey there",
                                    tags = listOf("nature", "sunset", "landscape", "photography"),
                                    imageUrl = "https://picsum.photos/400/200?random=1",
                                ),
                                onCardClick = { onCardClick(122) },
                                drawableResId = R.drawable.burger_not_working_1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardItem(
    card: CardItem,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = card.imageUrl,
                contentDescription = card.title,
                modifier = Modifier
                    //.size(80.dp)
                    .width(80.dp)
                    .heightIn(80.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = card.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = card.tags.joinToString(", "),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun CardItem2(
    card: CardItem,
    @DrawableRes drawableResId: Int,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(drawableResId)
                    .build(),
                contentDescription = card.title,
                modifier = Modifier
                    //.size(80.dp)
                    .width(80.dp)
                    .heightIn(80.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = card.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = card.tags.joinToString(", "),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}