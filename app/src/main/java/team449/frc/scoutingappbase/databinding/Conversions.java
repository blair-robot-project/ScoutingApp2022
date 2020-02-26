package team449.frc.scoutingappbase.databinding;

import android.util.Log;
import android.view.View;
import androidx.databinding.InverseMethod;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import team449.frc.scoutingappbase.GlobalResources;

public class Conversions {
    @InverseMethod("box")
    public static boolean unbox(Boolean b) {
        return (b != null) && b;
    }

    public static Boolean box(boolean b) {
        return b;
    }

    @InverseMethod("box")
    public static int unbox(Integer i) {
        return i != null ? i : 0;
    }

    public static Integer box(int i) {
        return i;
    }

    public static String prevPage(int currPage) {
        return currPage > 0 ? GlobalResources.pages[currPage - 1] : "";
    }
    public static String nextPage(int currPage) {
        return currPage < GlobalResources.pages.length - 1 ? GlobalResources.pages[currPage + 1] : "";
    }

    public static int visibliltyByString(String s) {
        return s.isEmpty() ? View.INVISIBLE : View.VISIBLE;
    }

    private static String spinnerToLabel(Integer ind, String[] arr, String ifNumeric){
        String label = arr[unbox(ind)];
        if (label.matches("\\d+(?:\\.\\d+)?")) return ifNumeric + label;
        return label;
    }

    public static String spinnerToTeam(Integer ind) {
        return spinnerToLabel(ind, GlobalResources.teams, "Team ");
    }
    public static String spinnerToMatch(Integer ind) {
        return spinnerToLabel(ind, GlobalResources.matches, "Match ");
    }


    // TODO: find a less horrible way to do this
    public static int radioIndexToId(List<Integer> ids, Integer ind) {
        return (ind == null || ind == -1 || ind >= ids.size())? 0 : ids.get(ind);
    }
    public static Integer radioIdToIndex(List<Integer> ids, int id) {
        return (ids.contains(id)) ? ids.indexOf(id) : -1;
    }

    @InverseMethod("radioIdToIndexDead")
    public static int radioIndexToIdDead(Integer ind) {
        return radioIndexToId(GlobalResources.radioIdsDead, ind);
    }
    public static Integer radioIdToIndexDead(int id) {
        return radioIdToIndex(GlobalResources.radioIdsDead, id);
    }
    @InverseMethod("radioIdToIndexDefense")
    public static int radioIndexToIdDefense(Integer ind) {
        return radioIndexToId(GlobalResources.radioIdsDefense, ind);
    }
    public static Integer radioIdToIndexDefense(int id) {
        return radioIdToIndex(GlobalResources.radioIdsDefense, id);
    }
    @InverseMethod("radioIdToIndexClimb")
    public static int radioIndexToIdClimb(Integer ind) {
        return radioIndexToId(GlobalResources.radioIdsClimb, ind);
    }
    public static Integer radioIdToIndexClimb(int id) {
        return radioIdToIndex(GlobalResources.radioIdsClimb, id);
    }


    //TODO: This should be somewhere else and be mutable live data
    public static String[] getTeams() {
        return GlobalResources.teams;
    }
    public static String[] getMatches() {
        return GlobalResources.matches;
    }
}