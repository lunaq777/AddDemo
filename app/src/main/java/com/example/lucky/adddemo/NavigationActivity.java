package com.example.lucky.adddemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import fragments.AddInfoFragment;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private ImageButton mMyAdds;
    private ImageButton mPlaceAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initGUI();
    }

    private void initGUI(){
        mToolbar = (Toolbar) findViewById(R.id.navi_toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.navi_toolbar_title);
        mToolbarTitle.setText("Add info");
        mMyAdds = (ImageButton) findViewById(R.id.my_button);
        mPlaceAd = (ImageButton) findViewById(R.id.place_button);
        mMyAdds.setImageDrawable(this.getDrawable(R.drawable.ic_my_ads_prs));
        mPlaceAd.setImageDrawable(this.getDrawable(R.drawable.ic_place_ads_prs));

        Fragment fragment = new AddInfoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_button:
                break;
            case R.id.place_button:
                break;
        }
    }
}
