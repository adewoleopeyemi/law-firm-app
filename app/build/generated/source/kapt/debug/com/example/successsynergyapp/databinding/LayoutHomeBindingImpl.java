package com.example.successsynergyapp.databinding;
import com.example.successsynergyapp.R;
import com.example.successsynergyapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutHomeBindingImpl extends LayoutHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_loading, 1);
        sViewsWithIds.put(R.id.loading_anim, 2);
        sViewsWithIds.put(R.id.app_bar, 3);
        sViewsWithIds.put(R.id.toolbar_layout, 4);
        sViewsWithIds.put(R.id.adsViewPager, 5);
        sViewsWithIds.put(R.id.indicator, 6);
        sViewsWithIds.put(R.id.user_selection, 7);
        sViewsWithIds.put(R.id.selected_category, 8);
        sViewsWithIds.put(R.id.tv_all_users, 9);
        sViewsWithIds.put(R.id.tv_top_rated_users, 10);
        sViewsWithIds.put(R.id.et_search, 11);
        sViewsWithIds.put(R.id.toolbar, 12);
        sViewsWithIds.put(R.id.ivBack, 13);
        sViewsWithIds.put(R.id.tv_search_results, 14);
        sViewsWithIds.put(R.id.llMain, 15);
        sViewsWithIds.put(R.id.tv_popular, 16);
        sViewsWithIds.put(R.id.no_popular_users_anim, 17);
        sViewsWithIds.put(R.id.rv_popular, 18);
        sViewsWithIds.put(R.id.tv_general, 19);
        sViewsWithIds.put(R.id.all_rl, 20);
        sViewsWithIds.put(R.id.no_general_users, 21);
        sViewsWithIds.put(R.id.rv_all, 22);
        sViewsWithIds.put(R.id.rv_top_rated, 23);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private LayoutHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.viewpager.widget.ViewPager) bindings[5]
            , (android.widget.RelativeLayout) bindings[20]
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (android.widget.EditText) bindings[11]
            , (me.relex.circleindicator.CircleIndicator) bindings[6]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[15]
            , (com.airbnb.lottie.LottieAnimationView) bindings[2]
            , (com.airbnb.lottie.LottieAnimationView) bindings[21]
            , (com.airbnb.lottie.LottieAnimationView) bindings[17]
            , (android.widget.RelativeLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (android.view.View) bindings[8]
            , (androidx.appcompat.widget.Toolbar) bindings[12]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[4]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}