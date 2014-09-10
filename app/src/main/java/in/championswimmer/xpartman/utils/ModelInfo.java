package in.championswimmer.xpartman.utils;

import android.os.Build;

/**
 * Created by championswimmer on 11/9/14.
 */
public class ModelInfo {
    String model;
    String actualModel;


    String partBoot = "boot";
    String partRecovery = "FOTAKernel";
    String partTA = "TA";
    String partData = "userdata";
    String partCache = "cache";
    String partSystem = "system";

    public ModelInfo () {
        model = Build.DEVICE;
    }
}
