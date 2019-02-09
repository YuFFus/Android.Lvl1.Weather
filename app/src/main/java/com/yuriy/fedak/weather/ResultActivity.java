package com.yuriy.fedak.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class ResultActivity extends AppCompatActivity {

    public static final String CITY_NAME_EXTRA = "cityLookingFor";
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_THEME = "Theme";
    public static final String THEME_STANDARD = "Theme_Standard";
    public static final String THEME_DARK = "Theme_Dark";
    public static final String PARCEL = "parcel";
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (mSettings.contains(APP_PREFERENCES_THEME)){
            switch (mSettings.getString(APP_PREFERENCES_THEME,"")){
                case THEME_STANDARD:
                    super.setTheme(R.style.AppTheme);
                    setTheme(R.style.AppTheme);
                    break;
                case THEME_DARK:
                    super.setTheme(R.style.DarkAppTheme);
                    setTheme(R.style.DarkAppTheme);
                    break;
            }
        }
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо это активити закрыть
            finish();
            return;
        }
        setContentView(R.layout.activity_result);
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textView.setText(getIntent().getExtras().getString(CITY_NAME_EXTRA));
        }

    }
    @Override
    protected void onSaveInstanceState (Bundle outState){
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        outState.putString(CITY_NAME_EXTRA, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(CITY_NAME_EXTRA));
    }
}
