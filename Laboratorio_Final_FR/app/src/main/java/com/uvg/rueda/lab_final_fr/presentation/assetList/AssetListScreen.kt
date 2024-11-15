package com.uvg.rueda.lab_final_fr.presentation.assetList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.rueda.lab_final_fr.domain.model.Asset

@Composable
fun AssetListScreen(
    assets: List<Asset>,
    onAssetClick: (Asset) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF2F2F2))
    ) {
        Text(
            text = "Assets List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EA),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        assets.forEach { asset ->
            AssetListItem(asset = asset, onClick = { onAssetClick(asset) })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun AssetListItem(asset: Asset, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = asset.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
            Text(
                text = "Symbol: ${asset.symbol}",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
            Text(
                text = "Price: ${asset.priceUsd} USD",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF388E3C)
            )
            Text(
                text = "24Hr Change: ${asset.changePercent24Hr}%",
                fontSize = 14.sp,
                color = if (asset.changePercent24Hr.toDoubleOrNull() ?: 0.0 >= 0) Color(0xFF388E3C) else Color(0xFFD32F2F)
            )
        }
    }
}
