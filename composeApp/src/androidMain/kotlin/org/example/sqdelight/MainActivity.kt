package org.example.sqdelight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

/*        startKoin {
            androidContext(this@MainActivity)
            modules(appModule) // 👈 Add your module(s) here
        }*/


        setContent {
            val viewModel: SessionViewModel by inject() // 👈

            App(viewModel)
        }
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
    App(viewModel = viewModel())
}