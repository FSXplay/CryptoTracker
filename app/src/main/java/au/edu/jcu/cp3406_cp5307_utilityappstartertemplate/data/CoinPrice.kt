package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

import com.google.gson.annotations.SerializedName

data class CoinPrice(
        val id: String,
        val name: String,
        @SerializedName("current_price") val currentPrice: Double,
        @SerializedName("price_change_percentage_24h_in_currency") val change24h: Double?,
        @SerializedName("price_change_percentage_7d_in_currency") val change7d: Double?,
        @SerializedName("price_change_percentage_30d_in_currency") val change30d: Double?,
        @SerializedName("price_change_percentage_1y_in_currency") val change1y: Double?
)
