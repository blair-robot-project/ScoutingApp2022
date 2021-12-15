package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGeneralBindingImpl extends FragmentGeneralBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.deadText, 5);
        sViewsWithIds.put(R.id.deadHelp, 6);
        sViewsWithIds.put(R.id.ralive0, 7);
        sViewsWithIds.put(R.id.rbroken1, 8);
        sViewsWithIds.put(R.id.rsometimes2, 9);
        sViewsWithIds.put(R.id.rdead3, 10);
        sViewsWithIds.put(R.id.deadDiv, 11);
        sViewsWithIds.put(R.id.defenseText, 12);
        sViewsWithIds.put(R.id.defenseHelp, 13);
        sViewsWithIds.put(R.id.rnodef0, 14);
        sViewsWithIds.put(R.id.rsomedef1, 15);
        sViewsWithIds.put(R.id.rdefense2, 16);
        sViewsWithIds.put(R.id.defenseDiv, 17);
        sViewsWithIds.put(R.id.commentsText, 18);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.Button mboundView4;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHandlerSubmitAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener commentsandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.comments.getValue()
            //         is vm.comments.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(comments);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.comments != null
            boolean vmCommentsJavaLangObjectNull = false;
            // vm.comments.getValue()
            java.lang.String vmCommentsGetValue = null;
            // vm.comments
            androidx.lifecycle.MutableLiveData<java.lang.String> vmComments = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmComments = vm.getComments();

                vmCommentsJavaLangObjectNull = (vmComments) != (null);
                if (vmCommentsJavaLangObjectNull) {




                    vmComments.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener deadandroidCheckedButtonAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.radioIndexToIdDead(vm.dead.getValue())
            //         is vm.dead.setValue((java.lang.Integer) Conversions.radioIdToIndexDead(callbackArg_0))
            int callbackArg_0 = dead.getCheckedRadioButtonId();
            // localize variables for thread safety
            // vm.dead.getValue()
            java.lang.Integer vmDeadGetValue = null;
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.dead != null
            boolean vmDeadJavaLangObjectNull = false;
            // Conversions.radioIndexToIdDead(vm.dead.getValue())
            int conversionsRadioIndexToIdDeadVmDead = 0;
            // vm.dead
            androidx.lifecycle.MutableLiveData<java.lang.Integer> vmDead = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmDead = vm.getDead();

                vmDeadJavaLangObjectNull = (vmDead) != (null);
                if (vmDeadJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.radioIdToIndexDead(callbackArg_0);


                    vmDead.setValue(((java.lang.Integer) (team449.frc.refereeappbase.databinding.Conversions.radioIdToIndexDead(callbackArg_0))));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener defenseandroidCheckedButtonAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.radioIndexToIdDefense(vm.defense.getValue())
            //         is vm.defense.setValue((java.lang.Integer) Conversions.radioIdToIndexDefense(callbackArg_0))
            int callbackArg_0 = defense.getCheckedRadioButtonId();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // Conversions.radioIndexToIdDefense(vm.defense.getValue())
            int conversionsRadioIndexToIdDefenseVmDefense = 0;
            // vm.defense.getValue()
            java.lang.Integer vmDefenseGetValue = null;
            // vm.defense != null
            boolean vmDefenseJavaLangObjectNull = false;
            // vm.defense
            androidx.lifecycle.MutableLiveData<java.lang.Integer> vmDefense = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmDefense = vm.getDefense();

                vmDefenseJavaLangObjectNull = (vmDefense) != (null);
                if (vmDefenseJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.radioIdToIndexDefense(callbackArg_0);


                    vmDefense.setValue(((java.lang.Integer) (team449.frc.refereeappbase.databinding.Conversions.radioIdToIndexDefense(callbackArg_0))));
                }
            }
        }
    };

    public FragmentGeneralBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentGeneralBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[18]
            , (android.widget.RadioGroup) bindings[1]
            , (android.view.View) bindings[11]
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.RadioGroup) bindings[2]
            , (android.view.View) bindings[17]
            , (android.widget.ImageButton) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[8]
            , (android.widget.RadioButton) bindings[10]
            , (android.widget.RadioButton) bindings[16]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioButton) bindings[15]
            , (android.widget.RadioButton) bindings[9]
            );
        this.comments.setTag(null);
        this.dead.setTag(null);
        this.defense.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.Button) bindings[4];
        this.mboundView4.setTag(null);
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
        else if (BR.handler == variableId) {
            setHandler((team449.frc.refereeappbase.fragment.SubmitHandler) variable);
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
    public void setHandler(@Nullable team449.frc.refereeappbase.fragment.SubmitHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmDefense((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmComments((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeVmDead((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmDefense(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmDefense, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmComments(androidx.lifecycle.MutableLiveData<java.lang.String> VmComments, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmDead(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmDead, int fieldId) {
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
        java.lang.Integer vmDeadGetValue = null;
        java.lang.String vmCommentsGetValue = null;
        android.view.View.OnClickListener handlerSubmitAndroidViewViewOnClickListener = null;
        int conversionsRadioIndexToIdDeadVmDead = 0;
        int conversionsRadioIndexToIdDefenseVmDefense = 0;
        java.lang.Integer vmDefenseGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmDefense = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmComments = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        team449.frc.refereeappbase.fragment.SubmitHandler handler = mHandler;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmDead = null;

        if ((dirtyFlags & 0x2fL) != 0) {


            if ((dirtyFlags & 0x29L) != 0) {

                    if (vm != null) {
                        // read vm.defense
                        vmDefense = vm.getDefense();
                    }
                    updateLiveDataRegistration(0, vmDefense);


                    if (vmDefense != null) {
                        // read vm.defense.getValue()
                        vmDefenseGetValue = vmDefense.getValue();
                    }


                    // read Conversions.radioIndexToIdDefense(vm.defense.getValue())
                    conversionsRadioIndexToIdDefenseVmDefense = team449.frc.refereeappbase.databinding.Conversions.radioIndexToIdDefense(vmDefenseGetValue);
            }
            if ((dirtyFlags & 0x2aL) != 0) {

                    if (vm != null) {
                        // read vm.comments
                        vmComments = vm.getComments();
                    }
                    updateLiveDataRegistration(1, vmComments);


                    if (vmComments != null) {
                        // read vm.comments.getValue()
                        vmCommentsGetValue = vmComments.getValue();
                    }
            }
            if ((dirtyFlags & 0x2cL) != 0) {

                    if (vm != null) {
                        // read vm.dead
                        vmDead = vm.getDead();
                    }
                    updateLiveDataRegistration(2, vmDead);


                    if (vmDead != null) {
                        // read vm.dead.getValue()
                        vmDeadGetValue = vmDead.getValue();
                    }


                    // read Conversions.radioIndexToIdDead(vm.dead.getValue())
                    conversionsRadioIndexToIdDeadVmDead = team449.frc.refereeappbase.databinding.Conversions.radioIndexToIdDead(vmDeadGetValue);
            }
        }
        if ((dirtyFlags & 0x30L) != 0) {



                if (handler != null) {
                    // read handler::submit
                    handlerSubmitAndroidViewViewOnClickListener = (((mHandlerSubmitAndroidViewViewOnClickListener == null) ? (mHandlerSubmitAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlerSubmitAndroidViewViewOnClickListener).setValue(handler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.comments, vmCommentsGetValue);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.comments, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, commentsandroidTextAttrChanged);
            androidx.databinding.adapters.RadioGroupBindingAdapter.setListeners(this.dead, (android.widget.RadioGroup.OnCheckedChangeListener)null, deadandroidCheckedButtonAttrChanged);
            androidx.databinding.adapters.RadioGroupBindingAdapter.setListeners(this.defense, (android.widget.RadioGroup.OnCheckedChangeListener)null, defenseandroidCheckedButtonAttrChanged);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            androidx.databinding.adapters.RadioGroupBindingAdapter.setCheckedButton(this.dead, conversionsRadioIndexToIdDeadVmDead);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.RadioGroupBindingAdapter.setCheckedButton(this.defense, conversionsRadioIndexToIdDefenseVmDefense);
        }
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.mboundView4.setOnClickListener(handlerSubmitAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private team449.frc.refereeappbase.fragment.SubmitHandler value;
        public OnClickListenerImpl setValue(team449.frc.refereeappbase.fragment.SubmitHandler value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.submit(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.defense
        flag 1 (0x2L): vm.comments
        flag 2 (0x3L): vm.dead
        flag 3 (0x4L): vm
        flag 4 (0x5L): handler
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}