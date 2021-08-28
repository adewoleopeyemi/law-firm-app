package com.example.successsynergyapp.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020$J\b\u00106\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006:"}, d2 = {"Lcom/example/successsynergyapp/auth/AccountDetails3Fragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/successsynergyapp/databinding/FragmentAccountDetails3Binding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/FragmentAccountDetails3Binding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/FragmentAccountDetails3Binding;)V", "firebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "forWhat", "", "getForWhat", "()Ljava/lang/String;", "setForWhat", "(Ljava/lang/String;)V", "pd", "Landroid/app/ProgressDialog;", "getPd", "()Landroid/app/ProgressDialog;", "setPd", "(Landroid/app/ProgressDialog;)V", "serviceProvider", "Lcom/example/successsynergyapp/model/ModelServiceProvider;", "getServiceProvider", "()Lcom/example/successsynergyapp/model/ModelServiceProvider;", "setServiceProvider", "(Lcom/example/successsynergyapp/model/ModelServiceProvider;)V", "storageRef", "Lcom/google/firebase/storage/StorageReference;", "getStorageRef", "()Lcom/google/firebase/storage/StorageReference;", "setStorageRef", "(Lcom/google/firebase/storage/StorageReference;)V", "uri", "Landroid/net/Uri;", "userModel", "Lcom/example/successsynergyapp/model/ModelUser;", "getUserModel", "()Lcom/example/successsynergyapp/model/ModelUser;", "setUserModel", "(Lcom/example/successsynergyapp/model/ModelUser;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setImgUri", "", "img", "updateUserProfile", "uploadImage", "validateData", "validateDataForUSer", "app_debug"})
public final class AccountDetails3Fragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.FragmentAccountDetails3Binding binding;
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.model.ModelServiceProvider serviceProvider;
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.model.ModelUser userModel;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.StorageReference storageRef;
    private com.google.firebase.database.FirebaseDatabase firebaseDatabase;
    private android.net.Uri uri;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String forWhat;
    @org.jetbrains.annotations.NotNull()
    public android.app.ProgressDialog pd;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.FragmentAccountDetails3Binding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.FragmentAccountDetails3Binding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.ModelServiceProvider getServiceProvider() {
        return null;
    }
    
    public final void setServiceProvider(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelServiceProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.ModelUser getUserModel() {
        return null;
    }
    
    public final void setUserModel(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelUser p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getStorageRef() {
        return null;
    }
    
    public final void setStorageRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.StorageReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getForWhat() {
        return null;
    }
    
    public final void setForWhat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.ProgressDialog getPd() {
        return null;
    }
    
    public final void setPd(@org.jetbrains.annotations.NotNull()
    android.app.ProgressDialog p0) {
    }
    
    public final void setImgUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri img) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void validateDataForUSer() {
    }
    
    private final void validateData() {
    }
    
    private final void updateUserProfile() {
    }
    
    private final void uploadImage() {
    }
    
    public AccountDetails3Fragment() {
        super();
    }
}