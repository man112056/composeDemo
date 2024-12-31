package com.manish.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import com.manish.composedemo.ui.theme.ComposeDemoTheme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SideEffectAndLaunchedEffectDemo()
                }
            }
        }
    }
}

@Composable
fun SideEffectAndLaunchedEffectDemo() {
    val TAG = "ComposeLogger"
    var count by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Button to trigger recomposition by changing the state
        Button(onClick = { count++ }) {
            BasicText("Increment Count")
        }

        // Display the current count
        BasicText(
            text = "Count: $count",
            modifier = Modifier.padding(top = 16.dp)
        )

        // SideEffect - Runs after every recomposition
//        SideEffect(count) {
//            Log.d(TAG, "SideEffect triggered. Current count: $count")
//        }

        // LaunchedEffect - Runs only when count changes
        LaunchedEffect(Unit) {
            Log.d(TAG, "LaunchedEffect triggered. Current count: $count")
        }
    }
}