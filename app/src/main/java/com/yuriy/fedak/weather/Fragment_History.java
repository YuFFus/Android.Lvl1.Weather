package com.yuriy.fedak.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment_History extends Fragment {

    List<History_Data> history_data = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();

        RecyclerView recyclerView = view.findViewById(R.id.history_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(layoutManager);

        HistoryAdapter historyAdapter = new HistoryAdapter(getContext(), history_data);

        recyclerView.setAdapter(historyAdapter);
    }
    private void setInitialData(){
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
        history_data.add(new History_Data ("+10", "698", "12", "98"));
    }
}
