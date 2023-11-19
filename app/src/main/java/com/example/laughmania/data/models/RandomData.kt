package com.example.laughmania.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomData(
    @SerialName("categories")
    val categories: List<String?>,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("icon_url")
    val iconUrl: String?,
    @SerialName("id")
    val id: String,
    @SerialName("updated_at")
    val updatedAt: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("value")
    val value: String?
)