package com.example.successsynergyapp.dashboard.form;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u0002052\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010:\u001a\u000205H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/example/successsynergyapp/dashboard/form/UserFormActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "adapter", "Lcom/example/successsynergyapp/dashboard/form/adapters/AdapterSingleQuestion;", "getAdapter", "()Lcom/example/successsynergyapp/dashboard/form/adapters/AdapterSingleQuestion;", "setAdapter", "(Lcom/example/successsynergyapp/dashboard/form/adapters/AdapterSingleQuestion;)V", "binding", "Lcom/example/successsynergyapp/databinding/ActivityUserFormBinding;", "getBinding", "()Lcom/example/successsynergyapp/databinding/ActivityUserFormBinding;", "setBinding", "(Lcom/example/successsynergyapp/databinding/ActivityUserFormBinding;)V", "curQuuestion", "Lcom/example/successsynergyapp/model/SingleQuestionModel;", "getCurQuuestion", "()Lcom/example/successsynergyapp/model/SingleQuestionModel;", "setCurQuuestion", "(Lcom/example/successsynergyapp/model/SingleQuestionModel;)V", "firebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "form", "Lcom/example/successsynergyapp/model/ModelForm;", "getForm", "()Lcom/example/successsynergyapp/model/ModelForm;", "setForm", "(Lcom/example/successsynergyapp/model/ModelForm;)V", "mProgress", "", "mSize", "manager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "manager$delegate", "Lkotlin/Lazy;", "pd", "Landroid/app/ProgressDialog;", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "initialize", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "registerData", "uploadForm", "Companion", "app_debug"})
public final class UserFormActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.example.successsynergyapp.databinding.ActivityUserFormBinding binding;
    private int mProgress = 0;
    private int mSize = 0;
    @org.jetbrains.annotations.NotNull()
    private com.example.successsynergyapp.model.ModelForm form;
    @org.jetbrains.annotations.NotNull()
    private com.example.successsynergyapp.model.SingleQuestionModel curQuuestion;
    @org.jetbrains.annotations.NotNull()
    public java.lang.Runnable runnable;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TAG = "UserFormActiivity";
    private com.google.firebase.database.FirebaseDatabase firebaseDatabase;
    private android.app.ProgressDialog pd;
    private final kotlin.Lazy manager$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleQuestion adapter;
    public static final com.example.successsynergyapp.dashboard.form.UserFormActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.databinding.ActivityUserFormBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.databinding.ActivityUserFormBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.ModelForm getForm() {
        return null;
    }
    
    public final void setForm(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.ModelForm p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.successsynergyapp.model.SingleQuestionModel getCurQuuestion() {
        return null;
    }
    
    public final void setCurQuuestion(@org.jetbrains.annotations.NotNull()
    com.example.successsynergyapp.model.SingleQuestionModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    public final void setRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void setTAG(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final com.yuyakaido.android.cardstackview.CardStackLayoutManager getManager() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void uploadForm() {
    }
    
    private final void registerData(com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleQuestion adapter) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleQuestion getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleQuestion p0) {
    }
    
    private final void initialize() {
    }
    
    public UserFormActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/successsynergyapp/dashboard/form/UserFormActivity$Companion;", "", "()V", "getData", "Ljava/util/ArrayList;", "Lcom/example/successsynergyapp/model/SingleQuestionModel;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.example.successsynergyapp.model.SingleQuestionModel> getData() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}