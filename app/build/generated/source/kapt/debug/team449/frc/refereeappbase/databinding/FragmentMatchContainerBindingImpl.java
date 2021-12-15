package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMatchContainerBindingImpl extends FragmentMatchContainerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.viewPager, 7);
        sViewsWithIds.put(R.id.pageDots, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHandlerNextAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mHandlerPrevAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public FragmentMatchContainerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentMatchContainerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.material.tabs.TabLayout) bindings[8]
            , (androidx.viewpager2.widget.ViewPager2) bindings[7]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
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
        if (BR.handler == variableId) {
            setHandler((team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler) variable);
        }
        else if (BR.vm == variableId) {
            setVm((team449.frc.refereeappbase.model.MatchViewModel) variable);
        }
        else if (BR.page == variableId) {
            setPage((int) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setVm(@Nullable team449.frc.refereeappbase.model.MatchViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setPage(int Page) {
        this.mPage = Page;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.page);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmTeamId((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmMatchId((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmTeamId(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmTeamId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmMatchId(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmMatchId, int fieldId) {
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
        team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler handler = mHandler;
        java.lang.String conversionsSpinnerToMatchVmMatchId = null;
        android.view.View.OnClickListener handlerNextAndroidViewViewOnClickListener = null;
        java.lang.Integer vmTeamIdGetValue = null;
        java.lang.Integer vmMatchIdGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmTeamId = null;
        android.view.View.OnClickListener handlerPrevAndroidViewViewOnClickListener = null;
        java.lang.String conversionsNextPagePage = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        java.lang.String conversionsPrevPagePage = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmMatchId = null;
        java.lang.String conversionsSpinnerToTeamVmTeamId = null;
        int page = mPage;
        int conversionsVisibliltyByStringConversionsNextPagePage = 0;
        int conversionsVisibliltyByStringConversionsPrevPagePage = 0;

        if ((dirtyFlags & 0x24L) != 0) {



                if (handler != null) {
                    // read handler::next
                    handlerNextAndroidViewViewOnClickListener = (((mHandlerNextAndroidViewViewOnClickListener == null) ? (mHandlerNextAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlerNextAndroidViewViewOnClickListener).setValue(handler));
                    // read handler::prev
                    handlerPrevAndroidViewViewOnClickListener = (((mHandlerPrevAndroidViewViewOnClickListener == null) ? (mHandlerPrevAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mHandlerPrevAndroidViewViewOnClickListener).setValue(handler));
                }
        }
        if ((dirtyFlags & 0x2bL) != 0) {


            if ((dirtyFlags & 0x29L) != 0) {

                    if (vm != null) {
                        // read vm.teamId
                        vmTeamId = vm.getTeamId();
                    }
                    updateLiveDataRegistration(0, vmTeamId);


                    if (vmTeamId != null) {
                        // read vm.teamId.getValue()
                        vmTeamIdGetValue = vmTeamId.getValue();
                    }


                    // read Conversions.spinnerToTeam(vm.teamId.getValue())
                    conversionsSpinnerToTeamVmTeamId = team449.frc.refereeappbase.databinding.Conversions.spinnerToTeam(vmTeamIdGetValue);
            }
            if ((dirtyFlags & 0x2aL) != 0) {

                    if (vm != null) {
                        // read vm.matchId
                        vmMatchId = vm.getMatchId();
                    }
                    updateLiveDataRegistration(1, vmMatchId);


                    if (vmMatchId != null) {
                        // read vm.matchId.getValue()
                        vmMatchIdGetValue = vmMatchId.getValue();
                    }


                    // read Conversions.spinnerToMatch(vm.matchId.getValue())
                    conversionsSpinnerToMatchVmMatchId = team449.frc.refereeappbase.databinding.Conversions.spinnerToMatch(vmMatchIdGetValue);
            }
        }
        if ((dirtyFlags & 0x30L) != 0) {



                // read Conversions.nextPage(page)
                conversionsNextPagePage = team449.frc.refereeappbase.databinding.Conversions.nextPage(page);
                // read Conversions.prevPage(page)
                conversionsPrevPagePage = team449.frc.refereeappbase.databinding.Conversions.prevPage(page);


                // read Conversions.visibliltyByString(Conversions.nextPage(page))
                conversionsVisibliltyByStringConversionsNextPagePage = team449.frc.refereeappbase.databinding.Conversions.visibliltyByString(conversionsNextPagePage);
                // read Conversions.visibliltyByString(Conversions.prevPage(page))
                conversionsVisibliltyByStringConversionsPrevPagePage = team449.frc.refereeappbase.databinding.Conversions.visibliltyByString(conversionsPrevPagePage);
        }
        // batch finished
        if ((dirtyFlags & 0x2aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, conversionsSpinnerToMatchVmMatchId);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, conversionsSpinnerToTeamVmTeamId);
        }
        if ((dirtyFlags & 0x24L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(handlerPrevAndroidViewViewOnClickListener);
            this.mboundView5.setOnClickListener(handlerNextAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.mboundView3.setVisibility(conversionsVisibliltyByStringConversionsPrevPagePage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, conversionsPrevPagePage);
            this.mboundView5.setVisibility(conversionsVisibliltyByStringConversionsNextPagePage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, conversionsNextPagePage);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler value;
        public OnClickListenerImpl setValue(team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.next(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler value;
        public OnClickListenerImpl1 setValue(team449.frc.refereeappbase.fragment.MatchContainerFragmentClickHandler value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.prev(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.teamId
        flag 1 (0x2L): vm.matchId
        flag 2 (0x3L): handler
        flag 3 (0x4L): vm
        flag 4 (0x5L): page
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}