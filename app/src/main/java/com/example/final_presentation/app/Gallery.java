package com.example.final_presentation.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;


public class Gallery extends ActionBarActivity {
    private Integer[] imageId = {R.drawable.hr_of_code1, R.drawable.hr_of_code2, R.drawable.hr_of_code3, R.drawable.hr_of_code4,
    R.drawable.hr_of_code5, R.drawable.hr_of_code6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().hide();
        RelativeLayout galleryRelativeLayout = (RelativeLayout) findViewById(R.id.galleryRelativeLayout);
        galleryRelativeLayout.setBackgroundResource(R.drawable.rsz_androids);
        galleryRelativeLayout.getBackground().setAlpha(40);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(customPagerAdapter);

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
                    Intent intent = new Intent(Gallery.this, Objectives.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Gallery.this, Results.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(Gallery.this, Workshop.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(Gallery.this, GalleryList.class);
                    startActivity(intent);
                }
            }
        });
    }

    class CustomPagerAdapter extends PagerAdapter {
        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imageId.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == ((LinearLayout) o);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(imageId[position]);
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
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
        Intent intent = new Intent(Gallery.this, GalleryList.class);
        startActivity(intent);
    }
}
