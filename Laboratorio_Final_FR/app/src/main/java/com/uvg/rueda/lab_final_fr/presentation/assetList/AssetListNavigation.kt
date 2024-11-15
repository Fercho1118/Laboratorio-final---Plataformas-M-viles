// AssetListNavigation.kt
package com.uvg.rueda.lab_final_fr.presentation.navigation

import com.uvg.rueda.lab_final_fr.domain.model.Asset
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

sealed class Screen(val route: String) {
    object AssetList : Screen("assetList")
    object AssetProfile : Screen("assetProfile/{asset}") {
        fun createRoute(asset: Asset): String {
            val assetJson = Json.encodeToString(asset)
            return "assetProfile/$assetJson"
        }
    }
}
