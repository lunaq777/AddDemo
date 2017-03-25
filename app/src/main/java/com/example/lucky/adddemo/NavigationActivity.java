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
import fragments.MyAddsFragment;
import utils.Switcher;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener, Switcher {

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

    private void initGUI() {
        mToolbar = (Toolbar) findViewById(R.id.navi_toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.navi_toolbar_title);
        mMyAdds = (ImageButton) findViewById(R.id.my_button);
        mPlaceAd = (ImageButton) findViewById(R.id.place_button);
        mMyAdds.setOnClickListener(this);
        mPlaceAd.setOnClickListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment_container, new AddInfoFragment(), AddInfoFragment.TAG).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_button:
                mMyAdds.setImageDrawable(getDrawable(R.drawable.ic_my_ads_prs));
                switchFragment(new MyAddsFragment(), MyAddsFragment.TITLE, MyAddsFragment.TAG);
                break;
            case R.id.place_button:
                mMyAdds.setImageDrawable(getDrawable(R.drawable.ic_my_ads));
                switchFragment(new AddInfoFragment(), AddInfoFragment.TITLE, AddInfoFragment.TAG);
                break;
        }
    }

    @Override
    public void onFragmentSwitch(Fragment fragment, String title, String tag) {
        switchFragment(fragment, title, tag);
    }

    @Override
    public void onTabChange(boolean isChanged, String curTitle) {
        mToolbarTitle.setText(curTitle);
        mMyAdds.setImageDrawable(isChanged ? getDrawable(R.drawable.ic_my_ads_prs) : getDrawable(R.drawable.ic_my_ads));
        mPlaceAd.setImageDrawable(isChanged ? getDrawable(R.drawable.ic_place_ads) : getDrawable(R.drawable.ic_place_ads_prs));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void switchFragment(Fragment fragment, String title, String tag){
        mToolbarTitle.setText(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment, tag)
                .addToBackStack(tag).commit();
    }
}
