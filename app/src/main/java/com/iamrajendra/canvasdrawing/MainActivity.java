package com.iamrajendra.canvasdrawing;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.canvasdrawing.adapter.ColorAdapter;
import com.iamrajendra.canvasdrawing.customview.DrawingView;
import com.iamrajendra.canvasdrawing.pojo.Color;
import com.iamrajendra.canvasdrawing.pojo.Colors;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewColorList;
private ColorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawingView drawingView = findViewById(R.id.drawing);
        recyclerViewColorList = findViewById(R.id.color_list);
        adapter = new ColorAdapter(Colors.getColors());
        recyclerViewColorList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        recyclerViewColorList.setAdapter(adapter);
        adapter.getLiveData().observe(this, new Observer<List<Color>>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onChanged(List<Color> colors) {
                for (Color color:colors){
                    if (color.isSelected()) drawingView.setColor(getApplicationContext().getColor(color.getCode()));
                }
            }
        });


    }
}
