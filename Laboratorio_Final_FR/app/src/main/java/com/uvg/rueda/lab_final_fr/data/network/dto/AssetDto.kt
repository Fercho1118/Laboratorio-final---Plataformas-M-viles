package com.uvg.rueda.lab_final_fr.data.network.dto

import com.uvg.rueda.lab_final_fr.domain.model.Asset
import kotlinx.serialization.Serializable

@Serializable
data class AssetDto(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String?,
    val maxSupply: String?,
    val marketCapUsd: String?
)

fun AssetDto.toDomainModel(): Asset {
    return Asset(
        id = id,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        supply = supply,
        maxSupply = maxSupply,
        marketCapUsd = marketCapUsd,
        lastUpdated = null
    )
}
