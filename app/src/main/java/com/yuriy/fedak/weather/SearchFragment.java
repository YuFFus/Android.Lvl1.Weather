package com.yuriy.fedak.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class SearchFragment extends Fragment {
    private boolean isFrameForFragmentResultExist;
    private Parsel currentParcel;
    public static final String CITY_NAME_EXTRA = "cityLookingFor";
    private TextInputEditText textInputEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ImageButton buttonMenu = (ImageButton) view.findViewById(R.id.imageButtonMenu);
        buttonMenu.setOnClickListener(new MenuClickListener());

        Button buttonFind =(Button) view.findViewById(R.id.button_secondActStart);
        buttonFind.setOnClickListener(new FindClickListener());

        textInputEditText = (TextInputEditText) view.findViewById(R.id.EditText_CityLookingFor);

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
                currentParcel = new Parsel("Try to find any places");
                }
        if (isFrameForFragmentResultExist) {
            showFragmentResult(currentParcel);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("CurrentCity", currentParcel);
        super.onSaveInstanceState(outState);
    }

    private void showFragmentResult (Parsel parsel){
        if(isFrameForFragmentResultExist){
            ResultFragment fragment_result = (ResultFragment)
                    getFragmentManager().findFragmentById(R.id.frame_for_fragment_result);
            if (fragment_result == null || fragment_result.getParcel().getCityName() != parsel.getCityName()) {
                // Создаем новый фрагмент для вывода строки
                fragment_result = ResultFragment.init(parsel);
            }
            // Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_for_fragment_result, fragment_result);  // замена фрагмента
                ft.commit();
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
            Editable s = textInputEditText.getText();
            currentParcel = new Parsel(s.toString());
            showFragmentResult(currentParcel);
        }
    }

}
