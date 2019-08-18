package com.example.lenovo.my_recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HomeAdapter mHomeAdapter;
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();
        RecyclerView mRecyclerView=this.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置item增加和删除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeAdapter=new HomeAdapter(this,mList);
        mRecyclerView.addItemDecoration(new DividerItemDecoration
                (MainActivity.this,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    private void init() {
        mList=new ArrayList<String>();
        for(int i=0;i<50;i++){
            mList.add("content"+i);
        }
    }

}
