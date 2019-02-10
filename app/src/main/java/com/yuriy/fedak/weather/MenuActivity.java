package com.yuriy.fedak.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MenuActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_THEME = "Theme";
    public static final String THEME_STANDARD = "Theme_Standard";
    public static final String THEME_DARK = "Theme_Dark";
    public String APP_PREFERENCES_THEME_VALUE;
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
        setContentView(R.layout.activity_menu);

        RadioButton radioButtonStandardTheme = findViewById(R.id.radioButtonStandardTheme);
        radioButtonStandardTheme.setOnClickListener(new RadioButtonStandardThemeClickListener());

        RadioButton radioButtonDarkTheme = findViewById(R.id.radioButtonDarkTheme);
        radioButtonDarkTheme.setOnClickListener(new RadioButtonDarkThemeClickListener());


        if (mSettings.contains(APP_PREFERENCES_THEME)){
            switch (mSettings.getString(APP_PREFERENCES_THEME,"")){
                case THEME_STANDARD:
                    radioButtonStandardTheme.setChecked(true);
                    /*APP_PREFERENCES_THEME_VALUE = THEME_STANDARD;*/
                    break;
                case THEME_DARK:
                    radioButtonDarkTheme.setChecked(true);
                    /*APP_PREFERENCES_THEME_VALUE = THEME_DARK;*/
                    break;
            }
        }
        else {
            radioButtonStandardTheme.setChecked(true);
            APP_PREFERENCES_THEME_VALUE = THEME_STANDARD;
        }
    }
    @Override
    protected void onStop(){
        super.onStop();

    }
    private class RadioButtonStandardThemeClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            APP_PREFERENCES_THEME_VALUE = THEME_STANDARD;
            Editor editor = mSettings.edit();
            editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_THEME_VALUE);
            editor.commit();
            recreate();
        }
    }
    private class RadioButtonDarkThemeClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            APP_PREFERENCES_THEME_VALUE = THEME_DARK;
            Editor editor = mSettings.edit();
            editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_THEME_VALUE);
            editor.commit();
            recreate();
        }
    }

}
