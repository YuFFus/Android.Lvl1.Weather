package com.yuriy.fedak.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity_1 extends AppCompatActivity {

    public static final String CITY_NAME_EXTRA = "cityLookingFor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textView.setText(getIntent().getExtras().getString(CITY_NAME_EXTRA));
        }
    }
}
