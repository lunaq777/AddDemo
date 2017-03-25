package com.example.lucky.adddemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

import fragments.AddInfoFragment;
import fragments.MyAddsFragment;
import utils.AddContainer;
import utils.Switcher;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener, Switcher {

    private final int RESULT_LOAD_IMAGE = 1;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private ImageButton mMyAdds;
    private ImageButton mPlaceAd;
    private AddContainer mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initGUI();
    }

    private void initGUI() {
        mContainer = new AddContainer(" ", " ", " ", " ", null);
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

    private void switchFragment(Fragment fragment, String title, String tag) {
        mToolbarTitle.setText(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment, tag)
                .addToBackStack(tag).commit();
    }

    public void addTitle(String title) {
        mContainer.setTitle(title);
    }

    public void addPrice(String price) {
        mContainer.setPrice(price);
    }

    public void addLocation(String location) {
        mContainer.setLocation(location);
    }

    public void addDescription(String description) {
        mContainer.setDescription(description);
    }

    public AddsAdapter getAdapter(Activity context){
        return new AddsAdapter(context, mContainer.getTitles(), mContainer.getPrices(),
                mContainer.getLocations(), mContainer.getDescriptions(), mContainer.getPictures());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        mContainer.setPicture(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }

    //TODO Facebook sharing !
    public void shareFaceBook(){
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(mContainer.getPicture())
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        ShareDialog.show(this, content);
    }

}
