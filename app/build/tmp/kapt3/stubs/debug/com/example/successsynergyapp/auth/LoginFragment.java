package com.example.successsynergyapp.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#\u00a8\u00064"}, d2 = {"Lcom/example/successsynergyapp/auth/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/successsynergyapp/databinding/FragmentLoginBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/FragmentLoginBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/FragmentLoginBinding;)V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFirebaseAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "forWhat", "getForWhat", "setForWhat", "pd", "Landroid/app/ProgressDialog;", "getPd", "()Landroid/app/ProgressDialog;", "setPd", "(Landroid/app/ProgressDialog;)V", "serviceProviderRef", "Lcom/google/firebase/database/DatabaseReference;", "getServiceProviderRef", "()Lcom/google/firebase/database/DatabaseReference;", "setServiceProviderRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "userRef", "getUserRef", "setUserRef", "fetchUserCategory", "", "uid", "initFirebaseLogin", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class LoginFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.FragmentLoginBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth firebaseAuth;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference serviceProviderRef;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference userRef;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String forWhat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String category;
    @org.jetbrains.annotations.Nullable()
    private android.app.ProgressDialog pd;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.FragmentLoginBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.FragmentLoginBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    public final void setFirebaseAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getServiceProviderRef() {
        return null;
    }
    
    public final void setServiceProviderRef(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getUserRef() {
        return null;
    }
    
    public final void setUserRef(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getForWhat() {
        return null;
    }
    
    public final void setForWhat(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.ProgressDialog getPd() {
        return null;
    }
    
    public final void setPd(@org.jetbrains.annotations.Nullable()
    android.app.ProgressDialog p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initViews() {
    }
    
    private final void initFirebaseLogin() {
    }
    
    private final void fetchUserCategory(java.lang.String uid) {
    }
    
    public LoginFragment() {
        super();
    }
}