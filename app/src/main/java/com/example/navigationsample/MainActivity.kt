package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            FirstScreen {age, name ->
                navController.navigate("secondScreen/$age/$name")
            }
        }
        composable("secondScreen/{age}/{name}") {
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age")?:"1"
            SecondScreen(age,name) { name ->
                navController.navigate("thirdScreen/$name")
            }
        }
        composable("thirdScreen/{name}") {
            val name = it.arguments?.getString("name") ?: "no name from Second"
            ThirdScreen(name) {
                navController.navigate("firstScreen")
            }
        }
    }
}

