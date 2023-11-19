package com.example.laughmania.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseRandomData(
    @SerializedName("random")
    val random : List<RandomData>
)