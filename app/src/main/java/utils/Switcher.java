package utils;

import android.support.v4.app.Fragment;

/**
 * Created by Lucky on 3/24/2017.
 */

public interface Switcher {
    void onFragmentSwitch(Fragment fragment, String title, String tag);
}
