package com.example.final_presentation.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.VideoView;


public class BillInterview extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_interview);
        getSupportActionBar().hide();
        RelativeLayout billInterviewRelativeLayout = (RelativeLayout) findViewById(R.id.billInterviewRelativeLayout);
        billInterviewRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        billInterviewRelativeLayout.getBackground().setAlpha(40);
        VideoView billInterviewVideo = (VideoView) findViewById(R.id.billInterviewVideo);
        billInterviewVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bill_interview_480p));
        billInterviewVideo.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bill_interview, menu);
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
        Intent intent = new Intent(BillInterview.this, Results.class);
        startActivity(intent);
    }
}
