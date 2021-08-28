package com.example.successsynergyapp.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0007R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/successsynergyapp/extensions/PermissionObserver;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "onResumeCallback", "Lkotlin/Function0;", "", "getOnResumeCallback", "()Lkotlin/jvm/functions/Function0;", "setOnResumeCallback", "(Lkotlin/jvm/functions/Function0;)V", "readyToCheck", "", "getReadyToCheck", "()Z", "setReadyToCheck", "(Z)V", "onPause", "onResume", "app_debug"})
final class PermissionObserver implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onResumeCallback;
    private boolean readyToCheck = false;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnResumeCallback() {
        return null;
    }
    
    public final void setOnResumeCallback(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    public final boolean getReadyToCheck() {
        return false;
    }
    
    public final void setReadyToCheck(boolean p0) {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_RESUME)
    public final void onResume() {
    }
    
    public PermissionObserver() {
        super();
    }
}