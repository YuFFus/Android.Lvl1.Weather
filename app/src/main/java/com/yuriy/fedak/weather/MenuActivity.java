package com.yuriy.fedak.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTheme(R.style.DarkAppTheme);
        getApplication().setTheme(R.style.DarkAppTheme);
        setContentView(R.layout.activity_menu);

    }
}
