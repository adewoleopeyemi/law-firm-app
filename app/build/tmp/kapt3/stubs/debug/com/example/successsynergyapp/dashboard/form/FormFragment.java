package com.example.successsynergyapp.dashboard.form;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/example/successsynergyapp/dashboard/form/FormFragment;", "Landroidx/fragment/app/Fragment;", "()V", "allForms", "Ljava/util/ArrayList;", "Lcom/example/successsynergyapp/model/ModelForm;", "getAllForms", "()Ljava/util/ArrayList;", "setAllForms", "(Ljava/util/ArrayList;)V", "binding", "Lcom/example/successsynergyapp/databinding/FragmentFormBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/FragmentFormBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/FragmentFormBinding;)V", "firebaseRef", "Lcom/google/firebase/database/DatabaseReference;", "getFirebaseRef", "()Lcom/google/firebase/database/DatabaseReference;", "setFirebaseRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "fetchAllForms", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class FormFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.FragmentFormBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference firebaseRef;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.successsynergyapp.model.ModelForm> allForms;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.FragmentFormBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.FragmentFormBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getFirebaseRef() {
        return null;
    }
    
    public final void setFirebaseRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.successsynergyapp.model.ModelForm> getAllForms() {
        return null;
    }
    
    public final void setAllForms(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.successsynergyapp.model.ModelForm> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void fetchAllForms() {
    }
    
    public FormFragment() {
        super();
    }
}