package com.manish.composedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CreateVerticalList() {
    Text(text = "Heading")
    val sampleList = (1..20).toList()
    LazyColumn {
        items(sampleList) { item ->
            Text(
                text = "User - $item",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CreateHorizontalList() {
    val sampleList = (1..20).toList()
    LazyRow {
        items(sampleList) { item ->
            Text(
                text = "Sample - $item",
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.LightGray),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CreateGridList() {
    val sampleList = (1..5).toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    )
    {
        items(sampleList) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(4.dp)
            ) {
                Text(
                    text = "Item $item",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun CustomList() {
    val items = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")
    LazyColumn {
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(if (index % 2 == 0) Color.LightGray else Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$index",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun CombinedLists() {
    val categories = listOf("Section-1", "Section-2", "Section-3")
    val items = (1..10).toList()
    LazyColumn {
        items(categories) { category ->
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
            LazyRow {
                items(items) { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp),
                        elevation = CardDefaults.elevatedCardElevation(10.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(text = "$item")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewList() {
//    CreateVerticalList()
//    CreateHorizontalList()
//    CreateGridList()
//    CustomList()
    CombinedLists()
}