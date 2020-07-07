package com.example.testdeqode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<JavaScriptResponse> listdata;
    Context context;

    // RecyclerView recyclerView;
    public ListAdapter(ArrayList<JavaScriptResponse> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.progress_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final JavaScriptResponse myListData = listdata.get(position);
        int displayProgress = listdata.get(position).getProgress();
        String displayMessage = listdata.get(position).getMessage();
        String displayState = listdata.get(position).getState();
        if (displayProgress != 0) {
            //String.valueOf(jour.getmTempMin())
            holder.intProgress.setText("Progress precentage: " + String.valueOf(displayProgress));

        }
        holder.intMessage.setText("Message: " + String.valueOf(displayMessage));
        if (displayState != null && displayState != "") {
            holder.intState.setText("State: " + String.valueOf(displayState));

        }
        if (displayProgress == 0) {

            holder.intProgress.setText("Progress precentage: 100");
            displayProgress = 100;

        }
//        holder.progressBar.setMax(100); // 100 maximum value for the progress value
        holder.progressBar.setProgress(displayProgress);
    }

    @Override
    public int getItemCount() {
        if (listdata != null) {
            return listdata.size();
        }
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircularProgressBar progressBar;
        public TextView intProgress;
        public TextView intMessage;
        public TextView intState;

        public ViewHolder(View itemView) {
            super(itemView);
            this.intProgress = (TextView) itemView.findViewById(R.id.int_progress);
            this.intMessage = (TextView) itemView.findViewById(R.id.string_message);
            this.intState = (TextView) itemView.findViewById(R.id.string_state);
            this.progressBar = (CircularProgressBar) itemView.findViewById(R.id.my_progressbar);
        }
    }
}
