package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTeleopBindingImpl extends FragmentTeleopBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.hubs, 3);
        sViewsWithIds.put(R.id.teleopUpperHubInc, 4);
        sViewsWithIds.put(R.id.teleopUpperHubDec, 5);
        sViewsWithIds.put(R.id.teleopLowerHubInc, 6);
        sViewsWithIds.put(R.id.teleopLowerHubDec, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTeleopBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentTeleopBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.teleopLowerHubText.setTag(null);
        this.teleopUpperHubText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable team449.frc.refereeappbase.model.MatchViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmTeleopLowerHub((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmTeleopUpperHub((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmTeleopLowerHub(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmTeleopLowerHub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmTeleopUpperHub(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmTeleopUpperHub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        java.lang.String formattingHelperPadZeroesVmTeleopUpperHub = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmTeleopLowerHub = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        java.lang.String formattingHelperPadZeroesVmTeleopLowerHub = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmTeleopUpperHub = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (vm != null) {
                        // read vm.teleopLowerHub
                        vmTeleopLowerHub = vm.getTeleopLowerHub();
                    }
                    updateLiveDataRegistration(0, vmTeleopLowerHub);


                    // read FormattingHelper.padZeroes(vm.teleopLowerHub)
                    formattingHelperPadZeroesVmTeleopLowerHub = team449.frc.refereeappbase.helpers.FormattingHelper.padZeroes(vmTeleopLowerHub);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (vm != null) {
                        // read vm.teleopUpperHub
                        vmTeleopUpperHub = vm.getTeleopUpperHub();
                    }
                    updateLiveDataRegistration(1, vmTeleopUpperHub);


                    // read FormattingHelper.padZeroes(vm.teleopUpperHub)
                    formattingHelperPadZeroesVmTeleopUpperHub = team449.frc.refereeappbase.helpers.FormattingHelper.padZeroes(vmTeleopUpperHub);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.teleopLowerHubText, formattingHelperPadZeroesVmTeleopLowerHub);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.teleopUpperHubText, formattingHelperPadZeroesVmTeleopUpperHub);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.teleopLowerHub
        flag 1 (0x2L): vm.teleopUpperHub
        flag 2 (0x3L): vm
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}