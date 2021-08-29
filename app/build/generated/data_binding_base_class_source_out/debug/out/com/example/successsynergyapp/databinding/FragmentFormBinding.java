// Generated by data binding compiler. Do not edit!
package com.example.successsynergyapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.successsynergyapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentFormBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton fbNewForm;

  @NonNull
  public final LayoutFormDetailBinding formDetail;

  @NonNull
  public final RelativeLayout rlAll;

  @NonNull
  public final RelativeLayout rlNoForm;

  @NonNull
  public final RecyclerView rvAllForms;

  @NonNull
  public final View toolbar;

  protected FragmentFormBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FloatingActionButton fbNewForm, LayoutFormDetailBinding formDetail, RelativeLayout rlAll,
      RelativeLayout rlNoForm, RecyclerView rvAllForms, View toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fbNewForm = fbNewForm;
    this.formDetail = formDetail;
    setContainedBinding(this.formDetail);
    this.rlAll = rlAll;
    this.rlNoForm = rlNoForm;
    this.rvAllForms = rvAllForms;
    this.toolbar = toolbar;
  }

  @NonNull
  public static FragmentFormBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_form, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentFormBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentFormBinding>inflateInternal(inflater, R.layout.fragment_form, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFormBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_form, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentFormBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentFormBinding>inflateInternal(inflater, R.layout.fragment_form, null, false, component);
  }

  public static FragmentFormBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentFormBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentFormBinding)bind(component, view, R.layout.fragment_form);
  }
}
