package com.example.successsynergyapp.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u000201J\u001e\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\nJ&\u00105\u001a\u0002012\u0006\u00104\u001a\u00020+2\u0006\u00103\u001a\u00020\"2\u0006\u00106\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\nJ\u0012\u00108\u001a\u0002012\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\n\u0010;\u001a\u000201*\u00020<J\n\u0010=\u001a\u000201*\u00020<R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020+X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006>"}, d2 = {"Lcom/example/successsynergyapp/auth/EditProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/successsynergyapp/databinding/ActivityEditProfileBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/ActivityEditProfileBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/ActivityEditProfileBinding;)V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "email", "getEmail", "setEmail", "forReg", "", "getForReg", "()Z", "setForReg", "(Z)V", "forWhat", "getForWhat", "setForWhat", "fullName", "getFullName", "setFullName", "gender", "getGender", "setGender", "serviceProviderModel", "Lcom/example/successsynergyapp/model/ModelServiceProvider;", "getServiceProviderModel", "()Lcom/example/successsynergyapp/model/ModelServiceProvider;", "setServiceProviderModel", "(Lcom/example/successsynergyapp/model/ModelServiceProvider;)V", "uid", "getUid", "setUid", "userModel", "Lcom/example/successsynergyapp/model/ModelUser;", "getUserModel", "()Lcom/example/successsynergyapp/model/ModelUser;", "setUserModel", "(Lcom/example/successsynergyapp/model/ModelUser;)V", "loadAccountDetailFragment", "", "loadSocialFragment", "serviceProvider", "user", "loadTocFragment", "img", "Landroid/net/Uri;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "disable", "Landroid/widget/TextView;", "enable", "app_debug"})
public final class EditProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.ActivityEditProfileBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.model.ModelServiceProvider serviceProviderModel;
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.model.ModelUser userModel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String email;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String category;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String gender;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String uid;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fullName;
    private boolean forReg = true;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String forWhat;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.ActivityEditProfileBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.ActivityEditProfileBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.ModelServiceProvider getServiceProviderModel() {
        return null;
    }
    
    public final void setServiceProviderModel(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelServiceProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.ModelUser getUserModel() {
        return null;
    }
    
    public final void setUserModel(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelUser p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable()
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
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullName() {
        return null;
    }
    
    public final void setFullName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getForReg() {
        return false;
    }
    
    public final void setForReg(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getForWhat() {
        return null;
    }
    
    public final void setForWhat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void loadAccountDetailFragment() {
    }
    
    public final void loadSocialFragment(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelServiceProvider serviceProvider, @org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelUser user, @org.jetbrains.annotations.NotNull()
    java.lang.String forWhat) {
    }
    
    public final void loadTocFragment(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelUser user, @org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelServiceProvider serviceProvider, @org.jetbrains.annotations.NotNull()
    android.net.Uri img, @org.jetbrains.annotations.NotNull()
    java.lang.String forWhat) {
    }
    
    public final void enable(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$enable) {
    }
    
    public final void disable(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$disable) {
    }
    
    public EditProfileActivity() {
        super();
    }
}