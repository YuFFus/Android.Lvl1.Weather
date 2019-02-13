package com.yuriy.fedak.weather;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

class HistoryAdapter extends RecyclerView.Adapter <HistoryAdapter.HistoryViewHolder> {

    public final String[] history_array;

    HistoryAdapter(String[] history_array){

        this.history_array = history_array;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).
                 inflate(R.layout.text_view_item, viewGroup, false);

        HistoryViewHolder historyViewHolder = new HistoryViewHolder(textView);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int i) {
        historyViewHolder.textView.setText(history_array[i]);
    }

    @Override
    public int getItemCount() {
        return history_array.length;
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public HistoryViewHolder(@Nullable final TextView textView){
            super(textView);
            this.textView = textView;
        }
    }

}
