package com.example.piaandroidcompose

import android.os.Bundle
import android.provider.SyncStateContract.Columns
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.piaandroidcompose.ui.theme.PiaAndroidComposeTheme
import androidx.compose.foundation.layout.Column as Column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiaAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Shopping(ShopThing("asd",1))
                }
            }
        }
    }
}


@Composable
fun Shopping(shop: ShopThing,modifier: Modifier = Modifier) {
//    val shopItems = mutableListOf<String>("Banana","Apple")
    val shopItems = remember { mutableStateListOf<ShopThing>() }
    var addName by remember { mutableStateOf("") }
    var addAmount by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(Color.Red)
                .padding(12.dp))

        {
            TextField(value = addName, onValueChange = {
                addName = it
            }, label = { Text(text = "What Buy")}, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp))
            TextField(value = addAmount, onValueChange = {
                addAmount = it
            } ,label = { Text(text = "Amount")}, modifier = Modifier
                .width(150.dp)
                .padding(horizontal = 10.dp))
            Button(onClick = {
                addAmount.toIntOrNull()?.let{amountNumber ->
                    val tempShop = ShopThing(addName,amountNumber)
                    shopItems.add(tempShop)
                    addName = ""
                    addAmount = ""
                }
//                shopItems.add(ShopThing("Milk",1))
            }
            ) {
                Text(text = "ADD")
            }
        }
        LazyColumn {

            itemsIndexed(shopItems) {index,shopItem ->

                    ShowRow(shopItem,modifier.clickable {
                        Log.i("Pia","Clicked " + shopItem.shopTitle)
//                        shopItem.isBought = true
//                        shopItem.shopTitle = "X"
//
//                        shopItems[index] = shopItem

//                        var xShop = ShopThing("A",12)
//                        shopItems[0] = xShop
//                        shopItems.removeLast()
                        shopItems.removeAt(index)
                    })
                }

        }
    }
}


@Preview(showBackground = true, widthDp = 500, heightDp = 800)
@Composable
fun GreetingPreview() {
    PiaAndroidComposeTheme {
        Shopping(ShopThing("car",1))
    }
}