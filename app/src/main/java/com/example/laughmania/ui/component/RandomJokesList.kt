package com.example.laughmania.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laughmania.data.models.RandomData

val URL = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fdeveloper.android.com%2Fstatic%2Fimages%2Fjetpack%2Fcompose%2Fsemantics-ui-tree.png&tbnid=ohCfmUMxV6IoGM&vet=12ahUKEwj5tL6Hxb2CAxUYmWMGHWC8BuYQMygDegQIARBW..i&imgrefurl=https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Fsemantics&docid=soMm5SPA1Edi4M&w=1500&h=1310&q=image%20properties%20in%20in%20jetpack%20compose&ved=2ahUKEwj5tL6Hxb2CAxUYmWMGHWC8BuYQMygDegQIARBW"

@Composable
fun RandomJokesList(randomJokes : RandomData) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Column {
            Text(
                text = "Created:- ${date(randomJokes.createdAt?:"")}",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Jokes",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                    )
                )

//                Image(
//                    painter = painterResource(id = R.drawable.ic_launcher_background),
//                    contentDescription = "image",
//                    contentScale = ContentScale.Fit,
//                    modifier = Modifier
//                        .size(150.dp)
//                        .border(
//                            BorderStroke(4.dp, Color.Black),
//                            CircleShape
//                        )
//                        .padding(4.dp)
//                        .clip(shape = CircleShape)
//                )

                if (!randomJokes.url.isNullOrEmpty()){
                    AsyncImage(
                        model = "https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png",
                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(150.dp)
                            .border(
                                BorderStroke(4.dp, Color.Black),
                                CircleShape
                            )
                            .padding(10.dp)

                    )

                }

                Text(
                    text = randomJokes.value?:"",
                    style = TextStyle(
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                )

            }
        }
    }
}

//trimming the created date
private fun date(date: String): String {
    return date.substring(0, minOf(10, date.length))
}


