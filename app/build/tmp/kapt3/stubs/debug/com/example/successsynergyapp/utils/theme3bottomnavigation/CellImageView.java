package com.example.successsynergyapp.utils.theme3bottomnavigation;

import java.lang.System;

@kotlin.Suppress(names = {"unused", "LeakingThis", "MemberVisibilityCanBePrivate"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\u0018\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0014J\u0018\u0010/\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R$\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R$\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b\u00a8\u00060"}, d2 = {"Lcom/example/successsynergyapp/utils/theme3bottomnavigation/CellImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBackgroundAlpha", "", "allowDraw", "changeSize", "value", "color", "getColor", "()I", "setColor", "(I)V", "colorAnimator", "Landroid/animation/ValueAnimator;", "fitImage", "isBitmap", "()Z", "setBitmap", "(Z)V", "resource", "getResource", "setResource", "size", "getSize", "setSize", "useColor", "getUseColor", "setUseColor", "changeColorByAnim", "", "newColor", "d", "", "draw", "initializeView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAttributeFromXml", "app_debug"})
public final class CellImageView extends androidx.appcompat.widget.AppCompatImageView {
    private boolean isBitmap = false;
    private boolean useColor = true;
    private int resource = 0;
    private int color = 0;
    private int size;
    private boolean actionBackgroundAlpha = false;
    private boolean changeSize = true;
    private boolean fitImage = false;
    private android.animation.ValueAnimator colorAnimator;
    private boolean allowDraw = false;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean isBitmap() {
        return false;
    }
    
    public final void setBitmap(boolean value) {
    }
    
    public final boolean getUseColor() {
        return false;
    }
    
    public final void setUseColor(boolean value) {
    }
    
    public final int getResource() {
        return 0;
    }
    
    public final void setResource(int value) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int value) {
    }
    
    public final int getSize() {
        return 0;
    }
    
    public final void setSize(int value) {
    }
    
    private final void setAttributeFromXml(android.content.Context context, android.util.AttributeSet attrs) {
    }
    
    private final void initializeView() {
    }
    
    private final void draw() {
    }
    
    public final void changeColorByAnim(int newColor, long d) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    public CellImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public CellImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public CellImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
}