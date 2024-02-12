package com.example.piaandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piaandroidcompose.ui.theme.PiaAndroidComposeTheme

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
//                    Greeting("Android")
//                    FancyView("Fancy")
                    MathStuff()

                }
            }
        }
    }
}

@Composable
fun FancyView(name: String, modifier: Modifier = Modifier) {
    var myText by remember { mutableStateOf("AppleSin") }
    var myNumber by remember { mutableIntStateOf(0) }
    var personName by remember { mutableStateOf("") }
    Column(
        modifier
            .background(Color.Cyan)
            .fillMaxSize()
    ) {
        Row(
            modifier
                .background(Color.Red)
                .height(200.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier.width(30.dp))
            Column(
                modifier
                    .background(Color.Green)
                    .width(100.dp)
                    .height(100.dp)
//                    .padding(10.dp)
            ) {
                Text("Box")
            }
            Text("fancy View")
        }
        Row(
            modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.LightGray),
        ) {
            Text(
                "A",
                modifier
                    .background(Color.White)
                    .weight(1f)
            )
            Text(
                "B",
                modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Text(
                "C",
                modifier
                    .background(Color.Blue)
                    .weight(1f)
            )
        }
        Spacer(modifier.height(50.dp))
        Text(myText)
        Text(myNumber.toString())

        if (myNumber > 10) {
            Text("many clicks")
        }

        Button(onClick = {
            myText = "Banan"
            myNumber += 1
        }) {
            Text("Click")
        }

        Row {
            TextField(value = personName, onValueChange = { personName = it })
        }
    }
}

@Composable
fun MathStuff() {
    var theNumber by remember { mutableStateOf(0) }
    var numberText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "$theNumber",
            fontSize = 60.sp
        )

        TextField(
            value = numberText,
            onValueChange = { numberText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        )

        Row(modifier = Modifier.padding(16.dp)) {
            Button(
                onClick = {
                    numberText.toIntOrNull()?.let {
                        theNumber += it
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("PLUS")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    theNumber -= numberText.toInt()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("MINUS")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    theNumber *= numberText.toInt()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("MULTI")
            }
            Spacer(modifier = Modifier.width(20.dp))
        }


        Button(onClick = {
            theNumber = 0
        }) {
            Text("Reset")
        }
    }

    fun doPlus() {

    }
}

@Composable
fun niceBook() {
    Text("Nice Box")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Hello $name!",
            modifier.background(Color.Magenta),
            fontSize = 30.sp
        )
        Text(
            text = "Hello PRG!",
            modifier.background(Color.Cyan)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiaAndroidComposeTheme {
//        Greeting("Android")
//        FancyView("hei")
        MathStuff()
    }
}