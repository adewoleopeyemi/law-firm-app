package com.example.successsynergyapp.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.TransitionDrawable
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


fun Activity.snackBar(msg: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(findViewById(android.R.id.content), msg, length).setTextColor(Color.WHITE).show()
}

fun Fragment.snackBar(msg: String) {
    activity!!.snackBar(msg)
}

fun View.hideSoftKeyboard() {
    this.clearFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

fun View.changeBackgroundColor(@ColorInt newColor: Int, duration: Int = 300) {
    val oldBackground = background
    val color = ColorDrawable(newColor)
    val ld = LayerDrawable(arrayOf<Drawable>(color))
    if (oldBackground == null) background = ld
    else {
        val td = TransitionDrawable(arrayOf(oldBackground, ld))
        background = td
        td.startTransition(duration)
    }
}

/**
 * Create a Screnshot of the view and returns it as a Bitmap
 */
fun View.screenshot(): Bitmap {
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bmp)
    draw(canvas)
    canvas.save()
    return bmp
}

/**
 * Start The FadeIn Animation on This View
 */
fun View.fadeIn(duration: Int = 400) {
    clearAnimation()
    val alphaAnimation = AlphaAnimation(this.alpha, 1.0f)
    alphaAnimation.duration = duration.toLong()
    startAnimation(alphaAnimation)
}

/**
 * Start the FadeOut Animation on This View
 */
fun View.fadeOut(duration: Int = 400) {
    clearAnimation()
    val alphaAnimation = AlphaAnimation(this.alpha, 0.0f)
    alphaAnimation.duration = duration.toLong()
    startAnimation(alphaAnimation)
}

val View.res: Resources get() = resources
val View.ctx: Context get() = context

fun View.showIf(condition: Boolean) = if (condition) visible() else gone()

fun View.visible() {
  visibility = View.VISIBLE
}

fun View.gone() {
  visibility = View.GONE
}

fun View.invisible() {
  visibility = View.INVISIBLE
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isGone() = visibility == View.GONE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.changeBackgroundTint(color: Int) {
    background.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY)
}

fun View.slideUp() {
    this.visibility = View.VISIBLE
    val animate = TranslateAnimation(0.toFloat(), 0.toFloat(), this.height.toFloat(), 0.toFloat())
    animate.duration = 700
    animate.fillAfter = true
    this.startAnimation(animate)
}

fun View.slideDown() {
    this.visibility = View.GONE
    val animate = TranslateAnimation(0.toFloat(), 0.toFloat(), 0.toFloat(), this.height.toFloat())
    animate.duration = 700
    animate.fillAfter = true
    this.startAnimation(animate)
}
