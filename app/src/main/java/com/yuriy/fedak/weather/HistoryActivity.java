package com.yuriy.fedak.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class HistoryActivity extends AppCompatActivity {

        public static final String CITY_NAME_EXTRA = "cityLookingFor";
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
            setContentView(R.layout.activity_history);
            TextView textView = findViewById(R.id.TextViewCityAsResult);
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                textView.setText(getIntent().getExtras().getString(CITY_NAME_EXTRA));
            }
        }
        @Override
        protected void onStart(){
            super.onStart();
            mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            if (!(Objects.requireNonNull(mSettings.getString(APP_PREFERENCES_THEME, ""))).equals(currentTheme)) {
                recreate();
            }
        }
        @Override
        protected void onResume() {
            super.onResume();
        }
        @Override
        protected void onPause(){
            super.onPause();
        }
        @Override
        protected void onStop(){
            super.onStop();
        }
        @Override
        protected void onDestroy(){
            super.onDestroy();
        }
}
