package com.example.successsynergyapp.dashboard.form;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J!\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u001eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006."}, d2 = {"Lcom/example/successsynergyapp/dashboard/form/FormFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/successsynergyapp/dashboard/form/adapters/AdapterSingleForm$onAdapterClicked;", "()V", "allForms", "Ljava/util/ArrayList;", "Lcom/example/successsynergyapp/model/ModelForm;", "getAllForms", "()Ljava/util/ArrayList;", "setAllForms", "(Ljava/util/ArrayList;)V", "binding", "Lcom/example/successsynergyapp/databinding/FragmentFormBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/FragmentFormBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/FragmentFormBinding;)V", "firebaseRef", "Lcom/google/firebase/database/DatabaseReference;", "getFirebaseRef", "()Lcom/google/firebase/database/DatabaseReference;", "setFirebaseRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "pd", "Landroid/app/ProgressDialog;", "getPd", "()Landroid/app/ProgressDialog;", "setPd", "(Landroid/app/ProgressDialog;)V", "fetchAllForms", "", "hideFormDetail", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFormClicked", "clicked", "", "form", "(Ljava/lang/Boolean;Lcom/example/successsynergyapp/model/ModelForm;)V", "showFormDetail", "app_debug"})
public final class FormFragment extends androidx.fragment.app.Fragment implements com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleForm.onAdapterClicked {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.FragmentFormBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference firebaseRef;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.successsynergyapp.model.ModelForm> allForms;
    @org.jetbrains.annotations.NotNull()
    public android.app.ProgressDialog pd;
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
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.ProgressDialog getPd() {
        return null;
    }
    
    public final void setPd(@org.jetbrains.annotations.NotNull()
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
    
    private final void fetchAllForms() {
    }
    
    public final void hideFormDetail() {
    }
    
    public final void showFormDetail() {
    }
    
    @java.lang.Override()
    public void onFormClicked(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean clicked, @org.jetbrains.annotations.Nullable()
    com.example.successsynergyapp.model.ModelForm form) {
    }
    
    public FormFragment() {
        super();
    }
}