package fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lucky.adddemo.R;

/**
 * Created by Lucky on 3/23/2017.
 */

public class PhotoFragment extends Fragment {

    private ImageButton mCamera;
    private ImageButton mGallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photos_fragment, container, false);
        mCamera = (ImageButton) view.findViewById(R.id.camera_button);
        mGallery = (ImageButton) view.findViewById(R.id.gallery_button);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
