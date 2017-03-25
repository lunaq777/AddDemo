package fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lucky.adddemo.NavigationActivity;
import com.example.lucky.adddemo.R;

import utils.Switcher;

/**
 * Created by Lucky on 3/23/2017.
 */

public class PhotoFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "PhotoFragment";
    public static final String TITLE = "Add Photos";
    private Switcher mSwitcher;
    private ImageButton mCameraButton;
    private ImageButton mGaleryButton;
    private Button mNextButton;
    private NavigationActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photos_fragment, container, false);
        mCameraButton = (ImageButton) view.findViewById(R.id.camera_button);
        mGaleryButton = (ImageButton) view.findViewById(R.id.gallery_button);
        mNextButton = (Button) view.findViewById(R.id.button_next_two);
        mCameraButton.setOnClickListener(this);
        mGaleryButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mActivity = (NavigationActivity) getActivity();
        setSwitcher(mActivity);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_button:
                Toast.makeText(getContext(), getContext().getResources().getString(R.string.camera), Toast.LENGTH_SHORT).show();
                break;
            case R.id.gallery_button:
                mActivity.pickImageFromGallery();
                break;
            case R.id.button_next_two:
                mSwitcher.onFragmentSwitch(new CategoryFragment(), CategoryFragment.TITLE, CategoryFragment.TAG);
                break;
        }
    }

    private void setSwitcher(Switcher switcher){
        this.mSwitcher = switcher;
    }
}
