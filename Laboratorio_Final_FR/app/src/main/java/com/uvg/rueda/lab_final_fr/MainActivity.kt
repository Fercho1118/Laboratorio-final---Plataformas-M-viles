package com.uvg.rueda.lab_final_fr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.uvg.rueda.lab_final_fr.presentation.navigation.AssetNavHost
import com.uvg.rueda.lab_final_fr.ui.theme.Lab_final_frTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_final_frTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AssetNavHost(navController = navController)
                }
            }
        }
    }
}
