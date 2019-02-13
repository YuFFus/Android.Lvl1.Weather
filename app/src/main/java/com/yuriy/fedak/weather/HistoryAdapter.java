package com.yuriy.fedak.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class HistoryAdapter extends RecyclerView.Adapter <HistoryAdapter.HistoryViewHolder> {

    private LayoutInflater inflater;
    private List<History_Data> history_data;

    HistoryAdapter(Context context, List<History_Data> history_data){

        this.history_data = history_data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                 inflate(R.layout.text_view_item, viewGroup, false);

        HistoryViewHolder historyViewHolder = new HistoryViewHolder(view);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int position) {
        History_Data history_data_item = history_data.get(position);

        historyViewHolder.tempView.setText(history_data_item.getTemp());
        historyViewHolder.pressureView.setText(history_data_item.getPressure());
        historyViewHolder.windView.setText(history_data_item.getWind());
        historyViewHolder.humidityView.setText(history_data_item.getHumidity());
    }

    @Override
    public int getItemCount() {
        return history_data.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder{

        final TextView tempView, pressureView, windView, humidityView;

        public HistoryViewHolder(@Nullable View view){
            super(view);
            this.tempView = (TextView)view.findViewById(R.id.temp);
            this.pressureView = (TextView)view.findViewById(R.id.pressure);
            this.windView = (TextView)view.findViewById(R.id.wind);
            this.humidityView = (TextView)view.findViewById(R.id.humidity);
        }
    }

}
