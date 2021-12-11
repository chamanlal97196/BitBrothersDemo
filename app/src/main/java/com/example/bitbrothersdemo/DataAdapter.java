package com.example.bitbrothersdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    Context context;
    ArrayList<Data> data;


    public DataAdapter(Context context,ArrayList<Data> data){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.sample_row,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
       Data datas =data.get(position);
       holder.imageView.setImageResource(datas.getImg());
       holder.title.setText(datas.getTitle());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,Page2.class);
               intent.putExtra("dat",datas.getTitle());
               context.startActivity(intent);

           }
       });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class DataViewHolder extends RecyclerView.ViewHolder{
      ImageView imageView;
      TextView title;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.textView);

        }
    }
}
