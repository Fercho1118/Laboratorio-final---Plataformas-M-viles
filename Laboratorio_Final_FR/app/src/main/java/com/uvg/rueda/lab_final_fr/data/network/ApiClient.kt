package com.uvg.rueda.lab_final_fr.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import com.uvg.rueda.lab_final_fr.data.network.dto.AssetDto
import io.ktor.client.statement.bodyAsText

class ApiClient {
    private val client = HttpClient(CIO) {

    }

    suspend fun getAssets(): List<AssetDto> {
        val response: HttpResponse = client.get("https://api.coincap.io/v2/assets")
        val jsonBody = response.bodyAsText()
        val data = Json.decodeFromString<Map<String, List<AssetDto>>>(jsonBody)
        return data["data"] ?: emptyList()
    }
}
