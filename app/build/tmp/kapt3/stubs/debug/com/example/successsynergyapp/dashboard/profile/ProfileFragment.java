package com.example.successsynergyapp.dashboard.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014\u00a8\u0006-"}, d2 = {"Lcom/example/successsynergyapp/dashboard/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/successsynergyapp/databinding/FragmentProfileBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/FragmentProfileBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/FragmentProfileBinding;)V", "bindingUSer", "Lcom/example/successsynergyapp/databinding/LayoutUserProfileBinding;", "getBindingUSer", "()Lcom/example/successsynergyapp/databinding/LayoutUserProfileBinding;", "setBindingUSer", "(Lcom/example/successsynergyapp/databinding/LayoutUserProfileBinding;)V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "forWhat", "getForWhat", "setForWhat", "serviceProviderRef", "Lcom/google/firebase/database/DatabaseReference;", "getServiceProviderRef", "()Lcom/google/firebase/database/DatabaseReference;", "setServiceProviderRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "uid", "getUid", "setUid", "fetchRealUserDetails", "", "fetchUserDetails", "initOnClickListeners", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.FragmentProfileBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.LayoutUserProfileBinding bindingUSer;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference serviceProviderRef;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String uid;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String category;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String forWhat;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.FragmentProfileBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.FragmentProfileBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.LayoutUserProfileBinding getBindingUSer() {
        return null;
    }
    
    public final void setBindingUSer(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.LayoutUserProfileBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getServiceProviderRef() {
        return null;
    }
    
    public final void setServiceProviderRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getForWhat() {
        return null;
    }
    
    public final void setForWhat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void fetchUserDetails() {
    }
    
    private final void fetchRealUserDetails() {
    }
    
    private final void initOnClickListeners() {
    }
    
    public ProfileFragment() {
        super();
    }
}