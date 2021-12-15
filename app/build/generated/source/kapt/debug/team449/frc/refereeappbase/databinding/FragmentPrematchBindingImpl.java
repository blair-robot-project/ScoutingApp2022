package team449.frc.refereeappbase.databinding;
import team449.frc.refereeappbase.R;
import team449.frc.refereeappbase.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPrematchBindingImpl extends FragmentPrematchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.scoutNameDiv, 6);
        sViewsWithIds.put(R.id.matchText, 7);
        sViewsWithIds.put(R.id.matchDiv, 8);
        sViewsWithIds.put(R.id.teamText, 9);
        sViewsWithIds.put(R.id.teamDiv, 10);
        sViewsWithIds.put(R.id.allianceColorText, 11);
        sViewsWithIds.put(R.id.allianceColorDiv, 12);
        sViewsWithIds.put(R.id.noShowHelp, 13);
        sViewsWithIds.put(R.id.noShowDiv, 14);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener matchandroidSelectedItemPositionAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.unbox(vm.matchId.getValue())
            //         is vm.matchId.setValue((java.lang.Integer) Conversions.box(callbackArg_0))
            int callbackArg_0 = match.getSelectedItemPosition();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm.matchId != null
            boolean vmMatchIdJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.matchId
            androidx.lifecycle.MutableLiveData<java.lang.Integer> vmMatchId = null;
            // Conversions.unbox(vm.matchId.getValue())
            int conversionsUnboxVmMatchId = 0;
            // vm.matchId.getValue()
            java.lang.Integer vmMatchIdGetValue = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmMatchId = vm.getMatchId();

                vmMatchIdJavaLangObjectNull = (vmMatchId) != (null);
                if (vmMatchIdJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0);


                    vmMatchId.setValue(((java.lang.Integer) (team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0))));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener noShowandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.unbox(vm.noShow.getValue())
            //         is vm.noShow.setValue((java.lang.Boolean) Conversions.box(callbackArg_0))
            boolean callbackArg_0 = noShow.isChecked();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.noShow
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmNoShow = null;
            // vm.noShow != null
            boolean vmNoShowJavaLangObjectNull = false;
            // Conversions.unbox(vm.noShow.getValue())
            boolean conversionsUnboxVmNoShow = false;
            // vm.noShow.getValue()
            java.lang.Boolean vmNoShowGetValue = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmNoShow = vm.getNoShow();

                vmNoShowJavaLangObjectNull = (vmNoShow) != (null);
                if (vmNoShowJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0);


                    vmNoShow.setValue(((java.lang.Boolean) (team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0))));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scoutNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.scoutName.getValue()
            //         is vm.scoutName.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scoutName);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm.scoutName
            androidx.lifecycle.MutableLiveData<java.lang.String> vmScoutName = null;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.scoutName.getValue()
            java.lang.String vmScoutNameGetValue = null;
            // vm.scoutName != null
            boolean vmScoutNameJavaLangObjectNull = false;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmScoutName = vm.getRecorderName();

                vmScoutNameJavaLangObjectNull = (vmScoutName) != (null);
                if (vmScoutNameJavaLangObjectNull) {




                    vmScoutName.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener teamandroidSelectedItemPositionAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of Conversions.unbox(vm.teamId.getValue())
            //         is vm.teamId.setValue((java.lang.Integer) Conversions.box(callbackArg_0))
            int callbackArg_0 = team.getSelectedItemPosition();
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
            // vm.teamId != null
            boolean vmTeamIdJavaLangObjectNull = false;
            // vm.teamId.getValue()
            java.lang.Integer vmTeamIdGetValue = null;
            // Conversions.unbox(vm.teamId.getValue())
            int conversionsUnboxVmTeamId = 0;
            // vm.teamId
            androidx.lifecycle.MutableLiveData<java.lang.Integer> vmTeamId = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmTeamId = vm.getTeamId();

                vmTeamIdJavaLangObjectNull = (vmTeamId) != (null);
                if (vmTeamIdJavaLangObjectNull) {



                    team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0);


                    vmTeamId.setValue(((java.lang.Integer) (team449.frc.refereeappbase.databinding.Conversions.box(callbackArg_0))));
                }
            }
        }
    };

    public FragmentPrematchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentPrematchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (android.widget.TextView) bindings[4]
            , (android.view.View) bindings[12]
            , (android.widget.TextView) bindings[11]
            , (android.widget.Spinner) bindings[2]
            , (android.view.View) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.CheckBox) bindings[5]
            , (android.view.View) bindings[14]
            , (android.widget.ImageButton) bindings[13]
            , (android.widget.EditText) bindings[1]
            , (android.view.View) bindings[6]
            , (android.widget.Spinner) bindings[3]
            , (android.view.View) bindings[10]
            , (android.widget.TextView) bindings[9]
            );
        this.allianceColor.setTag(null);
        this.match.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.noShow.setTag(null);
        this.scoutName.setTag(null);
        this.team.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200L;
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
        else if (BR.eventData == variableId) {
            setEventData((team449.frc.refereeappbase.model.EventData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable team449.frc.refereeappbase.model.MatchViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setEventData(@Nullable team449.frc.refereeappbase.model.EventData EventData) {
        this.mEventData = EventData;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.eventData);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeEventDataTeams((androidx.lifecycle.MutableLiveData<java.lang.String[]>) object, fieldId);
            case 1 :
                return onChangeVmNoShow((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeVmAlliance((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 3 :
                return onChangeVmMatchId((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 4 :
                return onChangeVmScoutName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeEventDataMatches((androidx.lifecycle.MutableLiveData<java.lang.String[]>) object, fieldId);
            case 6 :
                return onChangeVmTeamId((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeEventDataTeams(androidx.lifecycle.MutableLiveData<java.lang.String[]> EventDataTeams, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmNoShow(androidx.lifecycle.MutableLiveData<java.lang.Boolean> VmNoShow, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmAlliance(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmAlliance, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmMatchId(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmMatchId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmScoutName(androidx.lifecycle.MutableLiveData<java.lang.String> VmScoutName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeEventDataMatches(androidx.lifecycle.MutableLiveData<java.lang.String[]> EventDataMatches, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmTeamId(androidx.lifecycle.MutableLiveData<java.lang.Integer> VmTeamId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        int androidxDatabindingViewDataBindingSafeUnboxVmAllianceGetValue = 0;
        androidx.lifecycle.MutableLiveData<java.lang.String[]> eventDataTeams = null;
        team449.frc.refereeappbase.model.MatchViewModel vm = mVm;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmNoShow = null;
        java.lang.String vmScoutNameGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmAlliance = null;
        java.lang.Integer vmAllianceGetValue = null;
        java.lang.String[] eventDataTeamsGetValue = null;
        team449.frc.refereeappbase.model.EventData eventData = mEventData;
        java.lang.Integer vmMatchIdGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmMatchId = null;
        int vmAllianceInt0AllianceColorAndroidColorRedAllianceColorAndroidColorBlue = 0;
        boolean conversionsUnboxVmNoShow = false;
        boolean vmAllianceInt0 = false;
        int conversionsUnboxVmMatchId = 0;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmScoutName = null;
        androidx.lifecycle.MutableLiveData<java.lang.String[]> eventDataMatches = null;
        java.lang.String[] eventDataMatchesGetValue = null;
        java.lang.Integer vmTeamIdGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> vmTeamId = null;
        java.lang.String vmAllianceInt0AllianceColorAndroidStringAllianceRedAllianceColorAndroidStringAllianceBlue = null;
        int conversionsUnboxVmTeamId = 0;
        java.lang.Boolean vmNoShowGetValue = null;

        if ((dirtyFlags & 0x2deL) != 0) {


            if ((dirtyFlags & 0x282L) != 0) {

                    if (vm != null) {
                        // read vm.noShow
                        vmNoShow = vm.getNoShow();
                    }
                    updateLiveDataRegistration(1, vmNoShow);


                    if (vmNoShow != null) {
                        // read vm.noShow.getValue()
                        vmNoShowGetValue = vmNoShow.getValue();
                    }


                    // read Conversions.unbox(vm.noShow.getValue())
                    conversionsUnboxVmNoShow = team449.frc.refereeappbase.databinding.Conversions.unbox(vmNoShowGetValue);
            }
            if ((dirtyFlags & 0x284L) != 0) {

                    if (vm != null) {
                        // read vm.alliance
                        vmAlliance = vm.getAlliance();
                    }
                    updateLiveDataRegistration(2, vmAlliance);


                    if (vmAlliance != null) {
                        // read vm.alliance.getValue()
                        vmAllianceGetValue = vmAlliance.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxVmAllianceGetValue = androidx.databinding.ViewDataBinding.safeUnbox(vmAllianceGetValue);


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0
                    vmAllianceInt0 = (androidxDatabindingViewDataBindingSafeUnboxVmAllianceGetValue) == (0);
                if((dirtyFlags & 0x284L) != 0) {
                    if(vmAllianceInt0) {
                            dirtyFlags |= 0x800L;
                            dirtyFlags |= 0x2000L;
                    }
                    else {
                            dirtyFlags |= 0x400L;
                            dirtyFlags |= 0x1000L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:color/red : @android:color/blue
                    vmAllianceInt0AllianceColorAndroidColorRedAllianceColorAndroidColorBlue = ((vmAllianceInt0) ? (getColorFromResource(allianceColor, R.color.red)) : (getColorFromResource(allianceColor, R.color.blue)));
                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:string/alliance_red : @android:string/alliance_blue
                    vmAllianceInt0AllianceColorAndroidStringAllianceRedAllianceColorAndroidStringAllianceBlue = ((vmAllianceInt0) ? (allianceColor.getResources().getString(R.string.alliance_red)) : (allianceColor.getResources().getString(R.string.alliance_blue)));
            }
            if ((dirtyFlags & 0x288L) != 0) {

                    if (vm != null) {
                        // read vm.matchId
                        vmMatchId = vm.getMatchId();
                    }
                    updateLiveDataRegistration(3, vmMatchId);


                    if (vmMatchId != null) {
                        // read vm.matchId.getValue()
                        vmMatchIdGetValue = vmMatchId.getValue();
                    }


                    // read Conversions.unbox(vm.matchId.getValue())
                    conversionsUnboxVmMatchId = team449.frc.refereeappbase.databinding.Conversions.unbox(vmMatchIdGetValue);
            }
            if ((dirtyFlags & 0x290L) != 0) {

                    if (vm != null) {
                        // read vm.scoutName
                        vmScoutName = vm.getRecorderName();
                    }
                    updateLiveDataRegistration(4, vmScoutName);


                    if (vmScoutName != null) {
                        // read vm.scoutName.getValue()
                        vmScoutNameGetValue = vmScoutName.getValue();
                    }
            }
            if ((dirtyFlags & 0x2c0L) != 0) {

                    if (vm != null) {
                        // read vm.teamId
                        vmTeamId = vm.getTeamId();
                    }
                    updateLiveDataRegistration(6, vmTeamId);


                    if (vmTeamId != null) {
                        // read vm.teamId.getValue()
                        vmTeamIdGetValue = vmTeamId.getValue();
                    }


                    // read Conversions.unbox(vm.teamId.getValue())
                    conversionsUnboxVmTeamId = team449.frc.refereeappbase.databinding.Conversions.unbox(vmTeamIdGetValue);
            }
        }
        if ((dirtyFlags & 0x321L) != 0) {


            if ((dirtyFlags & 0x301L) != 0) {

                    if (eventData != null) {
                        // read eventData.teams
                        eventDataTeams = eventData.getTeams();
                    }
                    updateLiveDataRegistration(0, eventDataTeams);


                    if (eventDataTeams != null) {
                        // read eventData.teams.getValue()
                        eventDataTeamsGetValue = eventDataTeams.getValue();
                    }
            }
            if ((dirtyFlags & 0x320L) != 0) {

                    if (eventData != null) {
                        // read eventData.matches
                        eventDataMatches = eventData.getMatches();
                    }
                    updateLiveDataRegistration(5, eventDataMatches);


                    if (eventDataMatches != null) {
                        // read eventData.matches.getValue()
                        eventDataMatchesGetValue = eventDataMatches.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x284L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.allianceColor, vmAllianceInt0AllianceColorAndroidStringAllianceRedAllianceColorAndroidStringAllianceBlue);
            this.allianceColor.setTextColor(vmAllianceInt0AllianceColorAndroidColorRedAllianceColorAndroidColorBlue);
        }
        if ((dirtyFlags & 0x320L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.match, eventDataMatchesGetValue);
        }
        if ((dirtyFlags & 0x288L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setSelectedItemPosition(this.match, conversionsUnboxVmMatchId);
        }
        if ((dirtyFlags & 0x200L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener(this.match, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected)null, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected)null, matchandroidSelectedItemPositionAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.noShow, (android.widget.CompoundButton.OnCheckedChangeListener)null, noShowandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scoutName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scoutNameandroidTextAttrChanged);
            androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener(this.team, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected)null, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected)null, teamandroidSelectedItemPositionAttrChanged);
        }
        if ((dirtyFlags & 0x282L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.noShow, conversionsUnboxVmNoShow);
        }
        if ((dirtyFlags & 0x290L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scoutName, vmScoutNameGetValue);
        }
        if ((dirtyFlags & 0x301L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.team, eventDataTeamsGetValue);
        }
        if ((dirtyFlags & 0x2c0L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setSelectedItemPosition(this.team, conversionsUnboxVmTeamId);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): eventData.teams
        flag 1 (0x2L): vm.noShow
        flag 2 (0x3L): vm.alliance
        flag 3 (0x4L): vm.matchId
        flag 4 (0x5L): vm.scoutName
        flag 5 (0x6L): eventData.matches
        flag 6 (0x7L): vm.teamId
        flag 7 (0x8L): vm
        flag 8 (0x9L): eventData
        flag 9 (0xaL): null
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:color/red : @android:color/blue
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:color/red : @android:color/blue
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:string/alliance_red : @android:string/alliance_blue
        flag 13 (0xeL): androidx.databinding.ViewDataBinding.safeUnbox(vm.alliance.getValue()) == 0 ? @android:string/alliance_red : @android:string/alliance_blue
    flag mapping end*/
    //end
}