package utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lucky on 3/25/2017.
 */

public class JSONHelper {
    private static final String TAG = "JSONHelper";
    public static String json;

//TODO JSON Format!
    public static void printJson() {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.d(TAG, "JSON: " + jsonObject.toString(4));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
