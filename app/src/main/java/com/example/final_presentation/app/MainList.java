package com.example.final_presentation.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class MainList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        getSupportActionBar().hide();
        RelativeLayout mainListLayout = (RelativeLayout) findViewById(R.id.mainListLayout);
        mainListLayout.setBackgroundResource(R.drawable.rsz_androids);
        mainListLayout.getBackground().setAlpha(40);
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        ArrayList<String> mainArrayList = new ArrayList<String>();
        mainArrayList.add("Objectives");
        mainArrayList.add("Results");
        mainArrayList.add("Workshop");
        mainArrayList.add("Gallery");
        Integer[] imageId = {R.drawable.rsz_dot_image};
        CustomList customAdapter = new CustomList(MainList.this, mainArrayList, imageId);
        mainListView.setAdapter(customAdapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainList.this, Objectives.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainList.this, Results.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MainList.this, Workshop.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(MainList.this, GalleryList.class);
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
                    Intent intent = new Intent(MainList.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(MainList.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(MainList.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(MainList.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_list, menu);
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
        Intent intent = new Intent(MainList.this, HomePage.class);
        startActivity(intent);
    }
}
