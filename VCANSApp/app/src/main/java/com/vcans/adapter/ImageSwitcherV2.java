package com.vcans.adapter;

import com.Vcan.activity.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher;


public class ImageSwitcherV2 extends ViewSwitcher
{
	ImageView image;
	private int imageWidth;
	private int imageHeight;
	private float fScale;
	
    public void setScale(float f)
    {
	   fScale=f;
    }
	
	public int getImageWidth() {
		return imageWidth;
	}

	public void setWidth(int width) {
		this.imageHeight = width;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setHeight(int height) {
		this.imageHeight = height;
	}

	private int innerWidth;
	public int getInnerWidth() {
		return innerWidth;
	}

	//public void setInnerWidth(int innerWidth) {
	//	this.innerWidth = innerWidth;
	//}

	public int getInnerHeight() {
		return innerHeight;
	}

	//public void setInnerHeight(int innerHeight) {
	//	this.innerHeight = innerHeight;
	//}

	private int innerHeight;
	
	
    public ImageSwitcherV2(Context context)
    {
        super(context);
    }
    
    public ImageSwitcherV2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setImageResource(int resid)
    {
        image = (ImageView)this.getNextView();
        image.setImageResource(resid);
        showNext();
    }

    public void setImageURI(Uri uri)
    {
        image = (ImageView)this.getNextView();
        image.setImageURI(uri);
        showNext();
    }

    public void setImageDrawable(Drawable drawable)
    {
        image = (ImageView)this.getNextView();
        image.setScaleType(ScaleType.CENTER_CROP);
        image.setImageDrawable(drawable);
        
        innerWidth=drawable.getIntrinsicWidth();
        innerHeight=drawable.getIntrinsicWidth();
        
        new Handler().postDelayed(new Runnable(){

			public void run() {
				
				imageWidth=image.getWidth();
		        imageHeight=image.getHeight();
		     
			}	 
        }, 500);
        
        
        
        showNext();   
    }
    
 
    
    public void setImageMatrix(Matrix matrix)
    {
    	image.setImageMatrix(matrix);

    }
    
    public Matrix getImageMatrix()
    {
    	return image.getImageMatrix();
    }
    
    public void setScaleType(ScaleType scaleType)
    {
    	image.setScaleType(scaleType);
    }
}

