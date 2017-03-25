package fragments;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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

import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
    private NavigationActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_fragment, container, false);
        mActivity = (NavigationActivity) getActivity();
        setSwitcher(mActivity);
        mPhoneText = (EditText) view.findViewById(R.id.ph_num);
        mCheckFaceBook = (CheckBox) view.findViewById(R.id.check_face);
        mCheckLocation = (CheckBox) view.findViewById(R.id.check_loc);

        mCheckFaceBook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
//                    mActivity.shareFaceBook();
                }
            }
        });
        mCheckLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
//                    findMyLocation();
                }
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

    private void setSwitcher(Switcher switcher) {
        this.mSwitcher = switcher;
    }

    //TODO Service problem with Locations !
    private void findMyLocation() {
        LocationManager locationManager = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new AwesomeLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
    }

    private class AwesomeLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location loc) {
            String cityName = " ";
            String countryName = " ";
            Geocoder gcd = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (addresses.size() > 0) {
                    cityName = addresses.get(0).getLocality();
                    countryName = addresses.get(0).getCountryName();
                }
                mActivity.addLocation(cityName + ", " + countryName);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
    }

}
