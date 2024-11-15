// AssetListViewModel.kt
package com.uvg.rueda.lab_final_fr.presentation.assetList

import androidx.lifecycle.ViewModel
import com.uvg.rueda.lab_final_fr.domain.model.Asset

class AssetListViewModel : ViewModel() {
    private val sampleAssets = listOf(
        Asset("1", "Bitcoin", "BTC", "50000", "2.3", "1000", "2100000", "10000000", "2023-11-14"),
        Asset("2", "Ethereum", "ETH", "4000", "-1.5", "1000", null, "500000", "2023-11-14")
    )

    fun getAssets(): List<Asset> = sampleAssets
}
