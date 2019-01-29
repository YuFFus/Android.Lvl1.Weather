package com.yuriy.fedak.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtility.makeToast(getApplicationContext(), "onCreate");
    }
    @Override
    protected void onStart(){
        super.onStart();
        ViewUtility.makeToast(getApplicationContext(), "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        ViewUtility.makeToast(getApplicationContext(), "onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        ViewUtility.makeToast(getApplicationContext(), "onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        ViewUtility.makeToast(getApplicationContext(), "onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ViewUtility.makeToast(getApplicationContext(), "onDestroy");
    }

    public void secondActivityStart(View view) {
        Intent intent = new Intent(MainActivity.this, Activity_1.class);
        TextInputEditText textInputEditText = findViewById(R.id.EditText_CityLookingFor);
        intent.putExtra("cityLookingFor", textInputEditText.getText().toString());
        startActivity(intent);
    }
}
