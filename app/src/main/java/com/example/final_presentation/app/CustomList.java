package com.example.final_presentation.app;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final ArrayList<String> mainList;
    private final Integer[] imageId;
    public CustomList(Activity context, ArrayList<String> bookingList, Integer[] imageId) {
        super(context, R.layout.list_item, bookingList);
        this.context = context;
        this.mainList = bookingList;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(mainList.get(position));

        imageView.setImageResource(imageId[0]);

        return rowView;
    }
}
