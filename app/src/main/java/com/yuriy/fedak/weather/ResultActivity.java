package com.yuriy.fedak.weather;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class ResultActivity extends AppCompatActivity {

    public static final String CITY_NAME_EXTRA = "cityLookingFor";
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_THEME = "Theme";
    public static final String THEME_STANDARD = "Theme_Standard";
    public static final String THEME_DARK = "Theme_Dark";
    private static String currentTheme;
    public String cityLookingFor;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (mSettings.contains(APP_PREFERENCES_THEME)){
            switch (Objects.requireNonNull(mSettings.getString(APP_PREFERENCES_THEME,""))){
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
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо это активити закрыть
            finish();
            return;
        }
        setContentView(R.layout.activity_result);
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            cityLookingFor = getIntent().getExtras().getString(CITY_NAME_EXTRA);
            textView.setText(cityLookingFor);
        }
        Button buttonHistory =(Button) findViewById(R.id.button_secondHistoryActStart);
        buttonHistory.setOnClickListener(new HistoryClickListener());
    }
    @Override
    protected void onStart() {
        super.onStart();
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (!(Objects.requireNonNull(mSettings.getString(APP_PREFERENCES_THEME, ""))).equals(currentTheme)) {
            recreate();
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
    private class HistoryClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(ResultActivity.this, HistoryActivity.class);
            intent.putExtra(CITY_NAME_EXTRA, cityLookingFor);
            startActivity(intent);
        }
    }
}
