package com.example.fooddeliveri.Viev

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddeliveri.R

@Composable
fun banner(){

    androidx.compose.foundation.Image(
        painter =
        painterResource(id = R.drawable.pizza),
        contentDescription = "Img1", Modifier
            .padding(end = 10.dp, start = 20.dp)
            .clip(RoundedCornerShape(22.dp))
            .height(160.dp)
    )
    Image(
        painter =
        painterResource(id = R.drawable.pizza),
        contentDescription = "Img2", Modifier
            .padding(end = 20.dp, start = 10.dp)
            .clip(RoundedCornerShape(22.dp))
            .height(160.dp)
    )
}