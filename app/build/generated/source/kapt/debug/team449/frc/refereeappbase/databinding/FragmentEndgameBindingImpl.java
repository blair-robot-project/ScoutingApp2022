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
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(2, 
            new String[] {"fragment_field"},
            new int[] {3},
            new int[] {team449.frc.refereeappbase.R.layout.fragment_field});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.reachedAllianceHelp, 4);
        sViewsWithIds.put(R.id.reachedAllianceDiv, 5);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @Nullable
    private final team449.frc.refereeappbase.databinding.FragmentFieldBinding mboundView21;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener reachedAllianceandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.unbox(vm.reachedAlliance.getValue())
            //         is vm.reachedAlliance.setValue((java.lang.Boolean) Conversions.box(callbackArg_0))
            boolean callbackArg_0 = reachedAlliance.isChecked();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // Conversions.unbox(vm.reachedAlliance.getValue())
            boolean conversionsUnboxVmReachedAlliance = false;
            // vm.reachedAlliance.getValue()
            java.lang.Boolean vmReachedAllianceGetValue = null;
            // vm.reachedAlliance != null
            boolean vmReachedAllianceJavaLangObjectNull = false;
            // vm.reachedAlliance
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmReachedAlliance = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmReachedAlliance = vm.getReachedAlliance();

                vmReachedAllianceJavaLangObjectNull = (vmReachedAlliance) != (null);
                if (vmReachedAllianceJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0);


                    vmReachedAlliance.setValue(((java.lang.Boolean) (team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0))));
                }
            }
        }
    };

    public FragmentEndgameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentEndgameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.CheckBox) bindings[1]
            , (android.view.View) bindings[5]
            , (android.widget.ImageButton) bindings[4]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView21 = (team449.frc.refereeappbase.databinding.FragmentFieldBinding) bindings[3];
        setContainedBinding(this.mboundView21);
        this.reachedAlliance.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        mboundView21.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView21.hasPendingBindings()) {
            return true;
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
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView21.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmReachedAlliance((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmReachedAlliance(androidx.lifecycle.MutableLiveData<java.lang.Boolean> VmReachedAlliance, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        boolean conversionsUnboxVmReachedAlliance = false;
        java.lang.Boolean vmReachedAllianceGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmReachedAlliance = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (vm != null) {
                    // read vm.reachedAlliance
                    vmReachedAlliance = vm.getReachedAlliance();
                }
                updateLiveDataRegistration(0, vmReachedAlliance);


                if (vmReachedAlliance != null) {
                    // read vm.reachedAlliance.getValue()
                    vmReachedAllianceGetValue = vmReachedAlliance.getValue();
                }


                // read Conversions.unbox(vm.reachedAlliance.getValue())
                conversionsUnboxVmReachedAlliance = team449.frc.refereeappbase.databinding.Conversions.unbox(vmReachedAllianceGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView21.setVm(vm);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.reachedAlliance, conversionsUnboxVmReachedAlliance);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.reachedAlliance, (android.widget.CompoundButton.OnCheckedChangeListener)null, reachedAllianceandroidCheckedAttrChanged);
        }
        executeBindingsOn(mboundView21);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.reachedAlliance
        flag 1 (0x2L): vm
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}