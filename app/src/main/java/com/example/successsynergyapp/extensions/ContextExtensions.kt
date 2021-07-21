package com.example.successsynergyapp.extensions

import android.Manifest
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.*
import androidx.core.content.ContextCompat
import java.util.*

fun Context.isGPSEnable(): Boolean = getLocationManager().isProviderEnabled(LocationManager.GPS_PROVIDER)
fun Context.isNetworkProviderEnable(): Boolean = getLocationManager().isProviderEnabled(LocationManager.NETWORK_PROVIDER)

fun Context.getLocationManager() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isNetworkAvailable(): Boolean {
    val info = getConnectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}

fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * Get a theme color from an attribute res
 *
 * @param attributeColor attribute key for the color
 */
@ColorInt
fun Context.getThemeColor(@AttrRes attributeColor: Int): Int {
    val value = TypedValue()
    theme.resolveAttribute(attributeColor, value, true)
    return value.data
}

inline fun <reified T : Any> Context.launchActivity(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}

fun Context.startApp(pName: String) =
        if (isAppInstalled(pName)) startActivity(packageManager.getLaunchIntentForPackage(pName)) else {
        }

/**
 * Check if an App is Installed on the user device.
 */
fun Context.isAppInstalled(packageName: String): Boolean {
    return try {
        packageManager.getApplicationInfo(packageName, 0)
        true
    } catch (ignore: Exception) {
        false
    }
}

@Throws(PackageManager.NameNotFoundException::class)
fun Context.getAppVersionName(pName: String = packageName): String {
    return packageManager.getPackageInfo(pName, 0).versionName
}

@Throws(PackageManager.NameNotFoundException::class)
fun Context.getAppVersionCode(pName: String = packageName): Int {
    return packageManager.getPackageInfo(pName, 0).versionCode
}

fun Context.dialNumber(number: String) {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
}

/**
 * Open Default Email Client with the [mailID] preSetted
 */
fun Context.sendEmail(mailID: String) {
    startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$mailID")))
}

/**
 * Show Date Picker and Get the Picked Date Easily
 */
fun Context.showDatePicker(year: Int, month: Int, day: Int, onDatePicked: (year: Int, month: Int, day: Int) -> Unit) {
    DatePickerDialog(this, { _, pyear, pmonth, pdayOfMonth ->
        onDatePicked(pyear, pmonth, pdayOfMonth)
    }, year, month, day).show()
}

/**
 * Show the Time Picker and Get the Picked Time Easily
 */
fun Context.showTimePicker(currentDate: Date = Date(), is24Hour: Boolean = false, onDatePicked: (hour: Int, minute: Int) -> Unit) {
    @Suppress("DEPRECATION")
    TimePickerDialog(this, { _, hourOfDay, minute ->
        onDatePicked(hourOfDay, minute)

    }, currentDate.hours, currentDate.minutes, is24Hour).show()
}

fun Context.isPermissionGranted(permissions: Array<String>): Boolean {
    permissions.forEach {
        if (ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED)
            return false
    }
    return true
}

fun Context.colors(@ColorRes aId: Int) : Int = this.resources.getColor(aId)
fun Context.drawables(@DrawableRes aId: Int) : Drawable = this.resources.getDrawable(aId)
fun Context.strings(@StringRes aId: Int): String = this.resources.getString(aId)
fun Context.layouts(@LayoutRes aId: Int) = this.resources.getLayout(aId)

fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.isNotEmpty())
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.isNotEmpty())
        intent.putExtra(Intent.EXTRA_TEXT, text)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }
    return false
}