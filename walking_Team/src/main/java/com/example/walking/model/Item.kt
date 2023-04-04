package com.example.walking.model

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
    @SerializedName("MAIN_TITLE") //여행지 이름
    val MAIN_TITLE: String,
    @SerializedName("MAIN_IMG_THUMB") //메인 이미지
    val MAIN_IMG_THUMB: String,
    @SerializedName("ITEMCNTNTS") //본문 텍스트
    val ITEMCNTNTS: String,
    @SerializedName("LAT")  //위도 좌표
    val LAT: String,
    @SerializedName("LNG")  //경도 좌표
    val LNG: String,
    @SerializedName("UC_SEQ") //json 소스 고유번호
    val UC_SEQ: Int
)