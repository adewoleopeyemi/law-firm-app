package com.example.successsynergyapp.extensions

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

fun EditText.textToString(): String {
    return this.text.toString()
}

fun EditText.checkIsEmpty(): Boolean {
    return text == null || "" == textToString().trim() || text.toString().equals("null", ignoreCase = true)
}

fun EditText.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()
}

fun EditText.isValidPhone(): Boolean {
    return !TextUtils.isEmpty(text) && Patterns.PHONE.matcher(text).matches()
}

fun EditText.showError(error: String) {
    this.error = error
    this.showSoftKeyboard()
}

fun EditText.setTextSelection() = this.setSelection(this.text.length)

fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            cb(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}