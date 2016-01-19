package com.example.dongja94.samplerecyclermultitype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class LeftViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;
    public LeftViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView)itemView.findViewById(R.id.text_title);
    }

    public void setMyData(MyData data) {
        titleView.setText(data.message);
    }
}
