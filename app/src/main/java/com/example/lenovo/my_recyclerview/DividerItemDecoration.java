package com.example.lenovo.my_recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] ATTRS=new int[]{
            android.R.attr.listDivider
    };
    public static final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST=LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int mOrientation;
    public DividerItemDecoration(Context context,int orientation){
        final TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDivider=a.getDrawable(0);
        a.recycle();
        try {
            setOrientation(orientation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setOrientation(int orientation) throws IllegalAccessException {
        if(orientation!=HORIZONTAL_LIST&&orientation!=VERTICAL_LIST){
            throw new IllegalAccessException("invalid orientation");

        }
        mOrientation=orientation;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent) {
        if(mOrientation==VERTICAL_LIST){
            drawVertical(c,parent);
        }else{
            drawHorizonal(c,parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {

        final int left=parent.getPaddingLeft();
        final int right=parent.getWidth()-parent.getPaddingRight();
        final  int ChildCount=parent.getChildCount();
        for(int i=0;i<ChildCount;i++){
            //在集合中返回指定位置的视图
            final View child=parent.getChildAt(i);
            //布局参数
            final RecyclerView.LayoutParams params=(RecyclerView.LayoutParams)child.getLayoutParams();
            final int top=child.getBottom()+params.bottomMargin;
            final int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    public void drawHorizonal(Canvas c,RecyclerView parent){
        final int top=parent.getPaddingTop();
        final int bottom=parent.getHeight()-parent.getPaddingBottom();
        final int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            final View child=parent.getChildAt(i);
            final RecyclerView.LayoutParams params=(RecyclerView.LayoutParams)child.getLayoutParams();
            final int left=child.getRight()+params.rightMargin;
            final int right=left+mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
       if(mOrientation==VERTICAL_LIST){
           outRect.set(0,0,0,mDivider.getIntrinsicHeight());
       }else{
           outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
       }
    }
}
