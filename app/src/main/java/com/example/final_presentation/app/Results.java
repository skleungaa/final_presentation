package com.example.final_presentation.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class Results extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getSupportActionBar().hide();
        RelativeLayout resultsRelativeLayout = (RelativeLayout) findViewById(R.id.resultsRelativeLayout);
        resultsRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        resultsRelativeLayout.getBackground().setAlpha(40);
        ArrayList resultsArrayList = new ArrayList();
        resultsArrayList.add("KPI");
        resultsArrayList.add("Video");
        resultsArrayList.add("Bill Interview");
        Integer[] imageId = {R.drawable.rsz_dot_image};
        CustomList customAdapter = new CustomList(Results.this, resultsArrayList, imageId);
        ListView resultsListView = (ListView) findViewById(R.id.resultsListView);
        resultsListView.setAdapter(customAdapter);
        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Results.this, KPI.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(Results.this, Video.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(Results.this, BillInterview.class);
                    startActivity(intent);
                }
            }
        });

        ListView drawerListView = (ListView) findViewById(R.id.drawer_list);
        ArrayList drawerArrayList = new ArrayList();
        drawerArrayList.add("Objectives");
        drawerArrayList.add("Results");
        drawerArrayList.add("Workshop");
        drawerArrayList.add("Gallery");
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, drawerArrayList));
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Results.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Toast.makeText(Results.this.getApplicationContext(),
                            "You are already in the results page", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (i == 2) {
                    Intent intent = new Intent(Results.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Results.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Results.this, MainList.class);
        startActivity(intent);
    }
}
