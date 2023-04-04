package com.example.k1109_chc_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Walking(
    @Expose
    @SerializedName("getWalkingKr")
    val getWalkingKr: GetWalkingKr
)

data class GetWalkingKr(
    @Expose
    @SerializedName("item")
    val item: MutableList<Item>
)

data class Item(
    @Expose
    @SerializedName("MAIN_TITLE")
    val MAIN_TITLE: String,
    @SerializedName("MAIN_IMG_THUMB")
    val MAIN_IMG_THUMB: String
)

