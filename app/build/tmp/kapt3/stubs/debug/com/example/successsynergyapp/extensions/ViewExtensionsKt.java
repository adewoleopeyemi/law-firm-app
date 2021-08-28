package com.example.successsynergyapp.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f\u001a\u0012\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f\u001a\u0014\u0010\u0011\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f\u001a\n\u0010\u0012\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0002\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0002\u001a\n\u0010\u0018\u001a\u00020\u0016*\u00020\u0002\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u0002\u001a\u0012\u0010\u001b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0016\u001a\n\u0010\u001d\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u001e\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u001f\u001a\u00020\n*\u00020\u0002\u001a\u001c\u0010 \u001a\u00020\n*\u00020!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\f\u001a\u0012\u0010 \u001a\u00020\n*\u00020%2\u0006\u0010\"\u001a\u00020#\u001a\n\u0010&\u001a\u00020\n*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\'"}, d2 = {"ctx", "Landroid/content/Context;", "Landroid/view/View;", "getCtx", "(Landroid/view/View;)Landroid/content/Context;", "res", "Landroid/content/res/Resources;", "getRes", "(Landroid/view/View;)Landroid/content/res/Resources;", "changeBackgroundColor", "", "newColor", "", "duration", "changeBackgroundTint", "color", "fadeIn", "fadeOut", "gone", "hideSoftKeyboard", "invisible", "isGone", "", "isInvisible", "isVisible", "screenshot", "Landroid/graphics/Bitmap;", "showIf", "condition", "showSoftKeyboard", "slideDown", "slideUp", "snackBar", "Landroid/app/Activity;", "msg", "", "length", "Landroidx/fragment/app/Fragment;", "visible", "app_debug"})
public final class ViewExtensionsKt {
    
    public static final void snackBar(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$snackBar, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, int length) {
    }
    
    public static final void snackBar(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$snackBar, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public static final void hideSoftKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hideSoftKeyboard) {
    }
    
    public static final void showSoftKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showSoftKeyboard) {
    }
    
    public static final void changeBackgroundColor(@org.jetbrains.annotations.NotNull()
    android.view.View $this$changeBackgroundColor, @androidx.annotation.ColorInt()
    int newColor, int duration) {
    }
    
    /**
     * Create a Screnshot of the view and returns it as a Bitmap
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Bitmap screenshot(@org.jetbrains.annotations.NotNull()
    android.view.View $this$screenshot) {
        return null;
    }
    
    /**
     * Start The FadeIn Animation on This View
     */
    public static final void fadeIn(@org.jetbrains.annotations.NotNull()
    android.view.View $this$fadeIn, int duration) {
    }
    
    /**
     * Start the FadeOut Animation on This View
     */
    public static final void fadeOut(@org.jetbrains.annotations.NotNull()
    android.view.View $this$fadeOut, int duration) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.content.res.Resources getRes(@org.jetbrains.annotations.NotNull()
    android.view.View $this$res) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.content.Context getCtx(@org.jetbrains.annotations.NotNull()
    android.view.View $this$ctx) {
        return null;
    }
    
    public static final void showIf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showIf, boolean condition) {
    }
    
    public static final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
    }
    
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    public static final void invisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisible) {
    }
    
    public static final boolean isVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$isVisible) {
        return false;
    }
    
    public static final boolean isGone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$isGone) {
        return false;
    }
    
    public static final boolean isInvisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$isInvisible) {
        return false;
    }
    
    public static final void changeBackgroundTint(@org.jetbrains.annotations.NotNull()
    android.view.View $this$changeBackgroundTint, int color) {
    }
    
    public static final void slideUp(@org.jetbrains.annotations.NotNull()
    android.view.View $this$slideUp) {
    }
    
    public static final void slideDown(@org.jetbrains.annotations.NotNull()
    android.view.View $this$slideDown) {
    }
}