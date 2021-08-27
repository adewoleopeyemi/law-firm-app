package com.iqonic.theme6.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import java.io.Serializable

data class CategoryData(var name: String? = null, @DrawableRes var image: Int? = null, @ColorRes var color: Int? = null)

data class BestDestinationData(var name: String? = null, var rating: Int? = null, @DrawableRes var image: Int? = null) : Serializable

data class RecentSearchData(var name: String? = null)

data class BestHotelData(var name: String? = null, var price: String? = null, var address: String? = null, var room_detail: String? = null, var hotel_review: String? = null, var rating: Int? = null, @DrawableRes var image: Int? = null) : Serializable