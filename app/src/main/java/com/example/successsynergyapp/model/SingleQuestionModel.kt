package com.example.successsynergyapp.model

import com.google.gson.annotations.SerializedName

class SingleQuestionModel {
    @SerializedName("Question")
    var question = ""
    @SerializedName("requiresTyping")
    var requiresTyping = false
    @SerializedName("isBoolean")
    var isBoolean = false
    @SerializedName("position")
    var position = 0
    @SerializedName("answer")
    var answer = ""
}