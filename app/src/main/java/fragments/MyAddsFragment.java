package fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.lucky.adddemo.NavigationActivity;
import com.example.lucky.adddemo.R;

import utils.Switcher;

/**
 * Created by Lucky on 3/23/2017.
 */

public class MyAddsFragment extends Fragment {

    public static final String TAG = "MyAddsFragment";
    public static final String TITLE = "My Adds";
    private Switcher mSwitcher;
    private ListView mListView;
    private Button mSaveButton;
    private NavigationActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_adds_fragment, container, false);
        mActivity = (NavigationActivity) getActivity();
        setSwitcher(mActivity);
        mListView = (ListView) view.findViewById(R.id.list_adds);
        mListView.setAdapter(mActivity.getAdapter(getActivity()));
        mSaveButton = (Button) view.findViewById(R.id.button_save_two);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        mSwitcher.onTabChange(true, TITLE);
        super.onResume();
    }

    private void setSwitcher(Switcher switcher){
        this.mSwitcher = switcher;
    }

}
