package com.example.administrator.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("My Title");
        toolbar.setSubtitle("Sub title");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvToDoList);
        LinearLayoutManager m = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(m);
        recyclerView.setAdapter(new Vh());
    }

     class Vh extends RecyclerView.Adapter<ViewHo>{

        @Override
        public ViewHo onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHo(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHo holder, int position) {
            holder.textView.setText(position+"A");

        }

        @Override
        public int getItemCount() {
            return 50;
        }
    }


    class ViewHo extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHo(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                }
            });

        }
    }
}
