package com.example.navigationsample

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("NotConstructor")
@Composable
fun SecondScreen(age: String, name: String, navigationToThirdScreen: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the Second Screen", fontSize = 24.sp)
        Text("Welcome ${name} - age ${age}", fontSize = 24.sp)
        Button(onClick = {
            navigationToThirdScreen(name)
        }) {
            Text("Go to Third Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    SecondScreen ("0", "Erikson") {}
}