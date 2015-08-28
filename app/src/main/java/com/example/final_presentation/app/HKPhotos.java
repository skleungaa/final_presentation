package com.example.final_presentation.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class HKPhotos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hkphotos);
        getSupportActionBar().hide();
        RelativeLayout hkPhotosRelativeLayout = (RelativeLayout) findViewById(R.id.hkPhotosRelativeLayout);
        hkPhotosRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        hkPhotosRelativeLayout.getBackground().setAlpha(40);
        Button hkPhotosButton = (Button) findViewById(R.id.hkPhotosButton);
        hkPhotosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://esquel-my.sharepoint.com/personal/chengma_esquel_com/Documents/App%20inventor%20fun%20day%20photo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
                    Intent intent = new Intent(HKPhotos.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(HKPhotos.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(HKPhotos.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(HKPhotos.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hkphotos, menu);
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
        Intent intent = new Intent(HKPhotos.this, GalleryList.class);
        startActivity(intent);
    }
}
