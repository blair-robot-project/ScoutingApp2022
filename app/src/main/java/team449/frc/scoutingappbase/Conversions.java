package team449.frc.scoutingappbase;

import android.view.View;
import androidx.databinding.InverseMethod;

public class Conversions {

    @InverseMethod("box")
    public static boolean unbox(Boolean b) {
        return (b != null) && b;
    }

    public static Boolean box(boolean b) {
        return b;
    }

    // This should probably be a resource, but then that requires having context
    private static String[] pageNames = {"Prematch","Auto","Teleop","Endgame","General"};

    public static String prevPage(int currPage) {
        return currPage > 0 ? pageNames[currPage - 1] : "";
    }
    public static String nextPage(int currPage) {
        return currPage < pageNames.length - 1 ? pageNames[currPage + 1] : "";
    }

    public static int visibliltyByString(String s) {
        return s.isEmpty() ? View.INVISIBLE : View.VISIBLE;
    }
}