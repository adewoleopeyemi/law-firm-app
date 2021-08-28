package com.example.successsynergyapp.dashboard.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020-H\u0002J\u0010\u00107\u001a\u00020-2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0002R@\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\n\u00a8\u0006<"}, d2 = {"Lcom/example/successsynergyapp/dashboard/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "allCat", "Ljava/util/ArrayList;", "Lcom/example/successsynergyapp/model/ModelServiceProvider;", "Lkotlin/collections/ArrayList;", "getAllCat", "()Ljava/util/ArrayList;", "setAllCat", "(Ljava/util/ArrayList;)V", "allUsers", "getAllUsers", "setAllUsers", "binding", "Lcom/example/successsynergyapp/databinding/LayoutHomeBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/LayoutHomeBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/LayoutHomeBinding;)V", "onAllRated", "", "getOnAllRated", "()Z", "setOnAllRated", "(Z)V", "popularUsers", "getPopularUsers", "setPopularUsers", "search", "", "getSearch", "()Ljava/lang/String;", "setSearch", "(Ljava/lang/String;)V", "serviceProviderRef", "Lcom/google/firebase/database/DatabaseReference;", "getServiceProviderRef", "()Lcom/google/firebase/database/DatabaseReference;", "setServiceProviderRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "topRatedUsers", "getTopRatedUsers", "setTopRatedUsers", "initPopularRecyclerView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "searchDb", "setConstraintGravity", "i", "", "toggleAllRated", "update", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.LayoutHomeBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference serviceProviderRef;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> popularUsers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider>> allCat;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> allUsers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> topRatedUsers;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String search;
    private boolean onAllRated = true;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.LayoutHomeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.LayoutHomeBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getServiceProviderRef() {
        return null;
    }
    
    public final void setServiceProviderRef(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> getPopularUsers() {
        return null;
    }
    
    public final void setPopularUsers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider>> getAllCat() {
        return null;
    }
    
    public final void setAllCat(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> getAllUsers() {
        return null;
    }
    
    public final void setAllUsers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> getTopRatedUsers() {
        return null;
    }
    
    public final void setTopRatedUsers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.successsynergyapp.model.ModelServiceProvider> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSearch() {
        return null;
    }
    
    public final void setSearch(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getOnAllRated() {
        return false;
    }
    
    public final void setOnAllRated(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void searchDb() {
    }
    
    private final void toggleAllRated() {
    }
    
    private final void setConstraintGravity(int i) {
    }
    
    private final void update() {
    }
    
    private final void initPopularRecyclerView() {
    }
    
    public HomeFragment() {
        super();
    }
}