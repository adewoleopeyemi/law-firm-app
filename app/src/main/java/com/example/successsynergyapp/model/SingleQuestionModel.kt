package com.example.successsynergyapp.model

import com.google.gson.annotations.SerializedName

class SingleQuestionModel {
    @SerializedName("Question")
    var question = ""
    @SerializedName("Ans1")
    var ans1 = ""
    @SerializedName("Ans2")
    var ans2 = ""
    @SerializedName("Ans3")
    var ans3 = ""
    @SerializedName("Ans4")
    var ans4 = ""
    @SerializedName("isSelected")
    var isSelected :Int? = 0
    @SerializedName("requiresTyping")
    var requiresTyping = false

}