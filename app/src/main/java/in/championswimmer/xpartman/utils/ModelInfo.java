package in.championswimmer.xpartman.utils;

import android.content.Context;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

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

    public String getPartBoot() {
        return partBoot;
    }

    public String getPartRecovery() {
        return partRecovery;
    }

    public String getPartTA() {
        return partTA;
    }

    public String getPartData() {
        return partData;
    }

    public String getPartCache() {
        return partCache;
    }

    public String getPartSystem() {
        return partSystem;
    }

    public ModelInfo ( Context context ) throws IOException, JSONException {
        model = Build.DEVICE;
        InputStream is = context.getAssets().open("modelinfo.json");
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        JSONArray jArr = new JSONArray(new String(buffer, "UTF-8"));

        for (int i = 0; i < jArr.length(); i++) {
            String device = jArr.getJSONObject(i).getString("device");
            JSONArray codenames = jArr.getJSONObject(i).getJSONArray("codenames");
            for (int j = 0; j < codenames.length(); j++) {
                if (codenames.getString(j).equalsIgnoreCase(model)) {
                    actualModel = device;
                    partBoot = jArr.getJSONObject(i).getString("boot");
                    partRecovery = jArr.getJSONObject(i).getString("recovery");
                    partTA = jArr.getJSONObject(i).getString("ta");
                    partSystem = jArr.getJSONObject(i).getString("system");
                    partData = jArr.getJSONObject(i).getString("data");
                    partCache = jArr.getJSONObject(i).getString("cache");
                    break;
                }
            }
        }
    }
}
