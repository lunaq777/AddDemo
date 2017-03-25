package fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lucky.adddemo.NavigationActivity;
import com.example.lucky.adddemo.R;

import utils.Switcher;

/**
 * Created by Lucky on 3/23/2017.
 */

public class AddInfoFragment extends Fragment {

    public static final String TAG = "AddInfoFragment";
    public static final String TITLE = "Add Info";
    private Switcher mSwitcher;
    private Button mNextButton;
    private NavigationActivity mActivity;
    private EditText mTitleText;
    private EditText mDescrText;
    private EditText mPriceText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_info_fragment, container, false);
        mActivity = (NavigationActivity) getActivity();
        setSwitcher(mActivity);
        mTitleText = (EditText) view.findViewById(R.id.add_title);
        mDescrText = (EditText) view.findViewById(R.id.add_description);
        mPriceText = (EditText) view.findViewById(R.id.add_price);
        mNextButton = (Button) view.findViewById(R.id.button_next);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwitcher.onFragmentSwitch(new PhotoFragment(), PhotoFragment.TITLE, PhotoFragment.TAG);
                mActivity.addTitle(mTitleText.getText().toString());
                mActivity.addDescription(mDescrText.getText().toString());
                mActivity.addPrice(mPriceText.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        mSwitcher.onTabChange(false, TITLE);
        super.onResume();
    }

    private void setSwitcher(Switcher switcher){
        this.mSwitcher = switcher;
    }
}
