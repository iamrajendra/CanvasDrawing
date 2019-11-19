package com.iamrajendra.canvasdrawing.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private int pos;
    private ColorAdapter adapter;

    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        invertList(adapter.colors,pos);
        adapter.notifyDataSetChanged();

    }

    private void invertList(List<com.iamrajendra.canvasdrawing.pojo.Color> colors, int pos) {
        for (int i = 0; i < colors.size(); i++) {

            if (i==pos) {
                colors.get(i).setSelected(true);
            }else {
                colors.get(i).setSelected(false);

            }
        }
    }

    public void bind(int position, ColorAdapter colorAdapter) {
        pos = position;
        adapter = colorAdapter;
        GradientDrawable drawable = (GradientDrawable) itemView.getBackground().mutate();
        if (colorAdapter.colors.get(position).isSelected()) drawable.setStroke(10, android.graphics.Color.BLACK);
        else drawable.setStroke(10, Color.TRANSPARENT);
        drawable.setColor(itemView.getContext().getResources().getColor(colorAdapter.colors.get(position).getCode()));
    }
}
