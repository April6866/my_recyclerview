package com.example.lenovo.my_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<String> mList;
    private Context mContext;
    public HomeAdapter(Context mContext,List<String> mList){
       this.mContext=mContext;
       this.mList=mList;

    }
    public HomeAdapter(){
        mList=new ArrayList<String>();
        for(int i=1;i<=50;i++){
            mList.add(String.valueOf(i));
        }
    }
    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.item_recycler,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
          holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(@NonNull View View) {

            super(View);
            tv= View.findViewById(R.id.tv_item);
        }
    }
}
