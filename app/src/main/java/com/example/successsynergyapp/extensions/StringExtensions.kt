package com.example.successsynergyapp.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Base64
import androidx.core.text.HtmlCompat
import java.security.MessageDigest
import java.util.regex.Pattern
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun String.getString(): String {
    return if (this.checkIsEmpty()) {
        this
    } else {
        ""
    }
}

fun String.checkIsEmpty(): Boolean {
    return isNullOrEmpty() || "" == this || this.equals("null", ignoreCase = true)
}

fun String.isValidPhoneNumber(): Boolean {
    return this.matches("^(((\\+?\\(91\\))|0|((00|\\+)?91))-?)?[7-9]\\d{9}$".toRegex())
}

fun String.isValidIPAddress(): Boolean {
    val compile = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$")
    val pattern = compile
    return compile.matcher(this).find()
}

fun String.toCamelCase(): String {
    var stringBuilder = StringBuilder()
    try {
        val toLowerCase = this.toLowerCase()
        if (toLowerCase.isNotEmpty()) {
            for (toProperCase in toLowerCase.trim { it <= ' ' }.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                stringBuilder.append(" ").append(toProperCase(toProperCase))
            }
        }
    } catch (e: NullPointerException) {
        stringBuilder = StringBuilder()
    }

    return stringBuilder.toString()
}

fun toProperCase(str: String): String {
    return try {
        if (str.isNotEmpty()) str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase() else ""
    } catch (e: NullPointerException) {
        ""
    }
}

/**
 * returns the md5 of the String
 */
fun String.md5() = encrypt(this, "MD5")

/**
 * encode The String to Binary
 */
fun String.encodeToBinary(): String {
    val stringBuilder = StringBuilder()
    toCharArray().forEach {
        stringBuilder.append(Integer.toBinaryString(it.toInt()))
        stringBuilder.append(" ")
    }
    return stringBuilder.toString()
}

/**
 * Decode the String from binary
 */
fun String.deCodeToBinary(): String {
    val stringBuilder = StringBuilder()
    split(" ").forEach {
        stringBuilder.append(Integer.parseInt(it.replace(" ", ""), 2))
    }
    return stringBuilder.toString()
}

/**
 * Encrypt String to AES with the specific Key
 */
fun String.encryptAES(key: String): String {
    var crypted: ByteArray? = null
    try {
        val skey = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, skey)
        crypted = cipher.doFinal(toByteArray())
    } catch (e: Exception) {
        println(e.toString())
    }
    return String(Base64.encode(crypted, Base64.DEFAULT))
}

/**
 * Decrypt String to AES with the specific Key
 */
fun String.decryptAES(key: String): String {
    var output: ByteArray? = null
    try {
        val skey = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, skey)
        output = cipher.doFinal(Base64.decode(this, Base64.DEFAULT))
    } catch (e: Exception) {
        println(e.toString())
    }
    return output?.let { String(it) } ?: ""
}

/**
 * return SHA1 of the String
 */
fun String.sha1() = encrypt(this, "SHA-1")

private fun encrypt(string: String?, type: String): String {
    val bytes = MessageDigest.getInstance(type).digest(string!!.toByteArray())
    return bytes2Hex(bytes)
}

internal fun bytes2Hex(bts: ByteArray): String {
    var des = ""
    var tmp: String
    for (i in bts.indices) {
        tmp = Integer.toHexString(bts[i].toInt() and 0xFF)
        if (tmp.length == 1) {
            des += "0"
        }
        des += tmp
    }
    return des
}

fun String.getHtmlString(): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    Html.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
} else {
    Html.fromHtml(this)
}