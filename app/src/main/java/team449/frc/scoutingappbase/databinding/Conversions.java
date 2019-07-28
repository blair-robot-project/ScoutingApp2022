package team449.frc.scoutingappbase.databinding;

import android.view.View;
import androidx.databinding.InverseMethod;
import team449.frc.scoutingappbase.R;
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

    private static int[] radioIds = {R.id.r0, R.id.r1, R.id.r2};
    @InverseMethod("radioIdToIndex")
    public static int radioIndexToId(int ind) {
        if (ind == -1) return 0;
        return radioIds[ind];
    }
    public static int radioIdToIndex(int id) {
        for (int i=0; i < radioIds.length; i++) {
            if (radioIds[i] == id) return i;
        }
        return -1;
    }
}