package com.example.successsynergyapp.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/example/successsynergyapp/model/SingleQuestionModel;", "", "()V", "answer", "", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "isBoolean", "", "()Z", "setBoolean", "(Z)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "question", "getQuestion", "setQuestion", "requiresTyping", "getRequiresTyping", "setRequiresTyping", "app_debug"})
public final class SingleQuestionModel {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Question")
    private java.lang.String question = "";
    @com.google.gson.annotations.SerializedName(value = "requiresTyping")
    private boolean requiresTyping = false;
    @com.google.gson.annotations.SerializedName(value = "isBoolean")
    private boolean isBoolean = false;
    @com.google.gson.annotations.SerializedName(value = "position")
    private int position = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "answer")
    private java.lang.String answer = "";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestion() {
        return null;
    }
    
    public final void setQuestion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getRequiresTyping() {
        return false;
    }
    
    public final void setRequiresTyping(boolean p0) {
    }
    
    public final boolean isBoolean() {
        return false;
    }
    
    public final void setBoolean(boolean p0) {
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final void setPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswer() {
        return null;
    }
    
    public final void setAnswer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public SingleQuestionModel() {
        super();
    }
}