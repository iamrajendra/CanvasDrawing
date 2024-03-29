package com.iamrajendra.canvasdrawing.pojo;

import com.iamrajendra.canvasdrawing.R;

import java.util.ArrayList;
import java.util.List;

public class Colors {
    public static List<Color> getColors(){
        List<Color>  colorList  = new ArrayList<>();

        colorList.add(new Color(1,"red", R.color.md_red_500));
        colorList.add(new Color(2,"blue", R.color.md_blue_500));
        colorList.add(new Color(3,"green", R.color.md_green_500));
        colorList.add(new Color(4,"yellow", R.color.md_yellow_500));
        colorList.add(new Color(5,"orange", R.color.md_orange_500));
        colorList.add(new Color(6,"lime", R.color.md_lime_500));
        colorList.add(new Color(6,"teal", R.color.md_teal_500));
        return colorList;
    }
}
