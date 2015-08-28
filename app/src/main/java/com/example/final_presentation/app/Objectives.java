package com.example.final_presentation.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class Objectives extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);
        getSupportActionBar().hide();
        RelativeLayout objectivesRelativeLayout = (RelativeLayout) findViewById(R.id.objectivesRelativeLayout);
        objectivesRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        objectivesRelativeLayout.getBackground().setAlpha(40);

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
                    Toast.makeText(Objectives.this.getApplicationContext(),
                            "You are already in the objectives page", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (i == 1) {
                    Intent intent = new Intent(Objectives.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(Objectives.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Objectives.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_objectives, menu);
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
        Intent intent = new Intent(Objectives.this, MainList.class);
        startActivity(intent);
    }
}
