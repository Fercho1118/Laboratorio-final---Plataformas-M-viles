package com.uvg.rueda.lab_final_fr.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String?,
    val maxSupply: String?,
    val marketCapUsd: String?,
    val lastUpdated: String?
)
