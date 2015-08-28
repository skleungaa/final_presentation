package com.example.final_presentation.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class Workshop extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        getSupportActionBar().hide();
        RelativeLayout workshopRelativeLayout = (RelativeLayout) findViewById(R.id.workshopRelativeLayout);
        workshopRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        workshopRelativeLayout.getBackground().setAlpha(40);
        ListView workshopListView = (ListView) findViewById(R.id.workshopListView);
        ArrayList<String> workshopArrayList = new ArrayList<String>();
        workshopArrayList.add("Lessons Learnt");
        workshopArrayList.add("Our Recommendations");
        Integer[] imageId = {R.drawable.rsz_dot_image};
        CustomList customAdapter = new CustomList(Workshop.this, workshopArrayList, imageId);
        workshopListView.setAdapter(customAdapter);
        workshopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Workshop.this, LessonsLearnt.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(Workshop.this, Recommendations.class);
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
                    Intent intent = new Intent(Workshop.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Workshop.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Toast.makeText(Workshop.this.getApplicationContext(),
                            "You are already in the workshop page", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (i == 3) {
                    Intent intent = new Intent(Workshop.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workshop, menu);
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
        Intent intent = new Intent(Workshop.this, MainList.class);
        startActivity(intent);
    }
}
