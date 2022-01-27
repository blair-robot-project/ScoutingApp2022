package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAutoBindingImpl extends FragmentAutoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.autoTaxi, 4);
        sViewsWithIds.put(R.id.autoMoveHelp, 5);
        sViewsWithIds.put(R.id.hubs, 6);
        sViewsWithIds.put(R.id.autoUpperHubInc, 7);
        sViewsWithIds.put(R.id.autoUpperHubDec, 8);
        sViewsWithIds.put(R.id.autoLowerHubInc, 9);
        sViewsWithIds.put(R.id.autoLowerHubDec, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener autoMoveandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.unbox(vm.taxi.getValue())
            //         is vm.taxi.setValue((java.lang.Boolean) Conversions.box(callbackArg_0))
            boolean callbackArg_0 = autoMove.isChecked();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.taxi != null
            boolean vmTaxiJavaLangObjectNull = false;
            // vm.taxi
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmTaxi = null;
            // vm.taxi.getValue()
            java.lang.Boolean vmTaxiGetValue = null;
            // Conversions.unbox(vm.taxi.getValue())
            boolean conversionsUnboxVmTaxi = false;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmTaxi = vm.getTaxi();

                vmTaxiJavaLangObjectNull = (vmTaxi) != (null);
                if (vmTaxiJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0);


                    vmTaxi.setValue(((java.lang.Boolean) (team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0))));
                }
            }
        }
    };

    public FragmentAutoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentAutoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.ImageButton) bindings[10]
            , (android.widget.ImageButton) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (android.widget.CheckBox) bindings[1]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.ImageButton) bindings[8]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[6]
            );
        this.autoLowerHubText.setTag(null);
        this.autoMove.setTag(null);
        this.autoUpperHubText.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmAutoLowerHub((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmAutoUpperHub((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeVmTaxi((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmAutoLowerHub(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmAutoLowerHub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmAutoUpperHub(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmAutoUpperHub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmTaxi(androidx.lifecycle.MutableLiveData<java.lang.Boolean> VmTaxi, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmAutoLowerHub = null;
        boolean conversionsUnboxVmTaxi = false;
        java.lang.String formattingHelperPadZeroesVmAutoUpperHub = null;
        java.lang.String formattingHelperPadZeroesVmAutoLowerHub = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmAutoUpperHub = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmTaxi = null;
        java.lang.Boolean vmTaxiGetValue = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.autoLowerHub
                        vmAutoLowerHub = vm.getAutoLowerHub();
                    }
                    updateLiveDataRegistration(0, vmAutoLowerHub);


                    // read FormattingHelper.padZeroes(vm.autoLowerHub)
                    formattingHelperPadZeroesVmAutoLowerHub = team449.frc.refereeappbase.helpers.FormattingHelper.padZeroes(vmAutoLowerHub);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (vm != null) {
                        // read vm.autoUpperHub
                        vmAutoUpperHub = vm.getAutoUpperHub();
                    }
                    updateLiveDataRegistration(1, vmAutoUpperHub);


                    // read FormattingHelper.padZeroes(vm.autoUpperHub)
                    formattingHelperPadZeroesVmAutoUpperHub = team449.frc.refereeappbase.helpers.FormattingHelper.padZeroes(vmAutoUpperHub);
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (vm != null) {
                        // read vm.taxi
                        vmTaxi = vm.getTaxi();
                    }
                    updateLiveDataRegistration(2, vmTaxi);


                    if (vmTaxi != null) {
                        // read vm.taxi.getValue()
                        vmTaxiGetValue = vmTaxi.getValue();
                    }


                    // read Conversions.unbox(vm.taxi.getValue())
                    conversionsUnboxVmTaxi = team449.frc.refereeappbase.databinding.Conversions.unbox(vmTaxiGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.autoLowerHubText, formattingHelperPadZeroesVmAutoLowerHub);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.autoMove, conversionsUnboxVmTaxi);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.autoMove, (android.widget.CompoundButton.OnCheckedChangeListener)null, autoMoveandroidCheckedAttrChanged);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.autoUpperHubText, formattingHelperPadZeroesVmAutoUpperHub);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.autoLowerHub
        flag 1 (0x2L): vm.autoUpperHub
        flag 2 (0x3L): vm.taxi
        flag 3 (0x4L): vm
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}