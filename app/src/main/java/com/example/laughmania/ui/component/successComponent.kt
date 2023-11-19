package com.example.laughmania.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laughmania.data.models.RandomData


@Composable
fun successComponent(jokes : RandomData) {
    Column {
        Text(
            text = "Jokes Mania",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(900),
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth()
        )
        RandomJokesList(randomJokes = jokes)
    }
}