package com.calebk.baselineprofilebenchmarkdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.calebk.baselineprofilebenchmarkdemo.ui.theme.BaselineProfileBenchmarkDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaselineProfileBenchmarkDemoTheme {
                var counter by remember {
                    mutableIntStateOf(0)
                }

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "start",
                ) {
                    composable("start") {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            item {
                                Button(onClick = { counter++ }) {
                                    Text(text = "Click me")
                                }
                            }
                            items(counter) {
                                val text = "Element $it"
                                Text(
                                    text = text,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            navController.navigate("detail/$text")
                                        }
                                        .padding(32.dp)
                                )
                            }
                        }
                    }
                    composable(
                        route = "detail/{text}",
                        arguments = listOf(
                            navArgument("text") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val text = it.arguments?.getString("text") ?: "Default"
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Detail: $text")
                        }
                    }
                }

            }
        }
    }
}
