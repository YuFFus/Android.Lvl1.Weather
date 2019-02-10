package com.yuriy.fedak.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String APP_PREFERENCES = "mySettings";
    private static final String APP_PREFERENCES_THEME = "Theme";
    private static final String THEME_STANDARD = "Theme_Standard";
    private static final String THEME_DARK = "Theme_Dark";
    private static String currentTheme;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            if (mSettings.contains(APP_PREFERENCES_THEME)) {
                switch (Objects.requireNonNull(mSettings.getString(APP_PREFERENCES_THEME, ""))) {
                    case THEME_STANDARD:
                        super.setTheme(R.style.AppTheme);
                        setTheme(R.style.AppTheme);
                        currentTheme = THEME_STANDARD;
                        break;
                    case THEME_DARK:
                        super.setTheme(R.style.DarkAppTheme);
                        setTheme(R.style.DarkAppTheme);
                        currentTheme = THEME_DARK;
                        break;
                }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (Objects.requireNonNull(mSettings.getString(APP_PREFERENCES_THEME, "")) != currentTheme) {
            recreate();
        }
/*        ViewUtility.makeToast(getApplicationContext(), "onStart");*/
    }
    @Override
    protected void onResume() {
        super.onResume();
        /*ViewUtility.makeToast(getApplicationContext(), "onResume");*/
    }
    @Override
    protected void onPause(){
        super.onPause();
        /*ViewUtility.makeToast(getApplicationContext(), "onPause");*/
    }
    @Override
    protected void onStop(){
        super.onStop();
        /*ViewUtility.makeToast(getApplicationContext(), "onStop");*/
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        /*ViewUtility.makeToast(getApplicationContext(), "onDestroy");*/
    }
}
