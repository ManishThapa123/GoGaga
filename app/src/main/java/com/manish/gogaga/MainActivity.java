package com.manish.gogaga;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();

    BottomNavigationView bottomNav;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView txtName, txtPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.dp4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.dp, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.dp1, ScaleTypes.FIT));

        imageSlider.setImageList(imageList,ScaleTypes.FIT);




        bottomNav = findViewById(R.id.bottomNav);
        txtName = findViewById(R.id.textView1);
        txtName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_birthday,0,0,0);
//        txtName.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_birthday,0,0,0);
        txtPlace = findViewById(R.id.textView2);
      txtPlace.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_location,0,0,0);

        drawerLayout = findViewById(R.id.navDrawer);
//        drawerLayout.closeDrawers();
        navigationView = findViewById(R.id.navView);
        toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
//        drawerLayout.closeDrawer(GravityCompat.START);

        getImages();

    }
    private void getImages(){
        mImages.add(R.drawable.metal);
        mNames.add("Metallica");

        mImages.add(R.drawable.austin);
        mNames.add("Austin Moore");

        mImages.add(R.drawable.drake);
        mNames.add("K-Drake");

        mImages.add(R.drawable.techno);
        mNames.add("Techno");

        mImages.add(R.drawable.art);
        mNames.add("Myntra");

        mImages.add(R.drawable.eminem);
        mNames.add("Hip-Hop");

        mImages.add(R.drawable.rock);
        mNames.add("Rock & Blues");

        initRecyclerView();

    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(mNames,mImages,this);
        recyclerView.setAdapter(adapter);
    }
}