package com.universae.criptofolio.model

import com.google.gson.annotations.SerializedName

data class CriptoResponse<T> (

//@SerializedName("status" ) var status : Status?         = Status(),
@SerializedName("data") var data   : List<T>
)
