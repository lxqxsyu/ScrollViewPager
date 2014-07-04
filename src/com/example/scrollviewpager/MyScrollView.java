package com.example.scrollviewpager;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class MyScrollView extends HorizontalScrollView{

	private int subChildCount = 0;
	private ViewGroup firstChild = null;
	private int currentPage = 0;
	private ArrayList<Integer> pointList = new ArrayList<Integer>();
	
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setHorizontalScrollBarEnabled(false);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		receiveChildInfo();
	}

	private void receiveChildInfo(){
		firstChild = (ViewGroup) getChildAt(0);
		if(firstChild != null){
			subChildCount = firstChild.getChildCount();
			for(int i=0; i<subChildCount; i++){
				if(firstChild.getChildAt(i).getWidth() > 0){
					pointList.add(firstChild.getChildAt(i).getLeft());
				}
			}
		}
	}
	
	private float mDownX;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mDownX = event.getX();
			break;
		case MotionEvent.ACTION_MOVE:
			
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			if(Math.abs(event.getX() - mDownX) > getWidth() / 4){
				if(event.getX() - mDownX > 0){
					smoothScrollToPrePage();
				}else{
					smoothScrollToNextPage();
				}
			}else{
				smoothScrollToCurrent();
			}
			break;
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
	private void smoothScrollToCurrent(){
		smoothScrollTo(pointList.get(currentPage), 0);
	}
	
	private void smoothScrollToPrePage(){
		if(currentPage < subChildCount - 1){
			currentPage++;
			smoothScrollTo(pointList.get(currentPage), 0);
		}
	}
	
	private void smoothScrollToNextPage(){
		if(currentPage > 0){
			currentPage--;
			smoothScrollTo(pointList.get(currentPage), 0);
		}
	}
	
	public void nextPage(){
		smoothScrollToNextPage();
	}
	
	public void prePage(){
		smoothScrollToPrePage();
	}
	
	public boolean getPage(int page) {
		if (page > 0 && page < subChildCount - 1) {
			smoothScrollTo(pointList.get(page), 0);
			currentPage = page;
			return true;
		}
		return false;
	}
	
}
