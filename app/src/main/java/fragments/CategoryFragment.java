package fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.lucky.adddemo.NavigationActivity;
import com.example.lucky.adddemo.R;

import utils.Switcher;

/**
 * Created by Lucky on 3/23/2017.
 */

public class CategoryFragment extends Fragment {

    public static final String TAG = "CategoryFragment";
    public static final String TITLE = "Add Category";
    private Switcher mSwitcher;
    private Spinner mSpinCategory;
    private Spinner mSpinSubCategory;
    private Button mNextButton;
    private String mSpinItem = "";
    private String mSubSpinItem = "";

    public CategoryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_fragment, container, false);
        setSwitcher((Switcher) getActivity());
        mNextButton = (Button) view.findViewById(R.id.button_next_three);
        mSpinCategory = (Spinner) view.findViewById(R.id.spin_category);
        mSpinSubCategory = (Spinner) view.findViewById(R.id.spin_sub_category);
        initSpinners();
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwitcher.onFragmentSwitch(new ContactsFragment(), ContactsFragment.TITLE, ContactsFragment.TAG);
            }
        });
        return view;
    }

    private void initSpinners() {
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.category, R.layout.spinner_item);
        spinAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
        mSpinCategory.setAdapter(spinAdapter);

        mSpinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                mSpinItem = arg0.getItemAtPosition(position).toString();
                Log.d(TAG, "Category: " + mSpinItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<CharSequence> subSpinAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.subcategory, R.layout.spinner_item);
        subSpinAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
        mSpinSubCategory.setAdapter(subSpinAdapter);

        mSpinSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSubSpinItem = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "Sub Category: " + mSubSpinItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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

    private void setSwitcher(Switcher switcher) {
        this.mSwitcher = switcher;
    }
}
