package com.example.successsynergyapp.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

inline fun <T : View> T.onClick(crossinline func: T.() -> Unit) {
    setOnClickListener { func() }
}

inline fun <T : View> T.onLongClick(crossinline func: T.() -> Unit) {
    setOnLongClickListener { func(); true }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment)
    }
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.showFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun Snackbar.setTextColor(color: Int): Snackbar {
    val tv = view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(color)

    return this
}

fun async(run: () -> Unit) = Thread(run).start()

fun Activity.ui(run: () -> Unit) = runOnUiThread(run)

fun withDelay(delay: Long = 1000, block: () -> Unit) {
    Handler().postDelayed(Runnable(block), delay)
}

fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(it, adapterPosition, itemViewType)
    }
    return this
}

infix fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun Activity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    activity?.toast(text, duration)
}

fun Activity.toast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun Fragment.toast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) {
    activity?.toast(text, duration)
}

fun Fragment.hideSoftKeyboard() {
    activity?.hideSoftKeyboard()
}

fun Activity.hideSoftKeyboard() {
    if (currentFocus != null) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

inline fun <reified T : Any> Activity.launchActivityWithNewTask() {
    launchActivity<T> {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
}

inline fun <reified T : Any> Activity.launchActivity(requestCode: Int = -1, options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }
}

fun FragmentActivity.requestPermission(permission: String, onResult: (isGranted: Boolean) -> Unit) {
    if (isPermissionGranted(arrayOf(permission))) {
        onResult(true)
        return
    }
    val observer = PermissionObserver()
    observer.onResumeCallback = {
        lifecycle.removeObserver(observer)
        onResult(isPermissionGranted(arrayOf(permission)))
    }
    lifecycle.addObserver(observer)
    ActivityCompat.requestPermissions(this, arrayOf(permission), 100)
}

fun FragmentActivity.requestPermissions(permissions: Array<String>, onResult: (isGranted: Boolean) -> Unit) {
    if (isPermissionGranted(permissions)) {
        onResult(true)
        return
    }
    val observer = PermissionObserver()
    observer.onResumeCallback = {
        lifecycle.removeObserver(observer)
        onResult(isPermissionGranted(permissions))
    }
    lifecycle.addObserver(observer)
    ActivityCompat.requestPermissions(this, permissions, 100)
}

private class PermissionObserver : LifecycleObserver {
    var onResumeCallback: (() -> Unit)? = null
    var readyToCheck = false
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        readyToCheck = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        if (readyToCheck)
            onResumeCallback?.invoke()
        readyToCheck = false
    }
}

fun Activity.makeTransparent() {
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeTranslucentStatusBar() {
    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeNormalStatusBar(statusBarColor: Int = -1) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.decorView.rootView.systemUiVisibility = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = if (statusBarColor == -1) Color.BLACK else statusBarColor
    }
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeTranslucentNavigationBar() {
    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeNormalNavigationBar(navigationBarColor: Int = -1) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    window.decorView.rootView.systemUiVisibility = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = if (navigationBarColor == -1) Color.BLACK else navigationBarColor
    }
}

fun Activity.lightStatusBar(statusBarColor: Int = -1) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        when (window.decorView.rootView.systemUiVisibility) {
            0 -> window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                } else {
                    window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }
        window.statusBarColor = if (statusBarColor == -1) Color.WHITE else statusBarColor
    }
}

fun Activity.lightNavigation(navigationBarColor: Int = -1) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        when (window.decorView.rootView.systemUiVisibility) {
            0 -> window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR -> {
                window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        window.navigationBarColor = if (navigationBarColor == -1) Color.WHITE else navigationBarColor
    }
}

fun Activity.actionDial(tel: String) {
    startActivity(Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:${tel}")
    })
}

fun Fragment.actionDial(tel: String) {
    activity?.actionDial(tel)
}

fun shareMyApp(context: Context, subject: String, message: String) {
    try {
        val appUrl = "https://play.google.com/store/apps/details?id=${context.packageName}"
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        var leadingText = "\n" + message + "\n\n"
        leadingText += appUrl + "\n\n"
        i.putExtra(Intent.EXTRA_TEXT, leadingText)
        context.startActivity(Intent.createChooser(i, "Share using"))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun shareText(context: Context, text: String) {
    val share = Intent(Intent.ACTION_SEND)
    share.type = "text/plain"
    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
    share.putExtra(Intent.EXTRA_TEXT, text)
    context.startActivity(Intent.createChooser(share, "Share"))
}

fun TabLayout.tabSelectedListener(onTabSelect: (p0: TabLayout.Tab) -> Unit) {
    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(p0: TabLayout.Tab?) {}

        override fun onTabSelected(p0: TabLayout.Tab) {
            onTabSelect(p0)
        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {}
    })
}

fun TextView.applyStrike() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}
