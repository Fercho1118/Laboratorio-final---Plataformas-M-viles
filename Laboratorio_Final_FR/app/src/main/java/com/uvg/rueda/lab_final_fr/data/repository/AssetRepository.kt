package com.uvg.rueda.lab_final_fr.data.repository

import com.uvg.rueda.lab_final_fr.data.network.ApiClient
import com.uvg.rueda.lab_final_fr.data.network.dto.toDomainModel
import com.uvg.rueda.lab_final_fr.domain.model.Asset

class AssetRepository(private val apiClient: ApiClient) {

    suspend fun fetchAssets(): List<Asset> {
        return try {
            val assetsDto = apiClient.getAssets()
            assetsDto.map { it.toDomainModel() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
