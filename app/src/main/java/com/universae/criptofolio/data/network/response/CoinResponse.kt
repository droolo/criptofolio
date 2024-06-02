package com.universae.criptofolio.data.network.response

import com.google.gson.annotations.SerializedName
import com.universae.criptofolio.data.model.CoinModel
import com.universae.criptofolio.domain.model.Coin


data class CoinResponse(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name : String,
    @SerializedName("symbol") var symbol : String,
)


fun CoinResponse.toDomain(): Coin {
    return Coin(
        id = id,
        symbol = symbol,
        name = name
    )
}

