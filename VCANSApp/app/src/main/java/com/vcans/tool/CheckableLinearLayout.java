package com.vcans.tool;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CheckableLinearLayout extends RelativeLayout implements Checkable {
	private boolean mChecked;

	public CheckableLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setChecked(boolean checked) {
		mChecked = checked;
		setBackgroundDrawable(checked ? new ColorDrawable(0xff9CD3AE) : null);//9CD3AE
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public void toggle() {
		setChecked(!mChecked);
	}

	
	
}
