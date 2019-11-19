package com.iamrajendra.canvasdrawing.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.canvasdrawing.R;
import com.iamrajendra.canvasdrawing.pojo.Color;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder>{
    List<Color> colors;
    private MutableLiveData<List<Color>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<Color>> getLiveData() {
        return liveData;
    }

    public ColorAdapter(List<Color> colors) {
        this.colors = colors;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,null,false);
        ColorViewHolder viewHolder  = new ColorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.bind(position,ColorAdapter.this);
        liveData.setValue(colors);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.color_adapter;
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }
}