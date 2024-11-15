// AssetProfileViewModel.kt
package com.uvg.rueda.lab_final_fr.presentation.assetProfile

import androidx.lifecycle.ViewModel
import com.uvg.rueda.lab_final_fr.domain.model.Asset

class AssetProfileViewModel : ViewModel() {
    fun getAssetDetails(asset: Asset): Asset {
        return asset
    }
}
