package com.example.covidapp

import com.google.gson.annotations.SerializedName

data class InfoModel(
    var loc                   : String? = null,
    var confirmedCasesIndian  : Int?    = null,
    var confirmedCasesForeign : Int?    = null,
    var discharged            : Int?    = null,
    var deaths                : Int?    = null,
    var totalConfirmed        : Int?    = null
)
