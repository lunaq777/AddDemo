package com.example.lucky.adddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mToolbarTitle;

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
    }
}
