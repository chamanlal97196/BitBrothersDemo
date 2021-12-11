package com.example.bitbrothersdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Page2 extends AppCompatActivity {
 RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        recyclerView2=findViewById(R.id.recyclerView2);


        ArrayList<Data> data2=new ArrayList<>();
        data2.add(new Data("Convocation",R.drawable.convocation));
        data2.add(new Data("Sports Fest",R.drawable.sports));
        data2.add(new Data("TechFest",R.drawable.techfest));
        data2.add(new Data("Independence Day",R.drawable.independence));
        data2.add(new Data("Republic Day",R.drawable.republic));
        data2.add(new Data("Convocation",R.drawable.convocation));


        DataAdapter adapter2=new DataAdapter(this,data2);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setAdapter(adapter2);

    }
}