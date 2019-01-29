package com.yuriy.fedak.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String cityAsResult;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        cityAsResult = getIntent().getExtras().getString("cityLookingFor");
        TextView textView = findViewById(R.id.TextViewCityAsResult);
        textView.setText(cityAsResult);
    }
}
