package com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlin.math.roundToInt
import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.example.successsynergyapp.R
import java.text.DecimalFormat
import kotlin.math.roundToInt

fun Context.getAppColor(color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun View.applyBackgroundTintTheme2(color: Int) {
    (background as GradientDrawable).setColor(color)
    (background as GradientDrawable).setStroke(0, 0)
    background.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY)
}

fun AppCompatActivity.makeTransaprant() {
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}

fun View.setStrokedBackground(
    backgroundColor: Int,
    strokeColor: Int = 0,
    alpha: Float = 1.0f,
    strokeWidth: Int = 3
) {
    val drawable = background as GradientDrawable
    drawable.setStroke(strokeWidth, strokeColor)
    drawable.setColor(adjustAlpha(backgroundColor, alpha))
}

fun adjustAlpha(color: Int, factor: Float): Int {
    val alpha = (Color.alpha(color) * factor).roundToInt()
    val red = Color.red(color)
    val green = Color.green(color)
    val blue = Color.blue(color)
    return Color.argb(alpha, red, green, blue)
}


infix fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)



inline fun <T : View> T.onClick(crossinline func: T.() -> Unit) = setOnClickListener { func() }


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun Activity.snackBar(msg: String, length: Int = Snackbar.LENGTH_SHORT) =
    Snackbar.make(findViewById(android.R.id.content), msg, length).setTextColor(Color.WHITE).show()

fun Fragment.snackBar(msg: String) = activity!!.snackBar(msg)


fun Snackbar.setTextColor(color: Int): Snackbar {
    val tv = view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(color)
    return this
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) =
    supportFragmentManager.inTransaction { replace(frameId, fragment) }

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) =
    supportFragmentManager.inTransaction { add(frameId, fragment) }

fun AppCompatActivity.removeFragment(fragment: Fragment) =
    supportFragmentManager.inTransaction { remove(fragment) }

fun AppCompatActivity.showFragment(fragment: Fragment) = supportFragmentManager.inTransaction {
    setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
    show(fragment)
}

fun AppCompatActivity.hideFragment(fragment: Fragment) = supportFragmentManager.inTransaction {
    hide(fragment)
}

fun runDelayed(delayMillis: Long, action: () -> Unit) =
    Handler().postDelayed(Runnable(action), delayMillis)

fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(it, adapterPosition, itemViewType)
    }
    return this
}


fun Activity.toast(@StringRes stringRes: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, stringRes, duration).show()

fun Activity.hideSoftKeyboard() {
    if (currentFocus != null) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}


fun TextInputLayout.fontRegular(context: Context){
    //typeface=context.theme11AppFontRegular()
}
fun ImageView.applyColorFilter(color: Int) {
    drawable.let { DrawableCompat.wrap(it) }.let {
        DrawableCompat.setTint(it, color)
    }
}

fun TextView.applyStrike() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

inline fun <reified T : Any> Activity.launchActivityWithNewTask() {
    launchActivity<T> {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
}
fun View.changeColor(color: Int) {
    ((background as LayerDrawable).findDrawableByLayerId(R.id.itemShape) as GradientDrawable).setColor(color)
}

inline fun <reified T : Any> Activity.launchActivity(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }
}


inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)


internal fun Drawable.tint(@ColorInt color: Int): Drawable {
    val wrapped = DrawableCompat.wrap(this)
    DrawableCompat.setTint(wrapped, color)
    return wrapped
}

fun TextView.changeDrawableTint(color: Int) {
    compoundDrawables.forEach {
        if (it != null) {
            it.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }

}


fun RecyclerView.setVerticalLayout(aReverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, aReverseLayout)
}

fun RecyclerView.setHorizontalLayout(aReverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, aReverseLayout)
}


fun Activity.getVerticalLayout(aReverseLayout: Boolean = false): LinearLayoutManager {
    return LinearLayoutManager(this, RecyclerView.VERTICAL, aReverseLayout)
}

fun FragmentActivity.color(color: Int): Int = ContextCompat.getColor(this, color)

fun Int.toDecimalFormat() = DecimalFormat("00").format(this)!!
fun RecyclerView.rvItemAnimation() {

}

fun View.learAapplyStrokedBackground(
    backgroundColor: Int,
    strokeColor: Int = 0,
    alpha: Float = 1.0f,
    strokeWidth: Int = 5
) {
    val drawable = background as GradientDrawable
    drawable.setStroke(strokeWidth, strokeColor)
    drawable.setColor(theme11AdjustAlpha(backgroundColor, alpha))
}

fun theme11AdjustAlpha(color: Int, factor: Float): Int {
    val alpha = (Color.alpha(color) * factor).roundToInt()
    val red = Color.red(color)
    val green = Color.green(color)
    val blue = Color.blue(color)
    return Color.argb(alpha, red, green, blue)
}

fun Context.theme11AppColor(color: Int): Int {
    return ContextCompat.getColor(this, color)
}

/*fun View.changeColor(color: Int) {
    ((background as LayerDrawable).findDrawableByLayerId(R.id.itemShape) as GradientDrawable).setColor(
        color
    )
}*/

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeTranslucentStatusBar() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
    )
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
    window.setFlags(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
    )
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeNormalNavigationBar(navigationBarColor: Int = -1) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    window.decorView.rootView.systemUiVisibility = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor =
            if (navigationBarColor == -1) Color.BLACK else navigationBarColor
    }
}

fun Activity.lightStatusBar(statusBarColor: Int = -1) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        when (window.decorView.rootView.systemUiVisibility) {
            0 -> window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    window.decorView.rootView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                } else {
                    window.decorView.rootView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }
        window.statusBarColor = if (statusBarColor == -1) Color.WHITE else statusBarColor
    }
}

fun Activity.lightNavigation(navigationBarColor: Int = -1) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        when (window.decorView.rootView.systemUiVisibility) {
            0 -> window.decorView.rootView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR -> {
                window.decorView.rootView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        window.navigationBarColor =
            if (navigationBarColor == -1) Color.WHITE else navigationBarColor
    }
}

fun AppCompatActivity.loadImage(image: Int, imageView: ImageView) {
    Glide.with(this).load(image).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView)
}
