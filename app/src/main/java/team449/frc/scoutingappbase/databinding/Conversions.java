package team449.frc.scoutingappbase.databinding;

import android.view.View;
import androidx.databinding.InverseMethod;
import team449.frc.scoutingappbase.StaticResources;

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
        return currPage > 0 ? StaticResources.pages[currPage - 1] : "";
    }
    public static String nextPage(int currPage) {
        return currPage < StaticResources.pages.length - 1 ? StaticResources.pages[currPage + 1] : "";
    }

    public static int visibliltyByString(String s) {
        return s.isEmpty() ? View.INVISIBLE : View.VISIBLE;
    }

    @InverseMethod("radioIdToIndex")
    public static int radioIndexToId(Integer ind) {
        if (ind == null || ind == -1) return 0;
        return StaticResources.radioIds.getResourceId(ind, 0);
    }
    public static Integer radioIdToIndex(int id) {
        for (int i=0; i < StaticResources.radioIds.length(); i++) {
            if (StaticResources.radioIds.getResourceId(i, -1) == id) return i;
        }
        return -1;
    }

    private static String spinnerToLabel(Integer ind, String[] arr, String ifNumeric){
        String label = arr[unbox(ind)];
        if (label.matches("\\d+(?:\\.\\d+)?")) return ifNumeric + label;
        return label;
    }
    public static String spinnerToTeam(Integer ind) {
        return spinnerToLabel(ind, StaticResources.teams, "Team ");
    }
    public static String spinnerToMatch(Integer ind) {
        return spinnerToLabel(ind, StaticResources.matches, "Match ");
    }
}