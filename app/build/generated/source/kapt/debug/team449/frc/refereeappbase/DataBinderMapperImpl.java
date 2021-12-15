package team449.frc.refereeappbase;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import team449.frc.refereeappbase.databinding.FragmentAutoBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentEndgameBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentFieldBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentGeneralBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentMatchContainerBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentPenaltyBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentPrematchBindingImpl;
import team449.frc.refereeappbase.databinding.FragmentTeleopBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTAUTO = 1;

  private static final int LAYOUT_FRAGMENTENDGAME = 2;

  private static final int LAYOUT_FRAGMENTFIELD = 3;

  private static final int LAYOUT_FRAGMENTGENERAL = 4;

  private static final int LAYOUT_FRAGMENTMATCHCONTAINER = 5;

  private static final int LAYOUT_FRAGMENTPENALTY = 6;

  private static final int LAYOUT_FRAGMENTPREMATCH = 7;

  private static final int LAYOUT_FRAGMENTTELEOP = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_auto, LAYOUT_FRAGMENTAUTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_endgame, LAYOUT_FRAGMENTENDGAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_field, LAYOUT_FRAGMENTFIELD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_general, LAYOUT_FRAGMENTGENERAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_match_container, LAYOUT_FRAGMENTMATCHCONTAINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_penalty, LAYOUT_FRAGMENTPENALTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_prematch, LAYOUT_FRAGMENTPREMATCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(team449.frc.refereeappbase.R.layout.fragment_teleop, LAYOUT_FRAGMENTTELEOP);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTAUTO: {
          if ("layout/fragment_auto_0".equals(tag)) {
            return new FragmentAutoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_auto is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTENDGAME: {
          if ("layout/fragment_endgame_0".equals(tag)) {
            return new FragmentEndgameBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_endgame is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFIELD: {
          if ("layout/fragment_field_0".equals(tag)) {
            return new FragmentFieldBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_field is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGENERAL: {
          if ("layout/fragment_general_0".equals(tag)) {
            return new FragmentGeneralBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_general is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMATCHCONTAINER: {
          if ("layout/fragment_match_container_0".equals(tag)) {
            return new FragmentMatchContainerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_match_container is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPENALTY: {
          if ("layout/fragment_penalty_0".equals(tag)) {
            return new FragmentPenaltyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_penalty is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPREMATCH: {
          if ("layout/fragment_prematch_0".equals(tag)) {
            return new FragmentPrematchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_prematch is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTELEOP: {
          if ("layout/fragment_teleop_0".equals(tag)) {
            return new FragmentTeleopBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_teleop is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "eventData");
      sKeys.put(2, "handler");
      sKeys.put(3, "page");
      sKeys.put(4, "vm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/fragment_auto_0", team449.frc.refereeappbase.R.layout.fragment_auto);
      sKeys.put("layout/fragment_endgame_0", team449.frc.refereeappbase.R.layout.fragment_endgame);
      sKeys.put("layout/fragment_field_0", team449.frc.refereeappbase.R.layout.fragment_field);
      sKeys.put("layout/fragment_general_0", team449.frc.refereeappbase.R.layout.fragment_general);
      sKeys.put("layout/fragment_match_container_0", team449.frc.refereeappbase.R.layout.fragment_match_container);
      sKeys.put("layout/fragment_penalty_0", team449.frc.refereeappbase.R.layout.fragment_penalty);
      sKeys.put("layout/fragment_prematch_0", team449.frc.refereeappbase.R.layout.fragment_prematch);
      sKeys.put("layout/fragment_teleop_0", team449.frc.refereeappbase.R.layout.fragment_teleop);
    }
  }
}
