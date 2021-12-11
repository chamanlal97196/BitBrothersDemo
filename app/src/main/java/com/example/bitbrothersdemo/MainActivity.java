package com.example.bitbrothersdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btnsingOut;
    RecyclerView recyclerView;
    Button list,grid;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsingOut=findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();

        //
        recyclerView=findViewById(R.id.recyclerView);
//        list=findViewById(R.id.list);
//        grid=findViewById(R.id.grid);
        ArrayList<Data> data=new ArrayList<>();
        data.add(new Data("Convocation",R.drawable.convocation));
        data.add(new Data("Sports Fest",R.drawable.sports));
        data.add(new Data("TechFest",R.drawable.techfest));
        data.add(new Data("Independence Day",R.drawable.independence));
        data.add(new Data("Republic Day",R.drawable.republic));
        data.add(new Data("Convocation",R.drawable.convocation));


        DataAdapter adapter=new DataAdapter(this,data);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);

//        list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                recyclerView.setLayoutManager(linearLayoutManager);
//            }
//        });
//        grid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                recyclerView.setLayoutManager(gridLayoutManager);
//            }
//        });


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        //






        btnsingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logging Out", Toast.LENGTH_SHORT).show();
                auth.signOut();
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });
    }
}