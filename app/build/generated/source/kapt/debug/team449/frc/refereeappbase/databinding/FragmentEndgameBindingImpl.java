package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEndgameBindingImpl extends FragmentEndgameBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rungs, 1);
        sViewsWithIds.put(R.id.radio_traversal, 2);
        sViewsWithIds.put(R.id.radio_high, 3);
        sViewsWithIds.put(R.id.radio_mid, 4);
        sViewsWithIds.put(R.id.radio_low, 5);
        sViewsWithIds.put(R.id.radio_none, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEndgameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentEndgameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RadioButton) bindings[3]
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.RadioButton) bindings[4]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.RadioButton) bindings[2]
            , (android.widget.ImageView) bindings[1]
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
                mDirtyFlags = 0x4L;
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
        if (BR.vm == variableId) {
            setVm((team449.frc.refereeappbase.model.MatchViewModel) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable team449.frc.refereeappbase.model.MatchViewModel Vm) {
        this.mVm = Vm;
    }
    public void setHandler(@Nullable team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler Handler) {
        this.mHandler = Handler;
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
        flag 0 (0x1L): vm
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}