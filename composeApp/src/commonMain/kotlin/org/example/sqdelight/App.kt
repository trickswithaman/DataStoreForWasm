package org.example.sqdelight

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import sqdelighttest.composeapp.generated.resources.Res
import sqdelighttest.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(viewModel: SessionViewModel) {
    MaterialTheme {
        /*var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
        LoginScreen(viewModel = viewModel)

    }
}


@Composable
fun LoginScreen(viewModel: SessionViewModel) {
    var token by remember { mutableStateOf("") }

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
        // Add session state display
        Text(
            text = viewModel.sessionState?.let {
                "Logged in as: ${it.token}"
            } ?: "Not logged in",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = token,
            onValueChange = { token = it },
            label = { Text("Enter Token") }
        )

        Button(onClick = { viewModel.login(token) }) {
            Text("Login")
        }

        Button(onClick = { viewModel.logout() }) {
            Text("Logout")
        }
    }
}