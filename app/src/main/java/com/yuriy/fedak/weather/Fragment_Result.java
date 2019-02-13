package com.yuriy.fedak.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Result extends Fragment {
    public static final String PARCEL = "parcel";
    public static final String CITY_NAME_EXTRA = "cityLookingFor";
    public String cityLookingFor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView textView = view.findViewById(R.id.TextViewCityAsResult);
        Parsel parsel = getParcel();
        if (textView != null) {
            cityLookingFor = parsel.getCityName();
            textView.setText(cityLookingFor);
        }
        Button buttonHistory = (Button) view.findViewById(R.id.button_secondHistoryActStart);
        HistoryClickListener buttonHistoryClickListener = new HistoryClickListener();
        buttonHistory.setOnClickListener(buttonHistoryClickListener);
        return view;
    }
    public static Fragment_Result init(Parsel parsel){
        Fragment_Result f = new Fragment_Result();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parsel);
        f.setArguments(args);
        return f;
    }
    public Parsel getParcel(){
        Parsel parsel = (Parsel) getArguments().getSerializable(PARCEL);
        return parsel;
    }
    private class HistoryClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(getContext(), HistoryActivity.class);
            intent.putExtra(CITY_NAME_EXTRA, cityLookingFor);
            startActivity(intent);
        }
    }
}
