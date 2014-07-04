package com.example.scrollviewpager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
/**
 * 
 * @author xinye
 *
 */
public class MainActivity extends Activity {
    private LinearLayout mContainer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mContainer = (LinearLayout) findViewById(R.id.container);
        
        LayoutParams params = new LayoutParams(getWinWidth(), getWinHeight());
        
        ImageView imageView1 = new ImageView(this);
        imageView1.setLayoutParams(params);
        imageView1.setImageResource(R.drawable.call_show_medal5);
        imageView1.setScaleType(ScaleType.CENTER);
        mContainer.addView(imageView1);
        
        ImageView imageView2 = new ImageView(this);
        imageView2.setLayoutParams(params);
        imageView2.setImageResource(R.drawable.call_show_medal1);
        imageView2.setScaleType(ScaleType.CENTER);
        imageView2.setBackgroundColor(Color.RED);
        mContainer.addView(imageView2);
        
        ImageView imageView3 = new ImageView(this);
        imageView3.setLayoutParams(params);
        imageView3.setImageResource(R.drawable.call_show_medal2);
        imageView3.setScaleType(ScaleType.CENTER);
        imageView3.setBackgroundColor(Color.GRAY);
        mContainer.addView(imageView3);
        
        
        ImageView imageView4 = new ImageView(this);
        imageView4.setLayoutParams(params);
        imageView4.setImageResource(R.drawable.call_show_medal3);
        imageView4.setScaleType(ScaleType.CENTER);
        imageView4.setBackgroundColor(Color.BLUE);
        mContainer.addView(imageView4);
        
        
        ImageView imageView5 = new ImageView(this);
        imageView5.setLayoutParams(params);
        imageView5.setImageResource(R.drawable.call_show_medal4);
        imageView5.setScaleType(ScaleType.CENTER);
        imageView5.setBackgroundColor(Color.GREEN);
        mContainer.addView(imageView5);
        
        
        
    }
    
    @Override
    protected void onResume() {
//        ((MyScrollView)mContainer.getParent()).init();
        super.onResume();
    }
    
    private int getWinWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
    private int getWinHeight(){
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}