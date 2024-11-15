package com.uvg.rueda.lab_final_fr.presentation.assetProfile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.rueda.lab_final_fr.domain.model.Asset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssetProfileScreen(asset: Asset, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Perfil del Asset", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EA)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Name: ${asset.name}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EA)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Symbol: ${asset.symbol}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF333333))
            Text(text = "Price USD: ${asset.priceUsd}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF388E3C))
            Text(
                text = "24Hr Change: ${asset.changePercent24Hr}%",
                style = MaterialTheme.typography.bodyMedium,
                color = if (asset.changePercent24Hr.toDoubleOrNull() ?: 0.0 >= 0) Color(0xFF388E3C) else Color(0xFFD32F2F)
            )
            Text(text = "Supply: ${asset.supply}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF333333))
            Text(text = "Max Supply: ${asset.maxSupply ?: "N/A"}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF333333))
            Text(text = "Market Cap USD: ${asset.marketCapUsd}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF333333))
            Text(text = "Last Updated: ${asset.lastUpdated}", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF666666)) 
        }
    }
}
