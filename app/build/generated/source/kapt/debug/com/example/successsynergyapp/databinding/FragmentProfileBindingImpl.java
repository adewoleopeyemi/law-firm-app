package com.example.successsynergyapp.databinding;
import com.example.successsynergyapp.R;
import com.example.successsynergyapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileBindingImpl extends FragmentProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvToolBarTitle, 1);
        sViewsWithIds.put(R.id.rlTop, 2);
        sViewsWithIds.put(R.id.cvImg, 3);
        sViewsWithIds.put(R.id.iv_profile, 4);
        sViewsWithIds.put(R.id.tv_name, 5);
        sViewsWithIds.put(R.id.tv_email, 6);
        sViewsWithIds.put(R.id.ivFaceBook, 7);
        sViewsWithIds.put(R.id.tv_edit_profile, 8);
        sViewsWithIds.put(R.id.view1, 9);
        sViewsWithIds.put(R.id.llInfo, 10);
        sViewsWithIds.put(R.id.cases_handled, 11);
        sViewsWithIds.put(R.id.tv_rating, 12);
        sViewsWithIds.put(R.id.view2, 13);
        sViewsWithIds.put(R.id.tvHeading, 14);
        sViewsWithIds.put(R.id.rvPopular, 15);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragmentProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[1]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[13]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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