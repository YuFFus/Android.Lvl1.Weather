package com.yuriy.fedak.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Fragment_search extends Fragment {
    private boolean isFrameForFragmentResultExist;
    private Parsel currentParcel;
    public static final String CITY_NAME_EXTRA = "cityLookingFor";
    private String cityName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isFrameForFragmentResultExist = getActivity().findViewById(R.id.frame_for_fragment_result) != null;

        if (savedInstanceState != null){
            currentParcel = (Parsel) savedInstanceState.getSerializable("CurrentCity");
        }
            else {
                currentParcel = new Parsel("EMPTY ");
                }
        if (isFrameForFragmentResultExist) {
            showFragmentResult(currentParcel);
        }
        ImageButton buttonMenu = getActivity().findViewById(R.id.imageButtonMenu);
        MenuClickListener buttonMenuClickListener = new MenuClickListener();
        buttonMenu.setOnClickListener(buttonMenuClickListener);
        Button buttonFind = getActivity().findViewById(R.id.button_secondActStart);
        FindClickListener buttonFindClickListener = new FindClickListener();
        buttonFind.setOnClickListener(buttonFindClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentParcel);
    }

    private void showFragmentResult (Parsel parsel){
        if(isFrameForFragmentResultExist){
            Fragment_Result fragment_result = (Fragment_Result)
                    getFragmentManager().findFragmentById(R.id.frame_for_fragment_result);
            if (fragment_result == null) {
                // Создаем новый фрагмент для вывода строки
                fragment_result = Fragment_Result.init(parsel);
                // Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_for_fragment_result, fragment_result);  // замена фрагмента
                ft.commit();
            }
        } else {
            // Если нельзя вывести фрагмент с результатами рядом, откроем вторую активити
            Intent intent = new Intent();
            intent.setClass(getActivity(), ResultActivity.class);
            intent.putExtra(ResultActivity.CITY_NAME_EXTRA, parsel.getCityName());
            startActivity(intent);
        }
    }

    private class MenuClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(getActivity(), MenuActivity.class);
            startActivity(intent);
        }
    }
    private class FindClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            TextInputEditText textInputEditText = getActivity().findViewById(R.id.EditText_CityLookingFor);
            Editable s = textInputEditText.getText();
            currentParcel = new Parsel(s.toString());
            showFragmentResult(currentParcel);
            TextView textView = getActivity().findViewById(R.id.TextViewCityAsResult);
            if (textView != null) {
                textView.setText(currentParcel.getCityName());
            }
        }
    }
}
