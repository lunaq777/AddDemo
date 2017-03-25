package fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.lucky.adddemo.NavigationActivity;
import com.example.lucky.adddemo.R;

import utils.Switcher;

/**
 * Created by Lucky on 3/23/2017.
 */

public class ContactsFragment extends Fragment {

    public static final String TAG = "ContactsFragment";
    public static final String TITLE = "Add Contacts";
    private Switcher mSwitcher;
    private Button mSaveButton;
    private CheckBox mCheckFaceBook;
    private CheckBox mCheckLocation;
    private EditText mPhoneText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_fragment, container, false);
        setSwitcher((Switcher) getActivity());
        mPhoneText = (EditText) view.findViewById(R.id.ph_num);
        mCheckFaceBook = (CheckBox) view.findViewById(R.id.check_face);
        mCheckLocation = (CheckBox) view.findViewById(R.id.check_loc);

        mCheckFaceBook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        mCheckLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        mSaveButton = (Button) view.findViewById(R.id.button_save);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Phone: " + mPhoneText.getText().toString());
                mSwitcher.onFragmentSwitch(new MyAddsFragment(), MyAddsFragment.TITLE, MyAddsFragment.TAG);
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
