package com.loyalar.numberplates.Logic

import com.google.gson.annotations.SerializedName

data class NumberPlate(@SerializedName("name") var name: String,
                       @SerializedName("numberplateText") var numberplateText: String,
                       @SerializedName("carMake") var carMake: String,
                       @SerializedName("carModelName") var carModelName: String) {

    override fun toString(): String {
        return "$name | $numberplateText | $carMake | $carModelName"
    }
}