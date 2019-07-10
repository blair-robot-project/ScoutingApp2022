package team449.frc.scoutingappbase;

import androidx.databinding.InverseMethod;

public class Conversions {

    @InverseMethod("box")
    public static boolean unbox(Boolean b) {
        return (b != null) && b;
    }

    public static Boolean box(boolean b) {
        return b;
    }

}
