package com.yuriy.fedak.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
}
