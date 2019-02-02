package com.yuriy.fedak.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static final String CITY_NAME_EXTRA = "cityLookingFor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFind = findViewById(R.id.button_secondActStart);
        FindClickListener buttonFindClickListener = new FindClickListener();
        buttonFind.setOnClickListener(buttonFindClickListener);

        ImageButton buttonMenu = findViewById(R.id.imageButtonMenu);
        MenuClickListener buttonMenuClickListener = new MenuClickListener();
        buttonMenu.setOnClickListener(buttonMenuClickListener);

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

    private class FindClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            TextInputEditText textInputEditText = findViewById(R.id.EditText_CityLookingFor);
            Editable s = textInputEditText.getText();
            if (s != null) {
                intent.putExtra(CITY_NAME_EXTRA, s.toString());
            }
            startActivity(intent);
        }
    }
    private class MenuClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }
}
