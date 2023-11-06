package com.example.fooddeliveri.Viev

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveri.R

data class BottomNavigation(
    val title:String,
    val SelectedIcon: ImageVector,
    val UnSelectedIcon: ImageVector,
    val hasNews:Boolean
)
val ButtonNameGroup= listOf("Пицца","Комбо","Десерты","Напитки")
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    //1
var selectedItemIndex by rememberSaveable {
mutableStateOf(0)
    }
val items = listOf(
 BottomNavigation(
     title = "Меню",
     SelectedIcon = ImageVector.vectorResource(R.drawable.selectedmenu),
     UnSelectedIcon = ImageVector.vectorResource(R.drawable.baseline_restaurant_menu_24),
     hasNews = false,
 ),
BottomNavigation(
        title = "Профиль",
        SelectedIcon = ImageVector.vectorResource(R.drawable.selectedprofile),
        UnSelectedIcon = ImageVector.vectorResource(R.drawable.unselectedprofile),
        hasNews = false,
),
 BottomNavigation(
        title = "Корзина",
        SelectedIcon = ImageVector.vectorResource(R.drawable.selectedshop),
        UnSelectedIcon = ImageVector.vectorResource(R.drawable.unselectedshop),
        hasNews = false,
 ),
 )
Scaffold(
  bottomBar = {
    NavigationBar(Modifier.height(70.dp)
                  , containerColor = Color.White
    ) {
      items.forEachIndexed { index, item ->
        NavigationBarItem(selected = selectedItemIndex==index,
                          onClick = { selectedItemIndex = index
                //navController.navigate(item.title)
      },
  label = { //Проработать логику
     Text(text = item.title)
  },
   icon = {
      BadgedBox(badge = {}) {
      androidx.compose.material3.Icon(
       imageVector = if (index == selectedItemIndex) {
         item.SelectedIcon

       //заменить иконки на красные
   } else item.UnSelectedIcon, contentDescription = item.title
   )
   }
   }
   )
   }
   }
  }
) {
    Column { //Основной список
        Row( //Верхняя строка
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp, vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(Modifier.padding(horizontal = 9.dp)) {
                Text(text = "Москва", Modifier.padding(vertical = 9.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "DownArrow")
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter =
                    painterResource(id = R.drawable.qr),
                    contentDescription = "Qr",
                    Modifier.size(40.dp)
                )
            }
        }
        Row(//Блок рекламных предложений
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())

        ) {
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
        Row(//Cтрока с кнопками после рекламного блока
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 10.dp)
                .horizontalScroll(rememberScrollState())
        )
        {
            for (i in ButtonNameGroup.indices) {
                Button(
                    shape = CircleShape,
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 7.dp,
                        pressedElevation = 5.dp
                    ),
                    modifier = Modifier.padding(start = 7.dp, end = 4.dp)
                ) {
                    Text(text = ButtonNameGroup[i], color = Color.Black)
                }
            }
        }
        Column(//Тело карточки товаров
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            for (i in 1..4) {
                Row(
                    Modifier
                        .padding(start = 7.dp, end = 7.dp, bottom = 7.dp, top = 7.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter =
                        painterResource(id = R.drawable.pizza),
                        contentDescription = "Img2", Modifier
                            .clip(CircleShape)
                            .size(120.dp), contentScale = ContentScale.Crop
                    )
                    Column(
                        Modifier
                            .padding(start = 20.dp, top = 10.dp)

                    ) {
                        Text(
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Пицца с ананасами"
                        )
                        Text(
                            fontSize = 15.sp,
                            text = "Состав укроп лук медвель салат еретик варфаламей картошка ананас верталет " +
                                    "и многие другие правда правда говорю"
                        )
                        Button(
                            shape = CircleShape,
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 7.dp,
                                pressedElevation = 5.dp
                            ),
                            modifier = Modifier.padding(start = 98.dp, end = 4.dp)
                        ) {
                            Text(text = "От 350р", color = Color.Red)
                        }
                    }
                }
            }


        }


    }
}




}
