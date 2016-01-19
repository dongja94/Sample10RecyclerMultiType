package com.example.dongja94.samplerecyclermultitype;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyData> items = new ArrayList<MyData>();
    public void add(MyData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_LEFT = 100;
    private static final int VIEW_TYPE_CENTER = 500;
    private static final int VIEW_TYPE_RIGHT = 1000;

    @Override
    public int getItemViewType(int position) {
        MyData data = items.get(position);
        switch (data.type) {
            case MyData.TYPE_LEFT :
                return VIEW_TYPE_LEFT;
            case MyData.TYPE_CENTER :
                return VIEW_TYPE_CENTER;
            case MyData.TYPE_RIGHT :
                return VIEW_TYPE_RIGHT;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_LEFT :
                view = inflater.inflate(R.layout.view_left, parent, false);
                return new LeftViewHolder(view);
            case VIEW_TYPE_CENTER :
                view = inflater.inflate(R.layout.view_center, parent, false);
                return new CenterViewHolder(view);
            case VIEW_TYPE_RIGHT :
                view = inflater.inflate(R.layout.view_right, parent, false);
                return new RightViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_LEFT :
                ((LeftViewHolder)holder).setMyData(items.get(position));
                break;
            case VIEW_TYPE_CENTER :
                ((CenterViewHolder)holder).setMyData(items.get(position));
                break;
            case VIEW_TYPE_RIGHT :
                ((RightViewHolder)holder).setMyData(items.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
