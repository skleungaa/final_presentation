package com.example.final_presentation.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class Recommendations extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        getSupportActionBar().hide();
        RelativeLayout recommendationsRelativeLayout = (RelativeLayout) findViewById(R.id.recommendationsRelativeLayout);
        recommendationsRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        recommendationsRelativeLayout.getBackground().setAlpha(40);
        ListView recommendationsListView = (ListView) findViewById(R.id.recommendationsListView);
        ArrayList<String> recommendationsArrayList = new ArrayList<String>();
        recommendationsArrayList.add("Preparation");
        recommendationsArrayList.add("Class");
        recommendationsArrayList.add("After Event (follow-up)");
        recommendationsArrayList.add("Your Actions");
        Integer[] imageId = {R.drawable.rsz_dot_image};
        CustomList customAdapter = new CustomList(Recommendations.this, recommendationsArrayList, imageId);
        recommendationsListView.setAdapter(customAdapter);
        recommendationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Recommendations.this, Preparation.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Recommendations.this, Class1.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(Recommendations.this, AfterEvent.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Recommendations.this, CallForActions.class);
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
                    Intent intent = new Intent(Recommendations.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Recommendations.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(Recommendations.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Recommendations.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recommendations, menu);
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
        Intent intent = new Intent(Recommendations.this, Workshop.class);
        startActivity(intent);
    }
}
