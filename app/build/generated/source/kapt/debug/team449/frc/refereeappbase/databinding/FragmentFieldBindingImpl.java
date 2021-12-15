package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFieldBindingImpl extends FragmentFieldBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.field_vert, 5);
        sViewsWithIds.put(R.id.zone1Inc, 6);
        sViewsWithIds.put(R.id.zone1Dec, 7);
        sViewsWithIds.put(R.id.zone1Bunny, 8);
        sViewsWithIds.put(R.id.zone2Inc, 9);
        sViewsWithIds.put(R.id.zone2Dec, 10);
        sViewsWithIds.put(R.id.zone2Bunny, 11);
        sViewsWithIds.put(R.id.zone3Inc, 12);
        sViewsWithIds.put(R.id.zone3Dec, 13);
        sViewsWithIds.put(R.id.zone3Bunny, 14);
        sViewsWithIds.put(R.id.zone4Inc, 15);
        sViewsWithIds.put(R.id.zone4Dec, 16);
        sViewsWithIds.put(R.id.zone4Bunny, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentFieldBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentFieldBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageButton) bindings[8]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageButton) bindings[11]
            , (android.widget.ImageButton) bindings[10]
            , (android.widget.ImageButton) bindings[9]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageButton) bindings[14]
            , (android.widget.ImageButton) bindings[13]
            , (android.widget.ImageButton) bindings[12]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageButton) bindings[17]
            , (android.widget.ImageButton) bindings[16]
            , (android.widget.ImageButton) bindings[15]
            , (android.widget.TextView) bindings[4]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.zone1Text.setTag(null);
        this.zone2Text.setTag(null);
        this.zone3Text.setTag(null);
        this.zone4Text.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmZone3Crates((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmZone4Crates((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeVmZone2Crates((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 3 :
                return onChangeVmZone1Crates((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmZone3Crates(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmZone3Crates, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmZone4Crates(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmZone4Crates, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmZone2Crates(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmZone2Crates, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmZone1Crates(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmZone1Crates, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.Integer vmZone1CratesGetValue = null;
        java.lang.String vmZone3CratesToString = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmZone3Crates = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmZone4Crates = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmZone2Crates = null;
        java.lang.String vmZone1CratesToString = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmZone1Crates = null;
        java.lang.String vmZone2CratesToString = null;
        java.lang.String vmZone4CratesToString = null;
        java.lang.Integer vmZone4CratesGetValue = null;
        java.lang.Integer vmZone2CratesGetValue = null;
        java.lang.Integer vmZone3CratesGetValue = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (vm != null) {
                        // read vm.zone3Crates
                        vmZone3Crates = vm.getZone3Crates();
                    }
                    updateLiveDataRegistration(0, vmZone3Crates);


                    if (vmZone3Crates != null) {
                        // read vm.zone3Crates.getValue()
                        vmZone3CratesGetValue = vmZone3Crates.getValue();
                    }


                    if (vmZone3CratesGetValue != null) {
                        // read vm.zone3Crates.getValue().toString
                        vmZone3CratesToString = vmZone3CratesGetValue.toString();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (vm != null) {
                        // read vm.zone4Crates
                        vmZone4Crates = vm.getZone4Crates();
                    }
                    updateLiveDataRegistration(1, vmZone4Crates);


                    if (vmZone4Crates != null) {
                        // read vm.zone4Crates.getValue()
                        vmZone4CratesGetValue = vmZone4Crates.getValue();
                    }


                    if (vmZone4CratesGetValue != null) {
                        // read vm.zone4Crates.getValue().toString
                        vmZone4CratesToString = vmZone4CratesGetValue.toString();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (vm != null) {
                        // read vm.zone2Crates
                        vmZone2Crates = vm.getZone2Crates();
                    }
                    updateLiveDataRegistration(2, vmZone2Crates);


                    if (vmZone2Crates != null) {
                        // read vm.zone2Crates.getValue()
                        vmZone2CratesGetValue = vmZone2Crates.getValue();
                    }


                    if (vmZone2CratesGetValue != null) {
                        // read vm.zone2Crates.getValue().toString
                        vmZone2CratesToString = vmZone2CratesGetValue.toString();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (vm != null) {
                        // read vm.zone1Crates
                        vmZone1Crates = vm.getZone1Crates();
                    }
                    updateLiveDataRegistration(3, vmZone1Crates);


                    if (vmZone1Crates != null) {
                        // read vm.zone1Crates.getValue()
                        vmZone1CratesGetValue = vmZone1Crates.getValue();
                    }


                    if (vmZone1CratesGetValue != null) {
                        // read vm.zone1Crates.getValue().toString
                        vmZone1CratesToString = vmZone1CratesGetValue.toString();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.zone1Text, vmZone1CratesToString);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.zone2Text, vmZone2CratesToString);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.zone3Text, vmZone3CratesToString);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.zone4Text, vmZone4CratesToString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.zone3Crates
        flag 1 (0x2L): vm.zone4Crates
        flag 2 (0x3L): vm.zone2Crates
        flag 3 (0x4L): vm.zone1Crates
        flag 4 (0x5L): vm
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}