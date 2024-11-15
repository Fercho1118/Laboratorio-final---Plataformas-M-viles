package com.uvg.rueda.lab_final_fr.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.uvg.rueda.lab_final_fr.domain.model.Asset
import com.uvg.rueda.lab_final_fr.presentation.assetList.AssetListScreen
import com.uvg.rueda.lab_final_fr.presentation.assetList.AssetListViewModel
import com.uvg.rueda.lab_final_fr.presentation.assetProfile.AssetProfileScreen
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun AssetNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.AssetList.route) {
        composable(route = Screen.AssetList.route) {
            val viewModel = AssetListViewModel()
            AssetListScreen(
                assets = viewModel.getAssets(),
                onAssetClick = { asset ->
                    navController.navigate(Screen.AssetProfile.createRoute(asset))
                }
            )
        }
        composable(
            route = Screen.AssetProfile.route,
            arguments = listOf(navArgument("asset") { type = NavType.StringType })
        ) { backStackEntry ->
            val assetJson = backStackEntry.arguments?.getString("asset")
            val asset = assetJson?.let { Json.decodeFromString<Asset>(it) }
            asset?.let {
                AssetProfileScreen(asset = it, navController = navController)
            }
        }
    }
}
